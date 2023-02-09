package jth.com.thetrive.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jth.com.thetrive.data.repository.SampleRepository
import jth.com.thetrive.data.repository.SampleRepositoryImpl
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