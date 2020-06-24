package ru.skillbranch.sbdelivery.data.api.interceptors

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import ru.skillbranch.sbdelivery.utils.exceptions.NoConnectionException
import ru.skillbranch.sbdelivery.utils.exceptions.ServiceUnavailableException
import ru.skillbranch.sbdelivery.utils.exceptions.UnspecifiedException
import ru.skillbranch.sbdelivery.utils.exceptions.defaultIfNull
import ru.skillbranch.sbdelivery.utils.interceptor.ConnectionChecker
import java.net.SocketTimeoutException

/**
 * Created by Anna Shabaeva on 05.06.2020
 */
class ErrorInterceptor(
    private val connectionChecker: ConnectionChecker
) : Interceptor {

    private companion object {
        const val SERVICE_UNAVAILABLE_ERROR = 503
    }

    override fun intercept(chain: Interceptor.Chain): Response {

        if (connectionChecker.isConnected().not()) {
            throw NoConnectionException()
        }
        return try {
            val response = chain.proceed(chain.request())
            if (response.code() == SERVICE_UNAVAILABLE_ERROR) {
                throw ServiceUnavailableException()
            }
            response
        } catch (throwable: Throwable) {
            if (throwable is ServiceUnavailableException) {
                throw throwable
            }
            if (throwable is SocketTimeoutException) {
                Log.i("--TAG", throwable.message)
                throw throwable
            } else {
                logWrapping(NoConnectionException::class.java, throwable)
                throw wrapException(throwable)
            }
        }
    }

    private fun wrapException(error: Throwable): RuntimeException {
        return UnspecifiedException(error)
    }

    private fun <T : IllegalStateException> logWrapping(
        wrappedToClass: Class<T>,
        originalError: Throwable? = null
    ) {
        Log.e ("--TAG", "Exception was wrapped into ${originalError?.message.defaultIfNull}" )
    }
}
