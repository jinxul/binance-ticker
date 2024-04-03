package com.givekesh.binanceticker.data.di.module

import com.givekesh.binanceticker.data.source.remote.repository.socket.SocketRepository
import com.givekesh.binanceticker.data.source.remote.repository.socket.SocketRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindSocketRepository(impl: SocketRepositoryImpl): SocketRepository
}