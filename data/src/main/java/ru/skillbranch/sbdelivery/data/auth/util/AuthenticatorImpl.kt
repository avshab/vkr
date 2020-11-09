package ru.skillbranch.sbdelivery.data.auth.util

import android.util.Log
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import ru.skillbranch.sbdelivery.domain.auth.gateway.LoginGateway
import ru.skillbranch.sbdelivery.utils.exceptions.EMPTY_STRING

/**
 * Created by Anna Shabaeva on 01.07.2020
 */


class AuthenticatorImpl(
    private val loginGateway: LoginGateway,
    private val forceLogoutAction: () -> Unit

) : Authenticator {

    private companion object {
        /**
         * The number of attempts to authenticate User after getting 401.
         */
        const val RETRY_COUNT = 2
    }

    @Synchronized
    override fun authenticate(route: Route?, response: Response): Request? {
        val attemptsMade = getPriorAttemptsCount(response)

        if (attemptsMade >= RETRY_COUNT) {
            forceLogoutAction()
            return null
        }

        //TODO add refresh
        val newAccessToken = try {
            loginGateway.refreshUserAuth().blockingGet()
        } catch (exc: Exception) {
            Log.e("--TAG", exc.message)
            EMPTY_STRING
        }

        return if (!newAccessToken.isNullOrEmpty()) {
            rebuildRequest(response, newAccessToken)
        } else {
            handleRefreshFailure(attemptsMade, response)
        }
    }

    /**
     * Return old request unchanged due to error of auth refreshing.
     */
    private fun handleRefreshFailure(
        attemptsMade: Int,
        response: Response
    ): Request {
        return response.request()
    }

    /**
     * Rebuild failed request with updated Authorization header.
     */
    private fun rebuildRequest(
        response: Response,
        newAuthToken: String
    ): Request {

        val newRequest = response
            .request()
            .newBuilder()
            .removeHeader(AUTH_HEADER_NAME)
            .build()

        val newAuthHeaderValue = buildAuthHeaderValue(newAuthToken)

       // Timber.w { "New Auth Header: $newAuthHeaderValue" }

        return newRequest
            .newBuilder()
            .addHeader(AUTH_HEADER_NAME, newAuthHeaderValue)
            .addHeader(AUTH_HEADER_NAME, newAuthToken)
            .build()
    }

    private fun getPriorAttemptsCount(failedResponse: Response): Int {
        var priorResponse: Response? = failedResponse.priorResponse() ?: return 0

        var result = 0
        while (priorResponse != null) {
            priorResponse = priorResponse.priorResponse()
            result++
        }

        return result
    }

}