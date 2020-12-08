package com.syx.main.activity.kotlin.base

import android.annotation.SuppressLint
import android.app.Application
import android.support.v7.app.AppCompatActivity

@SuppressLint("Registered")
class App : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        var context: AppCompatActivity? = null
    }

}