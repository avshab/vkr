package ru.skillbranch.sbdelivery.data.common.userData

import ru.skillbranch.sbdelivery.domain.userData.model.UserDataModel

/**
 * Created by Anna Shabaeva on 03.07.2020
 */

class UserDataStorageImpl: UserDataStorage {

    private var userDataModel: UserDataModel? = null

    override fun getUserData(): UserDataModel? = userDataModel

    override fun saveUserDataModel(userdata: UserDataModel) {
        userDataModel = userdata
    }
}