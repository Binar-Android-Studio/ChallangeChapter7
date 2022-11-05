package com.example.challangechapter7.view

object LoginUtils {
    private val existingUsers = listOf("Behroz", "Bahram", "Parmida", "Raika")

    fun validate(username : String, email : String, password : String, Age : Int) : String?{
        if (username.isEmpty()) return "please enter username"
        if (username.length < 6) return "very short username"
        if (username.length > 20) return "long username"

        if (email.isEmpty()) return "please enter email"
        if (!email.contains("@")) return "please enter valid email"
        if (email.filter { it.isDigit() }.isEmpty()) return "email must contain at least one digit"

        if(password.isEmpty()) return "please enter password"
        if(password.length<6)return "please enter valid password"
        if(password.length>50)return "please enter valid password"

        if(Age==0) return "please enter valid age"
        if(Age<18) return "not eligible"

        if (username in existingUsers)
            return "exitingUsername"

        return "sucsess"
    }
}