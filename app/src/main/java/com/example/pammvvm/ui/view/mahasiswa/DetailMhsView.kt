package com.example.pammvvm.ui.view.mahasiswa

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pammvvm.ui.viewmodel.DetailMhsViewModel
import com.example.pammvvm.ui.viewmodel.PenyediaViewModel

@Composable
fun DetailMhsView(
    modifier: Modifier = Modifier,
    viewModel: DetailMhsViewModel = viewModel(factory = PenyediaViewModel.Factory),
    onBack: () -> Unit = {},
    onEditClick: (String) -> Unit = {},
    onDeleteClick: () -> Unit = {}
){
    Scaffold (topBar = {
        TopAppBar(
            judul = "Detail Mahasiswa",
            showBackButton = true,
            onBack = onBack
        )