package ru.skillbranch.sbdelivery.di.data

import dagger.Module
import dagger.Provides
import ru.skillbranch.sbdelivery.data.common.api.BaseResponseMapper
import ru.skillbranch.sbdelivery.data.common.api.ResponseErrorBodyConverter
import ru.skillbranch.sbdelivery.di.app.AppScope
import ru.skillbranch.sbdelivery.di.data.qualifiers.AuthenticationApi

/**
 * Created by Anna Shabaeva on 07.06.2020
 */

@Module
class MappersModule {

    @Provides
    @AppScope
    fun provideBaseResponseMapper(errorBodyConverter: ResponseErrorBodyConverter) = BaseResponseMapper(errorBodyConverter)
}