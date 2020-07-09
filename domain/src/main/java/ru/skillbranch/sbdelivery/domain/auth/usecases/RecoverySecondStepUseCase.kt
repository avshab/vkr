package ru.skillbranch.sbdelivery.domain.auth.usecases

import ru.skillbranch.sbdelivery.domain.auth.gateway.LoginGateway

class RecoverySecondStepUseCase(private val gateway: LoginGateway) {

    fun build(email: String, code: String) = gateway.recoverySecondStep(email = email, code = code)
}