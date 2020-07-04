package ru.skillbranch.sbdelivery.domain.auth.usecases

import io.reactivex.Observable
import ru.skillbranch.sbdelivery.domain.auth.gateway.LoginGateway
import ru.skillbranch.sbdelivery.domain.auth.model.AuthModel

/**
 * Created by Anna Shabaeva on 03.07.2020
 */
class ObserveUserAuthStatusUseCase(
    private val loginGateway: LoginGateway
) {

    fun buildObservable(): Observable<Boolean> {
        return loginGateway
            .observeUserAuth()
            .map(AuthModel::isNotEmpty)
    }

}