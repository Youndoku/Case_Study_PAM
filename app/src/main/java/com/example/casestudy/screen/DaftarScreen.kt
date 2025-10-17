package com.example.casestudy.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.casestudy.NavDestination
import com.example.casestudy.UserViewModel
import com.example.casestudy.data.UserData

@Composable
fun DaftarScreen(navController: NavController, viewModel: UserViewModel) {
    var nim by remember { mutableStateOf("") }
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Halaman Daftar", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))
        OutlinedTextField(value = nim, onValueChange = { nim = it }, label = { Text("NIM") }, modifier = Modifier.fillMaxWidth())
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(value = nama, onValueChange = { nama = it }, label = { Text("Nama") }, modifier = Modifier.fillMaxWidth())
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(value = email, onValueChange = { email = it }, label = { Text("Email") }, modifier = Modifier.fillMaxWidth())
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(value = alamat, onValueChange = { alamat = it }, label = { Text("Alamat") }, modifier = Modifier.fillMaxWidth())
        Spacer(Modifier.height(16.dp))

        Button(
            onClick = {
                val newUserData = UserData(nim, nama, email, alamat)
                viewModel.daftar(newUserData)
                navController.navigate(NavDestination.Detail.route) {
                    popUpTo(NavDestination.Daftar.route) { inclusive = true }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) { Text("SIMPAN") }
    }
}