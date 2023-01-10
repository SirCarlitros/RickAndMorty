package com.wear.example.di.app

import android.app.Application
import com.example.networking.NetworkingConfiguration
import com.example.scope.ApplicationScope
import com.wear.example.InterTest
import com.wear.example.di.activity.ActivityComponent
import dagger.BindsInstance
import dagger.Component

@Component(modules = [ApplicationModule::class])
@ApplicationScope
interface ApplicationComponent {

    //fun retrofit(): Retrofit
    fun activityComponentBuilder(): ActivityComponent.Builder
    fun getApplication(): Application


    @Component.Factory
    interface Builder {

        fun create(
            @BindsInstance application: Application
            ): ApplicationComponent
    }
}