package ru.skillbranch.sbdelivery.data.profile.gateways

import io.reactivex.Single
import ru.skillbranch.sbdelivery.data.common.userData.UserDataStorage
import ru.skillbranch.sbdelivery.data.profile.api.ProfileApiService
import ru.skillbranch.sbdelivery.domain.profile.gateways.ProfileGateway
import ru.skillbranch.sbdelivery.domain.userData.model.UserDataModel

/**
 * Created by Anna Shabaeva on 03.07.2020
 */

class ProfileGatewayImpl(
    private val profileApiService: ProfileApiService,
    private val userDataStorage: UserDataStorage
) : ProfileGateway {

    override fun getAndUpdateProfile(): Single<UserDataModel> {
        return profileApiService.profile().map { response ->
            with(response) {
                UserDataModel(id, firstName, lastName, email)
            }
        }.doOnSuccess(userDataStorage::saveUserDataModel)
    }
}