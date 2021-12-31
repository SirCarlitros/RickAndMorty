package com.wear.example.network

import android.content.Context

object Internet {

    fun hasInternet(context:Context, lambdaFunction: (hasInternet: Boolean)-> Unit){
        lambdaFunction.invoke(false)
    }
}