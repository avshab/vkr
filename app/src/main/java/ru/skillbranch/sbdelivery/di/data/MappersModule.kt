package ru.skillbranch.sbdelivery.di.data

import dagger.Module
import dagger.Provides
import ru.skillbranch.sbdelivery.data.common.api.BaseResponseMapper
import ru.skillbranch.sbdelivery.data.common.api.ResponseErrorBodyConverter

/**
 * Created by Anna Shabaeva on 07.06.2020
 */

@Module
class MappersModule {

    @Provides
    fun provideBaseResponseMapper(errorBodyConverter: ResponseErrorBodyConverter) = BaseResponseMapper(errorBodyConverter)
}