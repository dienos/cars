package jth.com.thetrive.ui.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jth.com.thetrive.ui.utils.NetworkUtil

@Module
@InstallIn(SingletonComponent::class)
class NetWorkModule {
    @Provides
    fun providesNetWorkUtil(): NetworkUtil = NetworkUtil()
}