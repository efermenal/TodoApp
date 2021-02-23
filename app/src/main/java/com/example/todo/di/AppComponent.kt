package com.example.todo.di

import android.app.Application
import com.example.todo.TodoApplication
import com.example.todo.di.viewmodels.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ApplicationModule::class,
    DatabaseModule::class,
    ViewModelModule::class,
    AndroidBindingModule::class,
    CoroutinesModule::class,
])
interface AppComponent : AndroidInjector<TodoApplication>{

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application) : Builder

        fun build() : AppComponent
    }

}