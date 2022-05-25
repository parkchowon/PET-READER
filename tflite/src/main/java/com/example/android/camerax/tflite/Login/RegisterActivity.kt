package com.example.android.camerax.tflite.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.example.camerax.tflite.R
import com.example.android.camerax.tflite.Home.HomeActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = Firebase.auth

        val joinBtn = findViewById<Button>(R.id.registerBtn)
        joinBtn.setOnClickListener {

            val email = findViewById<EditText>(R.id.loginEditTextID)
            val password = findViewById<EditText>(R.id.loginEditTextPassword)

            auth.createUserWithEmailAndPassword(email.text.toString(), password.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "회원가입이 완료되었습니다.", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this, "다시 시도해 주십시오.", Toast.LENGTH_SHORT).show()
                    }
                }
        }

    }
}