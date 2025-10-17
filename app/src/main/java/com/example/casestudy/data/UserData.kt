package com.example.casestudy.data

/**
 * Data class untuk membungkus semua informasi pengguna menjadi satu objek.
 */
data class UserData(
    val nim: String = "",
    val nama: String = "",
    val email: String = "",
    val alamat: String = ""
)