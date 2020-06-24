package ru.skillbranch.sbdelivery.di.app

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ru.skillbranch.sbdelivery.SBDeliveryApp
import ru.skillbranch.sbdelivery.dashboard.di.DashboardModule
import ru.skillbranch.sbdelivery.di.data.ApiServicesModule
import ru.skillbranch.sbdelivery.di.data.GatewayModule
import ru.skillbranch.sbdelivery.di.data.MappersModule
import ru.skillbranch.sbdelivery.di.data.NetworkModule
import ru.skillbranch.sbdelivery.di.domain.UseCasesModule
import ru.skillbranch.sbdelivery.di.utils.UtilsModule

/**
 * Created by Anna Shabaeva on 06.06.2020
 */

@AppScope
@Component(
    modules = [
        AppModule::class,
        UtilsModule::class,
        ApiServicesModule::class,
        NetworkModule::class,
        MappersModule::class,
        GatewayModule::class,
        UseCasesModule::class,
        SubcomponentsModule::class,
        AndroidSupportInjectionModule::class
    ]
)

interface AppComponent : AndroidInjector<SBDeliveryApp> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: SBDeliveryApp): Builder

        fun build(): AppComponent
    }

}


