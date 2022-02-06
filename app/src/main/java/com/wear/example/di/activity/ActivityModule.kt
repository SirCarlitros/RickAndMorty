package com.wear.example.di.activity

import android.app.Activity
import com.wear.example.databinding.ActivityMainBinding
import com.wear.example.databinding.ActivitySplashBinding
import com.wear.example.di.scopes.ScopeActivity
import com.wear.example.ui.MainActivity
import com.wear.example.ui.splash.SplashActivity
import dagger.Module
import dagger.Provides

@Module(includes = [ActivityModule.View::class])
class ActivityModule {


    @Module
    class View{

        @Provides
        @ScopeActivity
        fun provideSplashBinder(activity: Activity) = ActivitySplashBinding.inflate((activity as SplashActivity).layoutInflater)

        @Provides
        @ScopeActivity
        fun provideMainBinder(activity: Activity) = ActivityMainBinding.inflate((activity as MainActivity).layoutInflater)
    }


}