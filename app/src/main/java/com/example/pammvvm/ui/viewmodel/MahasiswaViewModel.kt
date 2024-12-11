package com.example.pammvvm.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.app.NotificationCompat.MessagingStyle.Message
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pammvvm.data.entity.Mahasiswa
import com.example.pammvvm.repository.RepositoryMhs
import kotlinx.coroutines.launch


class MahasiswaViewModel(
    private val repository: RepositoryMhs) : ViewModel() {
    var uiState by mutableStateOf(MhsUIState())


    fun updateState(mahasiswaEvent: MahasiswaEvent) {
        var uiState = uiState.copy(
            mahasiswaEvent = mahasiswaEvent,
        )
    }
    private fun validateFields(): Boolean{
        val event = uiState.mahasiswaEvent
        val errorState = FormErrorState(
            nim = if (event.nim.isEmpty()) null else "NIM tidak boleh kosong",
            nama = if (event.nama.isEmpty()) null else "Nama tidak boleh kosong",
            jeniskelamin = if (event.jeniskelamin.isEmpty()) null else "Jenis Kelamin tidak boleh kosong",
            alamat = if (event.alamat.isEmpty()) null else "Alamat tidak boleh kosong",
            kelas = if (event.kelas.isEmpty()) null else "Kelas tidak boleh kosong",
            angkatan = if (event.angkatan.isEmpty()) null else "Angkatan tidak boleh kosong",
        )

        uiState = uiState.copy(isEntryValid = errorState)
        return errorState.isValid()
    }

    fun SaveData(){
        val currentEvent = uiState.mahasiswaEvent
        if (validateFields()) {
            viewModelScope.launch {
                try {
                    RepositoryMhs.insertMhs(currentEvent.toMahasiswaEntity())
                    uiState = uiState.copy(
                        snackBarMessage = "Data berhasil disimpan",
                        mahasiswaEvent = MahasiswaEvent(),
                        isEntryValid = FormErrorState()
                    )
                } catch (e: Exception) {
                    uiState = uiState.copy(
                        snackBarMessage = "Data gagal disimpan"
                    )
                }
            }
        }else {
            uiState = uiState.copy(
                snackBarMessage = "Input tidak valid. periksa kembali"
            )
        }

        fun resetSnackBarMessage() {
            uiState = uiState.copy(
                snackBarMessage = null
            )
        }
    }
}

private fun RepositoryMhs.Companion.insertMhs(toMahasiswaEntity: Mahasiswa) {

}


data class MahasiswaEvent(
    val nim: String = "",
    val nama: String = "",
    val jeniskelamin: String = "",
    val alamat: String = "",
    val kelas: String = "",
    val angkatan: String = ""
)

fun MahasiswaEvent.toMahasiswaEntity(): Mahasiswa = Mahasiswa(

        nim = nim,
        nama = nama,
        jenisKelamin = jeniskelamin,
        alamat = alamat,
        kelas = kelas,
        angkatan = angkatan
)

data class FormErrorState(
    val nim: String? = null,
    val nama: String? = null,
    val jeniskelamin: String? = null,
    val alamat: String? = null,
    val kelas: String? = null,
    val angkatan: String? = null

) {
    fun isValid(): Boolean {
        return nim == null &&
                nama == null &&
                jeniskelamin == null &&
                alamat == null &&
                kelas == null &&
                angkatan == null
    }
}

data class MhsUIState(
    val mahasiswaEvent: MahasiswaEvent = MahasiswaEvent(),
    val isEntryValid: FormErrorState = FormErrorState(),
    val snackBarMessage: String? = null,
)


