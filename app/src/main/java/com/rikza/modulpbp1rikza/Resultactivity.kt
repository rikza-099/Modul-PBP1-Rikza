package com.rikza.modulpbp1rikza

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Resultactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvHasil = findViewById<TextView>(R.id.tvHasil)
        val btnKembali = findViewById<Button>(R.id.btnKembali)

        // Menangkap data String dan Integer yang dikirim dari MainActivity
        val nama = intent.getStringExtra("EXTRA_NAMA")
        val usia = intent.getIntExtra("EXTRA_USIA", 0)

        // Menampilkan data ke TextView sesuai format tugas modul
        tvHasil.text = "Halo $nama, usia Anda $usia tahun. Pendaftaran berhasil!"

        // Tombol untuk kembali ke halaman utama
        btnKembali.setOnClickListener {
            finish()
        }
    }
}