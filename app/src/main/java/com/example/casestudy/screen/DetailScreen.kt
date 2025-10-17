package com.example.casestudy.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.casestudy.NavDestination

@Composable
fun DetailScreen(
    navController: NavController,
    nim: String,
    nama: String,
    email: String,
    alamat: String
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp)
    ) {
        Text("DETAIL", fontSize = 24.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 24.dp).fillMaxWidth(), textAlign = TextAlign.Center)
        Text("NIM: $nim", fontSize = 16.sp, modifier = Modifier.padding(vertical = 8.dp))
        Text("Nama: $nama", fontSize = 16.sp, modifier = Modifier.padding(vertical = 8.dp))
        Text("Email: $email", fontSize = 16.sp, modifier = Modifier.padding(vertical = 8.dp))
        Text("Alamat: $alamat", fontSize = 16.sp, modifier = Modifier.padding(vertical = 8.dp))
        Spacer(Modifier.height(32.dp))
        Button(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            onClick = { navController.navigate(NavDestination.Daftar.route) }
        ) { Text("KEMBALI KE PENDAFTARAN") }
    }
}