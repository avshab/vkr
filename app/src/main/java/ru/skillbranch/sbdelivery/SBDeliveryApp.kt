package ru.skillbranch.sbdelivery

import android.app.Activity
import android.app.Application
import android.os.Looper
import androidx.fragment.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.skillbranch.sbdelivery.di.app.AppComponent
import ru.skillbranch.sbdelivery.di.app.DaggerAppComponent
import javax.inject.Inject

/**
 * Created by Anna Shabaeva on 06.06.2020
 */

class SBDeliveryApp : Application(), HasSupportFragmentInjector,
    HasActivityInjector {

    lateinit var component: AppComponent

    @Inject lateinit var dispatchingFragmentInjector: DispatchingAndroidInjector<Fragment>
    @Inject lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>


    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingFragmentInjector
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingActivityInjector
    }

    override fun onCreate() {
        super.onCreate()
        initAppComponent()
        setupRxAndroid()

    }

    private fun initAppComponent() {
        component = DaggerAppComponent
            .builder()
            .application(this)
            .build()
            .also { it.inject(this) }
    }

    private fun setupRxAndroid() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler {
            AndroidSchedulers.from(Looper.getMainLooper(), true)
        }
    }
}