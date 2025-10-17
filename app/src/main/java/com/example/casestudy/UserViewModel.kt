// lokasi: app/src/main/java/com/example/casestudy/UserViewModel.kt
package com.example.casestudy

import androidx.lifecycle.ViewModel
import com.example.casestudy.data.UserData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class UserViewModel : ViewModel() {

    private val _user = MutableStateFlow(UserData())
    val user = _user.asStateFlow()

    private val _loginError = MutableStateFlow<String?>(null)
    val loginError = _loginError.asStateFlow()

    // Kredensial yang benar disimpan di sini
    private val validNim = "235150400111010"
    private val validPassword = "123456"

    /**
     * Memvalidasi NIM dan Password.
     * @return `true` jika login berhasil, `false` jika gagal.
     */
    fun login(nim: String, password: String): Boolean {
        if (nim == validNim && password == validPassword) {
            // Jika BERHASIL:
            _loginError.value = null // 1. Hapus pesan error lama (jika ada)
            _user.update { // 2. Set data pengguna dengan informasi default
                it.copy(
                    nim = validNim,
                    nama = "Sahrur Ramadhan"
                )
            }
            return true // 3. Beri tahu UI bahwa login sukses
        } else {
            // Jika GAGAL:
            _loginError.value = "NIM atau Password salah." // 1. Tampilkan pesan error
            return false // 2. Beri tahu UI bahwa login gagal
        }
    }

    /**
     * Fungsi untuk halaman daftar (tidak berubah).
     */
    fun daftar(newUserData: UserData) {
        _user.value = newUserData
    }
}