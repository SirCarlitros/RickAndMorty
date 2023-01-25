package com.wear.example.di.activity

import android.app.Activity
import com.wear.example.databinding.ActivityMainBinding
import com.wear.example.databinding.ActivitySplashBinding
import com.wear.example.ui.MainActivity
import com.wear.example.ui.splash.SplashActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ActivityScoped

@Module(includes = [ActivityModule.View::class])
@InstallIn(dagger.hilt.android.components.ActivityComponent::class)
class ActivityModule {


    @Module
    @InstallIn(dagger.hilt.android.components.ActivityComponent::class)
    class View {

        @Provides
        @ActivityScoped
        fun provideSplashBinder(activity: Activity) =
            ActivitySplashBinding.inflate((activity as SplashActivity).layoutInflater)

        @Provides
        @ActivityScoped
        fun provideMainBinder(activity: Activity) =
            ActivityMainBinding.inflate((activity as MainActivity).layoutInflater)
    }


}