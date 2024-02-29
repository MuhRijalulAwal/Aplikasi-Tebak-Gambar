package com.example.tebakgambar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tebakgambar.databinding.ActivityTebakBinding
import com.google.android.material.snackbar.Snackbar

class TebakActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTebakBinding
    private var correctImageName: String = ""
    private lateinit var snackbar: Snackbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTebakBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val receivedLogo = intent.getParcelableExtra<Logo>("logo")

        // Temukan ImageView menggunakan binding
        val imageView = binding.imageView

        snackbar = Snackbar.make(binding.root, "", Snackbar.LENGTH_SHORT)

        receivedLogo?.let {
            correctImageName = getResourceName(it.imageResource)
            imageView.setImageResource(it.imageResource)

            // Logika untuk memeriksa apakah input pengguna sesuai dengan gambar
            binding.button.setOnClickListener {
                val userInput = binding.edt.text.toString().trim()

                if (userInput.equals(correctImageName, ignoreCase = true)) {
                    // Jika input pengguna benar, tampilkan Snackbar benar
                    binding.tvHasil.text = "Jawaban Benar !"
                    showSnackbar("Benar!")
                } else {
                    // Jika input pengguna salah, tampilkan Snackbar salah
                    binding.tvHasil.text = "Jawaban Salah !"
                    showSnackbar("Salah, Coba lagi.")
                }
            }
        }
    }

    // Fungsi untuk mendapatkan nama file dari ID sumber daya gambar
    private fun getResourceName(resourceId: Int): String {
        return resources.getResourceEntryName(resourceId)
    }

    // Fungsi untuk menampilkan Snackbar
    private fun showSnackbar(message: String) {
        snackbar.setText(message)
        snackbar.show()
    }
}