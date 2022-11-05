package com.example.challangechapter7.view

object SplashscreenUtils {
    fun SplashscreenValidate(time : Int) : String{
        if (time >1000) return "loading time to Long"

        return "sucsess"
    }
}