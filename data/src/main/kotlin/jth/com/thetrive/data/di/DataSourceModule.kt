package jth.com.thetrive.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jth.com.thetrive.data.datasource.remote.CollectionRemoteSource
import jth.com.thetrive.data.datasource.remote.CollectionRemoteSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Singleton
    @Binds
    abstract fun bindsCollectionRemoteSource(source: CollectionRemoteSourceImpl): CollectionRemoteSource
}