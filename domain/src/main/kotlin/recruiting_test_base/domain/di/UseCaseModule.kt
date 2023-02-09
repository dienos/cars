package recruiting_test_base.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import recruiting_test_base.data.repository.SampleRepositoryImpl
import recruiting_test_base.domain.usecase.GetLocalSampleUseCase
import recruiting_test_base.domain.usecase.GetSampleUseCase

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun providesGetSampleUseCase(repository: SampleRepositoryImpl): GetSampleUseCase {
        return GetSampleUseCase(repository)
    }

    @Provides
    fun providesGetLocalSampleUseCase(repository: SampleRepositoryImpl): GetLocalSampleUseCase {
        return GetLocalSampleUseCase(repository)
    }
}