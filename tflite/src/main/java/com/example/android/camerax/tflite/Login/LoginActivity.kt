package com.example.android.camerax.tflite.Login

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.example.camerax.tflite.R
import com.android.example.camerax.tflite.databinding.ActivityLoginBinding
import com.example.android.camerax.tflite.Home.HomeActivity
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private val binding get() = _binding!!
    private var _binding: ActivityLoginBinding? = null




    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = Firebase.auth

        //로그인하면 홈화면에 가는 버튼
        val loginBtn = findViewById<Button>(R.id.loginBtn)
        loginBtn.setOnClickListener {

            val email = findViewById<EditText>(R.id.loginEditTextID)
            val password = findViewById<EditText>(R.id.loginEditTextPassword)

            auth.signInWithEmailAndPassword(email.text.toString(), password.text.toString())
                .addOnCompleteListener(this) { task ->
                    //로그인이 성공할 경우 홈화면으로 이동한다.
                    if (task.isSuccessful) {
                        val intent = Intent(this, HomeActivity::class.java)
                        startActivity(intent)
                        finish()
                    //로그인에 실패할 경우 메세지를 띄운다.
                    } else {
                        Toast.makeText(this, "아이디 혹은 비밀번호가 일치하지 않습니다.", Toast.LENGTH_LONG).show()
                    }
                }

        }

        //비밀번호 노출 토글
        val showPassword = findViewById<TextInputLayout>(R.id.TextInputLayoutPassword)
        showPassword.setPasswordVisibilityToggleEnabled(true)

        //회원가입으로 가는 TextView 버튼
        val GoRegisterBtn = findViewById<TextView>(R.id.loginToJoin)
        GoRegisterBtn.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}