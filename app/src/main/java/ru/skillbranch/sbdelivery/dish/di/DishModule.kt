package ru.skillbranch.sbdelivery.dish.di

import dagger.Module
import dagger.Provides
import ru.skillbranch.sbdelivery.dish.model.DishViewModel
import ru.skillbranch.sbdelivery.dish.view.DishArgs
import ru.skillbranch.sbdelivery.dish.view.DishFragment
import ru.skillbranch.sbdelivery.utils.extensions.getArgs
import ru.skillbranch.sbdelivery.utils.rx.Schedulers
import ru.skillbranch.sbdelivery.utils.viewModel.createViewModel
import javax.inject.Provider

/**
 * Created by Anna Shabaeva on 12.07.2020
 */

@Module
class DishModule {

    @Provides
    @DishScope
    fun provideDishArgs (
        fragment: DishFragment
    ) : DishArgs {
        return fragment
            .getArgs<DishArgs> { fragment.arguments }
            .value
    }


    @Provides
    @DishScope
    fun provideDishViewModel(
        fragment: DishFragment,
        schedulers: Provider<Schedulers>,
        args: Provider<DishArgs>
    ) : DishViewModel {
        return fragment.createViewModel {
            val args = args.get()
            DishViewModel(
                schedulers = schedulers.get()
            )
        }

    }
}