package ru.skillbranch.sbdelivery.dashboard.di

import dagger.Module
import dagger.Provides
import ru.skillbranch.sbdelivery.dashboard.model.DashboardViewModel
import ru.skillbranch.sbdelivery.dashboard.view.DashboardFragment
import ru.skillbranch.sbdelivery.dashboard.view.builder.DashboardCellsBuilder
import ru.skillbranch.sbdelivery.domain.auth.usecases.IsUserAuthorizedSingleUseCase
import ru.skillbranch.sbdelivery.domain.dashboard.usecases.GetDashboardModelUseCases
import ru.skillbranch.sbdelivery.utils.resources.ResourcesManager
import ru.skillbranch.sbdelivery.utils.rx.Schedulers
import ru.skillbranch.sbdelivery.utils.viewModel.createViewModel
import javax.inject.Provider

/**
 * Created by Anna Shabaeva on 07.06.2020
 */

@Module
class DashboardModule {

    @Provides
    @DashboardScope
    fun provideDaschboardViewModel(
        fragment: DashboardFragment,
        schedulers: Provider<Schedulers>,
        getDashboardModelUseCases: Provider<GetDashboardModelUseCases>,
        cellsBuilder: Provider<DashboardCellsBuilder>,
        isUserAuthorizedSingleUseCase: Provider<IsUserAuthorizedSingleUseCase>
    ): DashboardViewModel {
        return fragment.createViewModel {
            DashboardViewModel(
                schedulers = schedulers.get(),
                getDashboardModelUseCases = getDashboardModelUseCases.get(),
                cellsBuilder = cellsBuilder.get(),
                isUserAuthorizedSingleUseCase = isUserAuthorizedSingleUseCase.get()
            )
        }
    }

    @Provides
    @DashboardScope
    fun provideDashboardCellsBuilder(
        resourcesManager: ResourcesManager
    ) = DashboardCellsBuilder(resourcesManager)
}