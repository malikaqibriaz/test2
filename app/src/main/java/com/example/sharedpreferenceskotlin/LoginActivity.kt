package com.example.sharedpreferenceskotlin

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {
            val email= editTextEmailLogin.text.toString()
            val password= editTextPasswordLogin.text.toString()
            val sharedPreferences: SharedPreferences= getSharedPreferences("SharedPrefs", Context.MODE_PRIVATE)
            val txtEmail= sharedPreferences.getString("String1", "")
            val txtPassword= sharedPreferences.getString("String2", "")
            if (email == txtEmail && password == txtPassword) {
                Toast.makeText(this, "Data Matched Successfully", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Wrong Credentials", Toast.LENGTH_LONG).show()
            }
        }
    }
}