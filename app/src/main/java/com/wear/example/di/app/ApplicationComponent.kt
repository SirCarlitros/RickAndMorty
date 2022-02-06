package com.wear.example.di.app

import android.app.Application
import com.wear.example.di.activity.ActivityComponent
import com.wear.example.di.scopes.ApplicationScope
import dagger.BindsInstance
import dagger.Component
import retrofit2.Retrofit

@Component(modules = [ApplicationModule::class])
@ApplicationScope
interface ApplicationComponent {

    //fun retrofit(): Retrofit
    fun activityComponentFactory(): ActivityComponent.Factory

    @Component.Factory
    interface Builder {

        fun create(@BindsInstance application: Application): ApplicationComponent
    }
}