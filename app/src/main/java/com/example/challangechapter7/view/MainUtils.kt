package com.example.challangechapter7.view

object MainUtils {
    fun validateMain(ProductShow : Int, loadingTime : Int) : String?{
        if (ProductShow > 50) return "product Show To Many"
        if (loadingTime > 3000) return "Loading Time To Long"

        return "Sucsess"
    }
}