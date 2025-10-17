// lokasi: app/src/main/java/com/example/casestudy/screen/LoginScreen.kt
package com.example.casestudy.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.casestudy.NavDestination
import com.example.casestudy.UserViewModel

@Composable
fun LoginScreen(navController: NavController, viewModel: UserViewModel) {
    var nim by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val loginError by viewModel.loginError.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Halaman Login", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(24.dp))

        OutlinedTextField(
            value = nim,
            onValueChange = { nim = it },
            label = { Text("NIM") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(8.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation() // Menyembunyikan teks password
        )
        Spacer(Modifier.height(16.dp))

        // Menampilkan pesan error dari ViewModel jika ada
        loginError?.let {
            Text(
                text = it,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }

        Button(
            onClick = {
                // Alur logika yang sangat jelas:
                // Coba login, jika berhasil, baru navigasi.
                val isSuccess = viewModel.login(nim, password)
                if (isSuccess) {
                    navController.navigate(NavDestination.Detail.route) {
                        popUpTo(NavDestination.Login.route) { inclusive = true }
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) { Text("LOGIN") }

        Spacer(Modifier.height(8.dp))
        Button(
            onClick = { navController.navigate(NavDestination.Daftar.route) },
            modifier = Modifier.fillMaxWidth()
        ) { Text("DAFTAR") }
    }
}