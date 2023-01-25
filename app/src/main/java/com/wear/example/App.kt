package com.wear.example

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    companion object {
        lateinit var app: Application
    }

    override fun onCreate() {
        app = this


        AppCompatDelegate.setDefaultNightMode(
            if (BuildConfig.THEME_DARK) AppCompatDelegate.MODE_NIGHT_YES
            else AppCompatDelegate.MODE_NIGHT_NO
        )
        super.onCreate()
    }
}