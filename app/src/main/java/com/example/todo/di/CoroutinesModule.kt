package com.example.todo.di

import com.example.todo.global.DefaultDispatcherProvider
import com.example.todo.global.DispatcherProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CoroutinesModule {

    @Provides
    @Singleton
    fun providesDispatcherProvider(): DispatcherProvider {
        return DefaultDispatcherProvider()
    }


}