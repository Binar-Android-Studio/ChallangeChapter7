package com.example.challangechapter7.view

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.analytics.ktx.analytics
import com.example.challangechapter7.databinding.ActivityLoginBinding
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class LoginActivity() : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var  sharedPrefs : SharedPreferences
    private lateinit var analytics: FirebaseAnalytics
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        analytics = Firebase.analytics
        setContentView(binding.root)
        auth = Firebase.auth

        binding.btnLogin.setOnClickListener{
            var usernamelgn = binding.username.text.toString()
            var passwordlgn = binding.password.text.toString()
            loginWithGoogle(usernamelgn,passwordlgn)
        }

        val signInLauncher = registerForActivityResult(
            FirebaseAuthUIActivityResultContract()
        ) { res ->
            onSignInResult(res)
        }

        binding.register.setOnClickListener(){
            var move = Intent(this, RegisterActivity::class.java)
            startActivity(move)
        }

        binding.btnLoginGoogle.setOnClickListener(){
            val providers = arrayListOf(
                AuthUI.IdpConfig.EmailBuilder().build(),
                AuthUI.IdpConfig.PhoneBuilder().build(),
                AuthUI.IdpConfig.GoogleBuilder().build(),
                AuthUI.IdpConfig.TwitterBuilder().build())

            val signInIntent = AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .build()
            signInLauncher.launch(signInIntent)
        }
    }
    private fun onSignInResult(result: FirebaseAuthUIAuthenticationResult) {
        val response = result.idpResponse
        if (result.resultCode == RESULT_OK) {
            // Successfully signed in
            val user = FirebaseAuth.getInstance().currentUser
            Toast.makeText(this, "Login Sucsess", Toast.LENGTH_SHORT).show()
            var move = Intent(this, MainActivity::class.java)
            startActivity(move)
        } else {
            Toast.makeText(this, "Login Un berhasil", Toast.LENGTH_SHORT).show()
        }
    }

    fun shredpreflogin(){
        sharedPrefs = getSharedPreferences("registerData", MODE_PRIVATE)

        var usernameData = sharedPrefs.getString("username", null)
        var passwordData = sharedPrefs.getString("pass", null)

        var usernamelgn = binding.username.text.toString()
        var passwordlgn = binding.password.text.toString()

        if (usernamelgn == usernameData && passwordData == passwordlgn){
            var addData = sharedPrefs.edit()
            addData.putString("usernamelgn", usernamelgn)
            addData.putString("passwordlgn", passwordlgn)
            addData.apply()
            Toast.makeText(this, "Login Sucsessfull", Toast.LENGTH_SHORT).show()

            var move = Intent(this, MainActivity::class.java)
            startActivity(move)
        }
        else
            Toast.makeText(this, "Username Dan Password Tidak Cocok !!", Toast.LENGTH_SHORT).show()
    }

    fun loginWithGoogle (email : String, password : String){
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success")
                    val user = auth.currentUser
                    Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show()
                    var move = Intent(this, MainActivity::class.java)
                    startActivity(move)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }

}