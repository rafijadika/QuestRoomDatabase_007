package com.example.pammvvm

import android.app.Application
import com.example.pammvvm.depedenciesinjection.ContainerApp

class KrsApp : Application() {
    lateinit var container: ContainerApp

    override fun onCreate() {
        super.onCreate()
        container = ContainerApp(this)
    }
}