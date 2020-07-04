package ru.skillbranch.sbdelivery.data.auth.gateways

import io.reactivex.Completable
import ru.skillbranch.sbdelivery.data.auth.storage.UserAuthStorage
import ru.skillbranch.sbdelivery.domain.auth.gateway.LogoutGateway

/**
 * Created by Anna Shabaeva on 02.07.2020
 */

class LogoutGatewayImpl(
    private val authStorage: UserAuthStorage
  //  private val pinCodeGateway: PinCodeGateway

) : LogoutGateway {

    override fun logoutUser(): Completable {

        return authStorage.delete()
    }

}