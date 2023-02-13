package jth.com.thetrive.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import jth.com.thetrive.data.repository.CollectionRepositoryImpl
import jth.com.thetrive.domain.usecase.*

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun providesGetCollectionUseCase(repository: CollectionRepositoryImpl): GetCollectionCarsUseCase {
        return GetCollectionCarsUseCase(repository)
    }

    @Provides
    fun providesGetCollectionCarsFilterDataUseCase(repository: CollectionRepositoryImpl): GetCollectionCarsFilterDataUseCase {
        return GetCollectionCarsFilterDataUseCase(repository)
    }

    @Provides
    fun providesGetCarsFilterListUseCase(): MakeCollectionCarsFiltersResultUseCase {
        return MakeCollectionCarsFiltersResultUseCase()
    }
}