package recruiting_test_base.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import recruiting_test_base.data.repository.SampleRepository
import recruiting_test_base.data.repository.SampleRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindsSampleRepository(
        localSource: SampleRepositoryImpl
    ): SampleRepository
}