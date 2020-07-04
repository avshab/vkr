package ru.skillbranch.sbdelivery.domain.profile.gateways

import io.reactivex.Single
import ru.skillbranch.sbdelivery.domain.userData.model.UserDataModel

/**
 * Created by Anna Shabaeva on 03.07.2020
 */

interface ProfileGateway {

    fun getAndUpdateProfile() : Single<UserDataModel>
}