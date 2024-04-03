package com.givekesh.binanceticker.data.di.module

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object MoshiModule {
    @Singleton
    @Provides
    fun provideKotlinJsonAdapter(): KotlinJsonAdapterFactory = KotlinJsonAdapterFactory()

    @Singleton
    @Provides
    fun provideMoshiBuilder(
        kotlinJsonAdapter: KotlinJsonAdapterFactory
    ): Moshi = Moshi.Builder().add(kotlinJsonAdapter).build()
}
