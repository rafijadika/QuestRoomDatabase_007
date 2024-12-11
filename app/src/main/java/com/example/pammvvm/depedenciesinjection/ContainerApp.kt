package com.example.pammvvm.depedenciesinjection


import android.content.Context
import com.example.pammvvm.data.database.KrsDatabase
import com.example.pammvvm.repository.LocalRepositoryMhs
import com.example.pammvvm.repository.RepositoryMhs

interface InterfaceContainerApp {
    val RepositoryMhs: RepositoryMhs
}

class ContainerApp(private val context: Context) : InterfaceContainerApp {
    override val RepositoryMhs: RepositoryMhs by lazy {
        LocalRepositoryMhs(KrsDatabase.getDatabase(context).mahasiswaDao())
    }
}