package com.example.pammvvm.ui.navigation


import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


object DestinationInsert {
    const val route = "insert"
}

@Composable
fun PengelolaHalaman(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinationInsert.route
    ) {
        composable(DestinationInsert.route) {
            // Contoh UI
            Text(text = "Halaman Insert")
        }
    }
}
