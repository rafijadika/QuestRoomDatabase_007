package com.example.pammvvm.ui.view.mahasiswa

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
    },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {onEditClick(viewModel.detailUiState.value.detailUiEvent.nim)},
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit Mahasiswa")
            }
        }){
            innerPadding ->
        val detailUiState by viewModel.detailUiState.collectAsState()

        BodyDetailMhs(
            modifier = Modifier.padding(innerPadding),
            detailUiState = detailUiState,
            onDeleteClick = {
                viewModel.deteleMhs()
                onDeleteClick()
            }
        )
    }
}




