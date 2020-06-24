package ru.skillbranch.sbdelivery.di.data

import dagger.Module
import dagger.Provides
import ru.skillbranch.sbdelivery.data.common.ResponseErrorBodyConverter
import ru.skillbranch.sbdelivery.data.dashboard.mappers.DishesListResponseMapper
import ru.skillbranch.sbdelivery.data.dashboard.mappers.IdsResponseMapper

/**
 * Created by Anna Shabaeva on 07.06.2020
 */

@Module
class MappersModule {

    @Provides
    fun provideDishesListResponseMapper(errorBodyConverter: ResponseErrorBodyConverter) = DishesListResponseMapper(errorBodyConverter)

    @Provides
    fun provideIdsResponseMapper(errorBodyConverter: ResponseErrorBodyConverter) = IdsResponseMapper(errorBodyConverter)
}