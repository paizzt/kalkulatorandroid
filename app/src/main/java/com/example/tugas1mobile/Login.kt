package com.example.tugas1mobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.tugas1mobile.databinding.LoginBinding

class Login : AppCompatActivity() {

    private lateinit var binding: LoginBinding

    lateinit var username : EditText
    lateinit var password : EditText
    lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        binding = LoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener(View.OnClickListener {
            if (binding.username.text.toString() == "faisalfaiz" && binding.password.text.toString() == "60900121004"){
                Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this@Login, Home::class.java))
            } else {
                Toast.makeText(this, "Gagal Login", Toast.LENGTH_SHORT).show()
            }
        })
    }
}