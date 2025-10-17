package com.example.casestudy

/**
 * Mendefinisikan semua rute navigasi di satu tempat untuk keamanan tipe (type-safety).
 */
sealed class NavDestination(val route: String) {
    object Login : NavDestination("login")
    object Daftar : NavDestination("daftar")

    // PERBAIKAN KUNCI: Rute Detail tidak lagi memiliki placeholder seperti "{nim}".
    object Detail : NavDestination("detail")
}