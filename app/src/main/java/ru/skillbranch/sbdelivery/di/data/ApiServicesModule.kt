package ru.skillbranch.sbdelivery.di.data

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create
import ru.skillbranch.sbdelivery.data.auth.api.AuthApiService
import ru.skillbranch.sbdelivery.data.dashboard.api.DashboardApiService

/**
 * Created by Anna Shabaeva on 07.06.2020
 */

@Module
class ApiServicesModule {

    @Provides
    fun provideDashboardApiService(retrofit: Retrofit): DashboardApiService = retrofit.create()

    @Provides
    fun provideAuthApiService(retrofit: Retrofit): AuthApiService = retrofit.create()
}