package ru.skillbranch.sbdelivery.dish.model

import io.reactivex.disposables.Disposable
import ru.skillbranch.sbdelivery.common.viewModel.BaseViewModelWithState
import ru.skillbranch.sbdelivery.common.viewModel.ViewModelState
import ru.skillbranch.sbdelivery.dish.view.builder.DishReviewCellBuilder
import ru.skillbranch.sbdelivery.domain.dish.model.DishReviewModel
import ru.skillbranch.sbdelivery.domain.dish.usecases.GetReviewsForDishUseCase
import ru.skillbranch.sbdelivery.domain.dish.usecases.SendReviewForDishUseCase
import ru.skillbranch.sbdelivery.utils.rx.Schedulers

/**
 * Created by Anna Shabaeva on 11.07.2020
 */

class DishViewModel(
    private val schedulers: Schedulers,
    private val dishId: String,
    private val title: String,
    private val description: String,
    private val price: Int,
    private val oldPrice: Int?,
    private val url: String,
    private val rating: Double,
    private val cellsBuilder: DishReviewCellBuilder,
    private val getReviewsForDishUseCase: GetReviewsForDishUseCase,
    private val sendReviewForDishUseCase: SendReviewForDishUseCase
) : BaseViewModelWithState() {

    private var reviewDisposable: Disposable? = null
    private var addReviewDisposable: Disposable? = null

    init {
        loadData()
    }

    private fun loadData() {
        reviewDisposable?.dispose()
        reviewDisposable = getReviewsForDishUseCase
            .buildSingle(dishId)
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.ui())
            .doOnSubscribe { stateMutableLiveData.value = ViewModelState.Loading }
            .subscribe(
                ::handleResult,
                ::handleError
            )
            .untilCleared()
    }

    private fun handleResult(data: List<DishReviewModel>) {
        stateMutableLiveData.value = ViewModelState.Success(
            cellsBuilder.build(
                title = title,
                description = description,
                price = price,
                oldPrice = oldPrice,
                reviews = data,
                url = url,
                rating = rating.toString()
            )
        )
    }

    override fun handleError(throwable: Throwable) {
        stateMutableLiveData.value = ViewModelState.Success(
            cellsBuilder.buildHeader(
                title = title,
                description = description,
                price = price,
                oldPrice = oldPrice,
                url = url
            )
        )
    }

    fun addToBasket(count: Int) {

    }

    fun addReview(rating: Int, text: String) {
        addReviewDisposable?.dispose()
        addReviewDisposable = sendReviewForDishUseCase
            .build(dishId, rating, text)
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.ui())
            .doOnSubscribe { stateMutableLiveData.value = ViewModelState.Loading }
            .subscribe(
                ::loadData,
                ::handleError
            )
            .untilCleared()
    }

}