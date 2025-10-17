package com.example.casestudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.casestudy.screen.DaftarScreen
import com.example.casestudy.screen.DetailScreen
import com.example.casestudy.screen.LoginScreen
import com.example.casestudy.ui.theme.CasestudyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CasestudyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val userViewModel: UserViewModel = viewModel()

                    NavHost(
                        navController = navController,
                        startDestination = NavDestination.Login.route
                    ) {
                        composable(route = NavDestination.Login.route) {
                            LoginScreen(
                                navController = navController,
                                viewModel = userViewModel
                            )
                        }

                        composable(route = NavDestination.Daftar.route) {
                            DaftarScreen(
                                navController = navController,
                                viewModel = userViewModel
                            )
                        }

                        // PERBAIKAN: Blok 'arguments' yang menyebabkan error telah dihapus.
                        composable(route = NavDestination.Detail.route) {
                            // Data diambil langsung dari ViewModel, bukan dari argumen URL.
                            val user by userViewModel.user.collectAsState()

                            DetailScreen(
                                navController = navController,
                                nim = user.nim,
                                nama = user.nama,
                                email = user.email,
                                alamat = user.alamat
                            )
                        }
                    }
                }
            }
        }
    }
}