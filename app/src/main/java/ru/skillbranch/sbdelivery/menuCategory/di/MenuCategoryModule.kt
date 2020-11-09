package ru.skillbranch.sbdelivery.menuCategory.di

import dagger.Module
import dagger.Provides
import ru.skillbranch.sbdelivery.menuCategory.model.MenuCategoryViewModel
import ru.skillbranch.sbdelivery.menuCategory.view.MenuCategoryArgs
import ru.skillbranch.sbdelivery.menuCategory.view.MenuCategoryCellsBuilder
import ru.skillbranch.sbdelivery.menuCategory.view.MenuCategoryFragment
import ru.skillbranch.sbdelivery.utils.extensions.getArgs
import ru.skillbranch.sbdelivery.utils.rx.Schedulers
import ru.skillbranch.sbdelivery.utils.viewModel.createViewModel
import javax.inject.Provider

/**
 * Created by Anna Shabaeva on 09.11.2020
 */

@Module
class MenuCategoryModule {

    @Provides
    @MenuCategoryScope
    fun provideMenuCategoryArgs(
        fragment: MenuCategoryFragment
    ): MenuCategoryArgs {
        return fragment
            .getArgs<MenuCategoryArgs> { fragment.arguments }
            .value
    }


    @Provides
    @MenuCategoryScope
    fun provideMenuCategoryViewModel(
        fragment: MenuCategoryFragment,
        schedulers: Provider<Schedulers>,
        cellsBuilder: Provider<MenuCategoryCellsBuilder>,
        args: Provider<MenuCategoryArgs>
    ): MenuCategoryViewModel {
        return fragment.createViewModel {
            MenuCategoryViewModel(
                catetegoryId = args.get().categoryId,
                schedulers = schedulers.get(),
                builder = cellsBuilder.get()
            )
        }
    }


    @Provides
    @MenuCategoryScope
    fun provideMenuCategoryCellsBuilder() = MenuCategoryCellsBuilder()
}