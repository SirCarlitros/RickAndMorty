package com.wear.example

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

class App : Application() {

    companion object {
        lateinit var app: Application
    }

    override fun onCreate() {

        AppCompatDelegate.setDefaultNightMode(
            if (BuildConfig.THEME_DARK) AppCompatDelegate.MODE_NIGHT_YES
            else AppCompatDelegate.MODE_NIGHT_NO
        )
        super.onCreate()
        app = this
    }
}