package ru.skillbranch.sbdelivery.domain.auth.usecases

import ru.skillbranch.sbdelivery.domain.auth.gateway.LoginGateway

/**
 * Created by Anna Shabaeva on 09.07.2020
 */

class RecoveryFirstStepUseCase(private val gateway: LoginGateway) {

    fun build(email: String) = gateway.recoveryFirstStep(email = email)
}
