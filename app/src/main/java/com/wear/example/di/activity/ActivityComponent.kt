package com.wear.example.di.activity

import android.app.Activity
import android.app.Application
import com.example.scope.ActivityScope
import com.wear.example.di.fragment.FragmentComponent
import com.wear.example.ui.MainActivity
import com.wear.example.ui.splash.SplashActivity
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(
    modules = [ActivityModule::class]
)
@ActivityScope
interface ActivityComponent {

    fun injectSplashActivity(splashActivity: SplashActivity)
    fun injectMainActivity(mainActivity: MainActivity)
    fun fragmentComponentFactory(): FragmentComponent.Factory

    @Subcomponent.Builder
    interface Builder {
        fun activity(
            @BindsInstance activity: Activity,
        ): Builder
/*        fun setApplication(
            @BindsInstance application: Application
        ): Builder*/

        fun build(): ActivityComponent
    }
}