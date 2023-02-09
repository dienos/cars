package jth.com.thetrive.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jth.com.thetrive.data.datasource.local.SampleLocalSource
import jth.com.thetrive.data.datasource.local.SampleLocalSourceImpl
import jth.com.thetrive.data.datasource.remote.SampleRemoteSource
import jth.com.thetrive.data.datasource.remote.SampleRemoteSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Singleton
    @Binds
    abstract fun bindsSimpleRemoteSource(source: SampleRemoteSourceImpl): SampleRemoteSource

    @Singleton
    @Binds
    abstract fun bindsSimpleLocalSource(source: SampleLocalSourceImpl): SampleLocalSource
}