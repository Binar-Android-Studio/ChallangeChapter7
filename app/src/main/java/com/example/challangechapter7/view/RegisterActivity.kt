package com.example.challangechapter7.view

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModelProvider
import com.example.challangechapter7.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    lateinit var  sharedPreferences: SharedPreferences
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth
        binding.btnregister.setOnClickListener(){
            val name        = binding.name.text.toString()
            val username    = binding.username.text.toString()
            val email       = binding.email.text.toString()
            val pass1       = binding.password.text.toString()
            val pass2       = binding.password2.text.toString()
            val phone       = "+91 7999193854"
            val aboutme     = "Doing at the sweet spot between aesthetics and elegance to give life to your brand.My opinion belong to nobody but myself. "
            val address     = "Melirang Wetan Bungah Gresik"

            sharedPreferences = getSharedPreferences("registerData", Context.MODE_PRIVATE)

            if(pass1 == pass2){
                var addData = sharedPreferences.edit()
                addData.putString("name", name)
                addData.putString("username", username)
                addData.putString("email", email)
                addData.putString("pass", pass1)
                addData.putString("phone", phone)
                addData.putString("aboutme", aboutme)
                addData.putString("address", address)

                addData.apply()

                var move = Intent(this, LoginActivity::class.java)
                startActivity(move)
            }
            else
                Toast.makeText(this, "Password Yang Dimasukkan Tidak Sama", Toast.LENGTH_SHORT).show()
        }

        binding.btnSignUpGoogle.setOnClickListener(){
            val name        = binding.name.text.toString()
            val username    = binding.username.text.toString()
            val email       = binding.email.text.toString()
            val pass1       = binding.password.text.toString()
            val pass2       = binding.password2.text.toString()
            val phone       = "+91 7999193854"
            val aboutme     = "Doing at the sweet spot between aesthetics and elegance to give life to your brand.My opinion belong to nobody but myself. "
            val address     = "Melirang Wetan Bungah Gresik"
            sharedPreferences = getSharedPreferences("registerData", Context.MODE_PRIVATE)
            if(pass1 == pass2){
                var addData = sharedPreferences.edit()
                addData.putString("name", name)
                addData.putString("username", username)
                addData.putString("email", email)
                addData.putString("pass", pass1)
                addData.putString("phone", phone)
                addData.putString("aboutme", aboutme)
                addData.putString("address", address)

                addData.apply()
                signUpGoogle(email,pass1)
            }
            else
                Toast.makeText(this, "Password Yang Dimasukkan Tidak Sama", Toast.LENGTH_SHORT).show()
        }

        binding.logintriger.setOnClickListener(){
            var move = Intent(this, LoginActivity::class.java)
            startActivity(move)
        }

    }
    fun signUpGoogle(email : String, password : String){
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser
                    Toast.makeText(this, "Data Berhasil Disimpan", Toast.LENGTH_SHORT).show()
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    Toast.makeText(this, "Data Gagal Disimpan", Toast.LENGTH_SHORT).show()
                }
            }
    }
}