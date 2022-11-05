package com.example.challangechapter7.view

object RegisterUtils {
    private val existingUsers = listOf("Behroz", "Bahram", "Parmida", "Raika")

    fun validateRegister(username : String, email : String, phone: String, password : String, Age : Int) : String?{
        if (username.isEmpty()) return "please enter username"
        if (username.length < 6) return "very short username"
        if (username.length > 20) return "long username"

        if (email.isEmpty()) return "please enter email"
        if (!email.contains("@")) return "please enter valid email"
        if (email.filter { it.isDigit() }.isEmpty()) return "email must contain at least one digit"

        if (phone.length <10 ) return "please enter valid phone number"
        if (phone.length >12 ) return "please enter valid phone number"

        if(password.isEmpty()) return "please enter password"
        if(password.length<6)return "please enter valid password"
        if(password.length>50)return "please enter valid password"

        if(Age==0) return "please enter valid age"
        if(Age<18) return "not eligible"

        if (username in RegisterUtils.existingUsers)
            return "exitingUsername"

        return "sucsess"
    }
}