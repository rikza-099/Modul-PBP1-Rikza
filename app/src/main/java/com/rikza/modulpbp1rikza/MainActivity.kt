package com.rikza.modulpbp1rikza

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNama = findViewById<EditText>(R.id.etNama)
        val etUsia = findViewById<EditText>(R.id.etUsia)
        val btnKirim = findViewById<Button>(R.id.btnKirim)
        val btnBrowser = findViewById<Button>(R.id.btnBrowser)

        // Tombol Kirim Data (Explicit Intent + Validasi)
        btnKirim.setOnClickListener {
            val nama = etNama.text.toString().trim()
            val usiaStr = etUsia.text.toString().trim()

            // Validasi: Cek apakah nama kosong
            if (nama.isEmpty()) {
                etNama.error = "Nama lengkap wajib diisi!"
                Toast.makeText(this, "Nama tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Validasi: Cek apakah usia kosong
            if (usiaStr.isEmpty()) {
                etUsia.error = "Usia wajib diisi!"
                Toast.makeText(this, "Usia tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Validasi: Pastikan usia berupa angka positif (lebih dari 0)
            val usia = usiaStr.toIntOrNull()
            if (usia == null || usia <= 0) {
                etUsia.error = "Masukkan usia yang valid (angka positif)!"
                Toast.makeText(this, "Usia harus berupa angka lebih dari 0!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Explicit Intent: Mengirim String (nama) dan Integer (usia) ke ResultActivity
            val intent = Intent(this, ResultActivity::class.java).apply {
                putExtra("EXTRA_NAMA", nama)
                putExtra("EXTRA_USIA", usia)
            }
            startActivity(intent)
        }

        // Tombol Buka Website (Implicit Intent)
        btnBrowser.setOnClickListener {
            val query = "https://akprind.ac.id"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(query))
            startActivity(intent)
        }
    }
}