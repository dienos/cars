package jth.com.thetrive.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import jth.com.thetrive.data.repository.SampleRepositoryImpl
import jth.com.thetrive.domain.usecase.GetSampleUseCase

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun providesGetSampleUseCase(repository: SampleRepositoryImpl): GetSampleUseCase {
        return GetSampleUseCase(repository)
    }
}