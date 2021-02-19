package com.example.todo

import android.app.Application
import com.example.todo.di.AppComponent
import com.example.todo.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class TodoApplication : Application(), HasAndroidInjector {

    lateinit var daggerAppComponent: AppComponent

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        dependencyInjectionConfig()
    }

    private fun dependencyInjectionConfig() {
        daggerAppComponent = DaggerAppComponent
            .builder()
            .application(this)
            .build()
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return  androidInjector
    }
}