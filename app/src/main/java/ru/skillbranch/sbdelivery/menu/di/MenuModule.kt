package ru.skillbranch.sbdelivery.menu.di

import dagger.Module
import dagger.Provides
import ru.skillbranch.sbdelivery.menu.model.MenuViewModel
import ru.skillbranch.sbdelivery.menu.view.MenuCellsBuilder
import ru.skillbranch.sbdelivery.menu.view.MenuFragment
import ru.skillbranch.sbdelivery.utils.rx.Schedulers
import ru.skillbranch.sbdelivery.utils.viewModel.createViewModel
import javax.inject.Provider

/**
 * Created by Anna Shabaeva on 24.06.2020
 */

@Module
class MenuModule {

    @Provides
    @MenuScope
    fun provideMenuViewModel(
        fragment: MenuFragment,
        schedulers: Provider<Schedulers>,
        cellsBuilder: Provider<MenuCellsBuilder>
    ): MenuViewModel {
        return fragment.createViewModel {
            MenuViewModel(
                schedulers = schedulers.get(),
                builder = cellsBuilder.get()
            )
        }
    }

    @Provides
    @MenuScope
    fun provideMenuCellsBuilder(

    ) = MenuCellsBuilder()
}