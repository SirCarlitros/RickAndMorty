package com.wear.example.ui.splash

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.wear.example.applicationComponent
import com.wear.example.databinding.ActivitySplashBinding
import com.wear.example.navigation.Navigation
import javax.inject.Inject

class SplashActivity : AppCompatActivity() {

    @Inject
    lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        application.applicationComponent.activityComponentBuilder().activity(this).build()
            .injectSplashActivity(this)

        //DaggerActivityComponent.factory().create(this, this.application.applicationComponent).injectSplashActivity(this)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        window.statusBarColor = Color.TRANSPARENT

        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            Navigation.gotoMainActivity(this)
            finish()
        }, 3_000L)
    }

}