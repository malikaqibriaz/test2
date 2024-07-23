package com.example.sharedpreferenceskotlin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        btnSignup.setOnClickListener {
            val name= editTextName.text.toString()
            val email= editTextEmail.text.toString()
            val password= editTextPassword.text.toString()

            if (email.isEmpty() || password.isEmpty() || name.isEmpty()) {
                Toast.makeText(this, "Fields can't be Empty", Toast.LENGTH_SHORT).show()
            } else if ((!Patterns.EMAIL_ADDRESS.matcher(email).matches())) {
                Toast.makeText(this, "Invalid Email Address", Toast.LENGTH_SHORT).show()
            } else if (password.length<6) {
                editTextPassword.error = "Password Should be of 6 characters"
            }else {
                val sharedPreferences: SharedPreferences =
                    getSharedPreferences("SharedPrefs", Context.MODE_PRIVATE)
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString("String", name)
                editor.putString("String1", email)
                editor.putString("String2", password)
                editor.apply()
                Toast.makeText(this, "Data Saved", Toast.LENGTH_LONG).show()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }

    }
}