package com.example.challangechapter7.view

import okhttp3.Address

object ProfileUtils {
    fun validateProfile ( phone : String, aboutme : String, address: String) : String{
        if (phone.length <10 ) return "please enter valid phone number"
        if (phone.length >12 ) return "please enter valid phone number"

        if (aboutme.isEmpty()) return "address require"
        if (phone.length >300 ) return "please enter valid phone adress"
        if (phone.contains("*") || phone.contains("^") || phone.contains("&")||phone.contains("(")||phone.contains(")")
        ) return "note can't include symbol"

        if (address.isEmpty()) return "address require"
        if (address.length <20 ) return "please enter valid adress"
        if (address.length >50 ) return "please enter valid adress"


        return "sucsess"
    }
}