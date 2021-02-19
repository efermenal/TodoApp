package com.example.todo.di

import com.example.todo.MainActivity
import com.example.todo.di.ActivityScoped
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AndroidBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun mainActivity() : MainActivity
}