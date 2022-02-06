package com.wear.example

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import com.wear.example.di.app.ApplicationComponent
import com.wear.example.di.app.DaggerApplicationComponent

class App : Application() {

    companion object {
        lateinit var app: Application
    }

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        app = this

        applicationComponent = DaggerApplicationComponent.factory().create(this)

        AppCompatDelegate.setDefaultNightMode(
            if (BuildConfig.THEME_DARK) AppCompatDelegate.MODE_NIGHT_YES
            else AppCompatDelegate.MODE_NIGHT_NO
        )
        super.onCreate()
    }
}

val Context.applicationComponent: ApplicationComponent get() = (applicationContext as App).applicationComponent