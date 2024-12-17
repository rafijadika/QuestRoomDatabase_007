package com.example.pammvvm

import android.app.Application
import com.example.pammvvm.depedenciesinjection.ContainerApp

class KrsApp : Application() {
    lateinit var containerApp: ContainerApp // Fungsi untuk menyimpan instance

    override fun onCreate() {
        super.onCreate()
        containerApp = ContainerApp(this) // Membuat instance ContainerApp
        //instance adalah object yang dibuat dari class
    }
}
