package com.example.amphibians

import android.app.Application
import com.example.amphibians.data.repository.AppContainer
import com.example.amphibians.data.repository.DefaultAppContainer

class AmphibiansApplication: Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}