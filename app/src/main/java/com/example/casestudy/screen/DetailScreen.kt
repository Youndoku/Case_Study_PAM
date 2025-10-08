package com.example.casestudy.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.casestudy.Screen
import com.example.casestudy.ui.theme.CasestudyTheme

@Composable
fun DetailScreen(navController: NavController) //
{
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(
            text = "DETAIL",
            modifier = Modifier
                .padding(25.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Text(
            text = "nim",fontSize = 14.sp,
            modifier = Modifier.padding(vertical = 10.dp)
        )
        Text(
            text = "nama", fontSize = 14.sp,
            modifier = Modifier.padding(vertical = 10.dp)
        )
        Text(
            text = "email",fontSize = 14.sp,
            modifier = Modifier.padding(vertical = 10.dp)
        )
        Text(
            text = "alamat",fontSize = 14.sp,
            modifier = Modifier.padding(vertical = 10.dp)
        )

        Button (
            modifier = Modifier.align(Alignment.CenterHorizontally),
            // 2. Menyesuaikan fungsi onClick untuk navigasi
            onClick = {
                navController.navigate(Screen.Daftar.route)
            })
        {
            Text("DAFTAR")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    CasestudyTheme {
        DetailScreen(navController = rememberNavController())
    }
}