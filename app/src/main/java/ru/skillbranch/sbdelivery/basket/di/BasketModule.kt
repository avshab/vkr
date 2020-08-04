package ru.skillbranch.sbdelivery.basket.di

import dagger.Module
import dagger.Provides
import ru.skillbranch.sbdelivery.basket.model.BasketViewModel
import ru.skillbranch.sbdelivery.basket.view.BasketFragment
import ru.skillbranch.sbdelivery.dish.di.DishScope
import ru.skillbranch.sbdelivery.domain.auth.usecases.IsUserAuthorizedUseCase
import ru.skillbranch.sbdelivery.utils.rx.Schedulers
import ru.skillbranch.sbdelivery.utils.viewModel.createViewModel
import javax.inject.Provider

/**
 * Created by Anna Shabaeva on 28.07.2020
 */

@Module
class BasketModule {

    @Provides
    @BasketScope
    fun provideBasketViewModel(
        fragment: BasketFragment,
        schedulers: Provider<Schedulers>,
        isUserAuthorizedUseCase: IsUserAuthorizedUseCase
    ): BasketViewModel {
        return fragment.createViewModel {
            BasketViewModel(
                schedulers = schedulers.get(),
                isUserAuthorizedUseCase = isUserAuthorizedUseCase
            )
        }
    }

}