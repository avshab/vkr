package ru.skillbranch.sbdelivery.launch.di

import dagger.Module
import dagger.Provides
import ru.skillbranch.sbdelivery.launch.model.LaunchViewModel
import ru.skillbranch.sbdelivery.launch.view.LaunchFragment
import ru.skillbranch.sbdelivery.utils.viewModel.createViewModel

/**
 * Created by Anna Shabaeva on 25.06.2020
 */

@Module
class LaunchModule {

    @Provides
    @LaunchScope
    fun provideLaunchViewModel(
        fragment: LaunchFragment
    ): LaunchViewModel {
        return fragment.createViewModel {
            LaunchViewModel()
        }
    }
}