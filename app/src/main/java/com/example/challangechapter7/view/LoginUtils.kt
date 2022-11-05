package com.example.challangechapter7.view

object LoginUtils {
    private val existingUsers = listOf("Behroz", "Bahram", "Parmida", "Raika")

    fun validate(username : String, email : String, password : String, Age : Int) : String?{
        if (email.isEmpty()) return "please enter username"
        if (email.length < 6) return "very short username"
        if (email.length > 20) return "long username"

        if(password.isEmpty()) return "please enter password"
        if(password.length<6)return "please enter valid password"
        if(password.length>50)return "please enter valid password"

        if (username in existingUsers)
            return "exitingUsername"

        return "sucsess"
    }
}