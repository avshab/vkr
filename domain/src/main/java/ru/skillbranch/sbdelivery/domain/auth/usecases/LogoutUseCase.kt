package ru.skillbranch.sbdelivery.domain.auth.usecases

import io.reactivex.Completable
import ru.skillbranch.sbdelivery.domain.auth.gateway.LogoutGateway

/**
 * Created by Anna Shabaeva on 02.07.2020
 */
class LogoutUseCase (
    private val logoutGateway: LogoutGateway
) {

    fun buildCompletable(): Completable {
        return logoutGateway.logoutUser()
    }
}
