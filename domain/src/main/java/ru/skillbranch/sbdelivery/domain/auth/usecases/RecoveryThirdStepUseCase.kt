package ru.skillbranch.sbdelivery.domain.auth.usecases

import ru.skillbranch.sbdelivery.domain.auth.gateway.LoginGateway

class RecoveryThirdStepUseCase(private val gateway: LoginGateway) {

    fun build(email: String, code: String, password: String) =
        gateway.recoveryThirdStep(email = email, code = code, password = password)
}