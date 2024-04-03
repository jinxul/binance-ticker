package com.givekesh.binanceticker.domain.di.module

import com.givekesh.binanceticker.domain.usecase.socket.SocketUseCase
import com.givekesh.binanceticker.domain.usecase.socket.SocketUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class UseCaseModule {
    @Singleton
    @Binds
    abstract fun bindSocketUseCase(impl: SocketUseCaseImpl): SocketUseCase
}