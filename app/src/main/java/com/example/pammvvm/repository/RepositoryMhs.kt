package com.example.pammvvm.repository

import com.example.pammvvm.data.entity.Mahasiswa

interface RepositoryMhs {

    suspend fun insertMhs(mahasiswa: Mahasiswa)

    companion object
}