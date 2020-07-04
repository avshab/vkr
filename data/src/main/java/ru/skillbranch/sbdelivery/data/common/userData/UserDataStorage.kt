package ru.skillbranch.sbdelivery.data.common.userData

import ru.skillbranch.sbdelivery.domain.userData.model.UserDataModel

/**
 * Created by Anna Shabaeva on 03.07.2020
 */
interface UserDataStorage {

    fun getUserData(): UserDataModel?

    fun saveUserDataModel(userdata: UserDataModel)
}