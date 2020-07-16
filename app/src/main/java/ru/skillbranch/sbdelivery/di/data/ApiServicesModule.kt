package ru.skillbranch.sbdelivery.di.data

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create
import ru.skillbranch.sbdelivery.data.auth.api.AuthApiService
import ru.skillbranch.sbdelivery.data.dashboard.api.DashboardApiService
import ru.skillbranch.sbdelivery.data.dish.api.DishApiService
import ru.skillbranch.sbdelivery.data.menu.api.CategoriesApiService
import ru.skillbranch.sbdelivery.data.profile.api.ProfileApiService
import ru.skillbranch.sbdelivery.di.data.qualifiers.AuthenticationApi

/**
 * Created by Anna Shabaeva on 07.06.2020
 */

@Module
class ApiServicesModule {

    @Provides
    fun provideDashboardApiService(retrofit: Retrofit): DashboardApiService = retrofit.create()

    @Provides
    @AuthenticationApi
    fun provideAuthApiService(@AuthenticationApi retrofit: Retrofit): AuthApiService =
        retrofit.create()

    @Provides
    fun provideLoginApiService(retrofit: Retrofit): AuthApiService = retrofit.create()

    @Provides
    fun provideProfileApiService(retrofit: Retrofit): ProfileApiService = retrofit.create()

    @Provides
    fun provideCategoriesApiService(retrofit: Retrofit): CategoriesApiService = retrofit.create()

    @Provides
    fun provideDishApiService(retrofit: Retrofit): DishApiService = retrofit.create()
}