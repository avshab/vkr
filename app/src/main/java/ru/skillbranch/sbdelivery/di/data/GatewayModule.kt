package ru.skillbranch.sbdelivery.di.data

import dagger.Module
import dagger.Provides
import ru.skillbranch.sbdelivery.data.auth.api.AuthApiService
import ru.skillbranch.sbdelivery.data.auth.storage.UserAuthStorage
import ru.skillbranch.sbdelivery.data.auth.gateways.LoginGatewayImpl
import ru.skillbranch.sbdelivery.data.auth.gateways.LogoutGatewayImpl
import ru.skillbranch.sbdelivery.data.common.api.BaseResponseMapper
import ru.skillbranch.sbdelivery.data.common.userData.UserDataStorage
import ru.skillbranch.sbdelivery.data.dashboard.api.DashboardApiService
import ru.skillbranch.sbdelivery.data.dashboard.gateways.DashboardGatewayImpl
import ru.skillbranch.sbdelivery.data.dish.api.DishApiService
import ru.skillbranch.sbdelivery.data.dish.gateways.DishGatewayImpl
import ru.skillbranch.sbdelivery.data.menu.api.CategoriesApiService
import ru.skillbranch.sbdelivery.data.menu.gateways.MenuGatewayImpl
import ru.skillbranch.sbdelivery.data.profile.api.ProfileApiService
import ru.skillbranch.sbdelivery.data.profile.gateways.ProfileGatewayImpl
import ru.skillbranch.sbdelivery.di.data.qualifiers.AuthenticationApi
import ru.skillbranch.sbdelivery.domain.auth.gateway.LoginGateway
import ru.skillbranch.sbdelivery.domain.auth.gateway.LogoutGateway
import ru.skillbranch.sbdelivery.domain.dashboard.gateways.DashboardGateway
import ru.skillbranch.sbdelivery.domain.dish.gateways.DishGateway
import ru.skillbranch.sbdelivery.domain.menu.gateways.MenuGateway
import ru.skillbranch.sbdelivery.domain.profile.gateways.ProfileGateway

/**
 * Created by Anna Shabaeva on 07.06.2020
 */

@Module
class GatewayModule {

    @Provides
    fun provideDashboardGateway(
        apiService: DashboardApiService,
        mapper: BaseResponseMapper
    ): DashboardGateway = DashboardGatewayImpl(
        apiService = apiService,
        mapper = mapper
    )

    @Provides
    fun provideLoginGateway(
        apiService: AuthApiService,
        userAuthStorage: UserAuthStorage,
        userDataStorage: UserDataStorage
    ): LoginGateway =
        LoginGatewayImpl(
            authApiService = apiService,
            userAuthStorage = userAuthStorage,
            userDataStorage = userDataStorage
        )

    @Provides
    @AuthenticationApi
    fun provideAuthLoginGateway(
        @AuthenticationApi apiService: AuthApiService,
        userAuthStorage: UserAuthStorage,
        userDataStorage: UserDataStorage
    ): LoginGateway =
        LoginGatewayImpl(
            authApiService = apiService,
            userAuthStorage = userAuthStorage,
            userDataStorage = userDataStorage
        )

    @Provides
    fun provideLogoutGateway(authStorage: UserAuthStorage): LogoutGateway =
        LogoutGatewayImpl(authStorage = authStorage)

    @Provides
    fun provideProfileGateway(
        profileApiService: ProfileApiService,
        userDataStorage: UserDataStorage
    ): ProfileGateway =
        ProfileGatewayImpl(profileApiService = profileApiService, userDataStorage = userDataStorage)

    @Provides
    fun provideMenuGateway(
        apiService: CategoriesApiService,
        mapper: BaseResponseMapper
    ): MenuGateway = MenuGatewayImpl(
        apiService = apiService,
        mapper = mapper
    )

    @Provides
    fun provideDishGateway(
        apiService: DishApiService,
        mapper: BaseResponseMapper
    ): DishGateway = DishGatewayImpl(
        apiService = apiService,
        mapper = mapper
    )
}