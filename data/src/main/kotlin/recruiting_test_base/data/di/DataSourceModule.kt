package recruiting_test_base.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import recruiting_test_base.data.datasource.local.SampleLocalSource
import recruiting_test_base.data.datasource.local.SampleLocalSourceImpl
import recruiting_test_base.data.datasource.remote.SampleRemoteSource
import recruiting_test_base.data.datasource.remote.SampleRemoteSourceImpl
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