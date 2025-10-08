package com.example.casestudy

/**
 * Sealed class untuk mendefinisikan rute navigasi secara type-safe.
 * Ini mencegah kesalahan pengetikan saat memanggil rute.
 */
sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Daftar : Screen("daftar")
    object Detail : Screen("detail")
}