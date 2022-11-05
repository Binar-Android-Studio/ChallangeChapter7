package com.example.challangechapter7.view


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challangechapter7.databinding.ActivityFavoriteBinding
import com.example.challangechapter7.viewmodel.ViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteActivity : AppCompatActivity() {

    lateinit var binding : ActivityFavoriteBinding
    lateinit var listAdapter : ListAdapter
    lateinit var  sharedPrefs : SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.profilePage.setOnClickListener(){
            var move = Intent(this, ProfileActivity::class.java)
            startActivity(move)
        }

        binding.favoritePage.setOnClickListener(){
            var move = Intent(this, ProfileActivity::class.java)
            startActivity(move)
        }

        sharedPrefs = getSharedPreferences("registerData", Context.MODE_PRIVATE)
        var nameData = sharedPrefs.getString("name", null)
        binding.greatingname.setText("Welcome, "+ nameData + " !")
    }

}