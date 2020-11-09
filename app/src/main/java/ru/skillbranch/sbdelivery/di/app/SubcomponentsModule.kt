package ru.skillbranch.sbdelivery.di.app

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.skillbranch.sbdelivery.auth.login.di.LoginModule
import ru.skillbranch.sbdelivery.auth.login.di.LoginScope
import ru.skillbranch.sbdelivery.auth.login.view.LoginFragment
import ru.skillbranch.sbdelivery.auth.recovery.step1.di.RecoveryFirstStepModule
import ru.skillbranch.sbdelivery.auth.recovery.step1.di.RecoveryFirstStepScope
import ru.skillbranch.sbdelivery.auth.recovery.step1.view.RecoveryFirstStepFragment
import ru.skillbranch.sbdelivery.auth.recovery.step2.di.RecoverySecondStepModule
import ru.skillbranch.sbdelivery.auth.recovery.step2.di.RecoverySecondStepScope
import ru.skillbranch.sbdelivery.auth.recovery.step2.view.RecoverySecondStepFragment
import ru.skillbranch.sbdelivery.auth.recovery.step3.di.RecoveryThirdStepModule
import ru.skillbranch.sbdelivery.auth.recovery.step3.di.RecoveryThirdStepScope
import ru.skillbranch.sbdelivery.auth.recovery.step3.view.RecoveryThirdStepFragment
import ru.skillbranch.sbdelivery.auth.registration.di.RegistrationModule
import ru.skillbranch.sbdelivery.auth.registration.di.RegistrationScope
import ru.skillbranch.sbdelivery.auth.registration.view.RegistrationFragment
import ru.skillbranch.sbdelivery.basket.di.BasketModule
import ru.skillbranch.sbdelivery.basket.di.BasketScope
import ru.skillbranch.sbdelivery.basket.view.BasketFragment
import ru.skillbranch.sbdelivery.dashboard.di.DashboardModule
import ru.skillbranch.sbdelivery.dashboard.di.DashboardScope
import ru.skillbranch.sbdelivery.dashboard.view.DashboardFragment
import ru.skillbranch.sbdelivery.dish.di.DishModule
import ru.skillbranch.sbdelivery.dish.di.DishScope
import ru.skillbranch.sbdelivery.dish.view.DishFragment
import ru.skillbranch.sbdelivery.launch.di.LaunchModule
import ru.skillbranch.sbdelivery.launch.di.LaunchScope
import ru.skillbranch.sbdelivery.launch.view.LaunchFragment
import ru.skillbranch.sbdelivery.main.di.MainModule
import ru.skillbranch.sbdelivery.main.view.MainActivity
import ru.skillbranch.sbdelivery.main.di.MainScope
import ru.skillbranch.sbdelivery.menu.di.MenuModule
import ru.skillbranch.sbdelivery.menu.di.MenuScope
import ru.skillbranch.sbdelivery.menu.view.MenuFragment
import ru.skillbranch.sbdelivery.menuCategory.di.MenuCategoryModule
import ru.skillbranch.sbdelivery.menuCategory.di.MenuCategoryScope
import ru.skillbranch.sbdelivery.menuCategory.view.MenuCategoryFragment

/**
 * Created by Anna Shabaeva on 06.06.2020
 */

@Module
abstract class SubcomponentsModule {

    @MainScope
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun buildMainActivity(): MainActivity

    @LaunchScope
    @ContributesAndroidInjector(modules = [LaunchModule::class])
    abstract fun buildLaunchFragment(): LaunchFragment

    @DashboardScope
    @ContributesAndroidInjector(modules = [DashboardModule::class])
    abstract fun buildDashboardFragment(): DashboardFragment

    @MenuScope
    @ContributesAndroidInjector(modules = [MenuModule::class])
    abstract fun buildMenuFragment(): MenuFragment

    @LoginScope
    @ContributesAndroidInjector(modules = [LoginModule::class])
    abstract fun buildLoginFragment(): LoginFragment

    @RegistrationScope
    @ContributesAndroidInjector(modules = [RegistrationModule::class])
    abstract fun buildRegistrationFragment(): RegistrationFragment

    @RecoveryFirstStepScope
    @ContributesAndroidInjector(modules = [RecoveryFirstStepModule::class])
    abstract fun buildRecoveryFirstStepFragment(): RecoveryFirstStepFragment

    @RecoverySecondStepScope
    @ContributesAndroidInjector(modules = [RecoverySecondStepModule::class])
    abstract fun buildRecoverySecondStepFragment(): RecoverySecondStepFragment

    @RecoveryThirdStepScope
    @ContributesAndroidInjector(modules = [RecoveryThirdStepModule::class])
    abstract fun buildRecoveryThirdStepFragment(): RecoveryThirdStepFragment

    @DishScope
    @ContributesAndroidInjector(modules = [DishModule::class])
    abstract fun buildDishFragment(): DishFragment

    @BasketScope
    @ContributesAndroidInjector(modules = [BasketModule::class])
    abstract fun buildBasketFragment(): BasketFragment

    @MenuCategoryScope
    @ContributesAndroidInjector(modules = [MenuCategoryModule::class])
    abstract fun buildMenuCategoryFragment(): MenuCategoryFragment
}
