package com.wear.example

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import com.wear.example.di.app.ApplicationComponent
import com.wear.example.di.app.DaggerApplicationComponent
import com.wear.example.pruebas.AClass
import com.wear.example.pruebas.BClass
import com.wear.example.pruebas.CClass
import com.wear.example.pruebas.DClass

class App : Application() {

    companion object {
        lateinit var app: Application
        lateinit var applicationComponent: ApplicationComponent
    }

    override fun onCreate() {
        app = this

        Companion.applicationComponent =
            DaggerApplicationComponent.factory()
                .create(this)

        AppCompatDelegate.setDefaultNightMode(
            if (BuildConfig.THEME_DARK) AppCompatDelegate.MODE_NIGHT_YES
            else AppCompatDelegate.MODE_NIGHT_NO
        )
        super.onCreate()
    }
}

val Context.applicationComponent: ApplicationComponent get() = App.applicationComponent