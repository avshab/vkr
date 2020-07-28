package ru.skillbranch.sbdelivery.dish.di

import dagger.Module
import dagger.Provides
import ru.skillbranch.sbdelivery.dish.model.DishViewModel
import ru.skillbranch.sbdelivery.dish.view.DishArgs
import ru.skillbranch.sbdelivery.dish.view.DishFragment
import ru.skillbranch.sbdelivery.dish.view.builder.DishReviewCellBuilder
import ru.skillbranch.sbdelivery.domain.dish.usecases.GetReviewsForDishUseCase
import ru.skillbranch.sbdelivery.domain.dish.usecases.SendReviewForDishUseCase
import ru.skillbranch.sbdelivery.utils.extensions.getArgs
import ru.skillbranch.sbdelivery.utils.resources.ResourcesManager
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
    fun provideDishArgs(
        fragment: DishFragment
    ): DishArgs {
        return fragment
            .getArgs<DishArgs> { fragment.arguments }
            .value
    }


    @Provides
    @DishScope
    fun provideDishViewModel(
        fragment: DishFragment,
        schedulers: Provider<Schedulers>,
        args: Provider<DishArgs>,
        cellsBuilder: DishReviewCellBuilder,
        getReviewsForDishUseCase: GetReviewsForDishUseCase,
        sendReviewForDishUseCase: SendReviewForDishUseCase
    ): DishViewModel {
        return fragment.createViewModel {
            val args = args.get()
            DishViewModel(
                schedulers = schedulers.get(),
                dishId = args.dishModel.id,
                title = args.dishModel.name,
                description = args.dishModel.description,
                price = args.dishModel.price,
                oldPrice = args.dishModel.oldPrice,
                url = args.dishModel.image,
                rating = args.dishModel.rating,
                cellsBuilder = cellsBuilder,
                getReviewsForDishUseCase = getReviewsForDishUseCase,
                sendReviewForDishUseCase = sendReviewForDishUseCase
            )
        }
    }

    @Provides
    @DishScope
    fun provideDishReviewCellBuilder(resourcesManager: ResourcesManager) =
        DishReviewCellBuilder(resourcesManager)

}