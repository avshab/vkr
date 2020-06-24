package ru.skillbranch.sbdelivery.utils.exceptions.messages

import ru.skillbranch.sbdelivery.utils.R
import ru.skillbranch.sbdelivery.utils.exceptions.NoConnectionException
import ru.skillbranch.sbdelivery.utils.exceptions.ServiceUnavailableException
import ru.skillbranch.sbdelivery.utils.resources.ResourcesManager
import java.net.SocketTimeoutException

/**
 * Created by Anna Shabaeva on 06.06.2020
 */

open class DefaultErrorMessageFactory(
    protected val resourcesManager: ResourcesManager
) : ErrorMessageFactory {

    override fun buildErrorMessage(exception: Throwable): String {
        return when (exception) {
            is NoConnectionException -> {
                resourcesManager.getString(R.string.error_no_internet_occurred)
            }
            is SocketTimeoutException -> {
                resourcesManager.getString(R.string.error_connection_timeout)
            }
            is ServiceUnavailableException -> {
                resourcesManager.getString(R.string.error_service_unavailable)
            }
            else -> resourcesManager.getString(R.string.error_unspecified_occurred)
        }
    }

}