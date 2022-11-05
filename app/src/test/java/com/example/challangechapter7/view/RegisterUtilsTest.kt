package com.example.challangechapter7.view

import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class RegisterUtilsTest {
    lateinit var register : RegisterUtils

    @Before
    fun setUp() {
        register = RegisterUtils
    }

    @After
    fun tearDown() {
    }

    @Test
    fun username_is_empty() {
        val username = ""
        val assert = register.validateRegister(username, "dflja@3","085859600019", "dkjafjla", 20)
        assert(assert == "please enter username")
    }


    @Test
    fun username_length_less_than_6() {
        val username = "xnaaa"
        assert(
            register.validateRegister(username, "dflja@3", "085859600019","dkjafjla", 20)
                    == "very short username"
        )
    }

    @Test
    fun username_length_very_long(){
        val username="xaxsaxasxmaskxasmxlaksx"
        assert(
            register.validateRegister(username, "dflja@3", "085859600019","dkjafjla", 20)
                    == "long username"
        )
    }
    @Test
    fun exitingUsername(){
        val username="Behroz"
        assert(
            register.validateRegister(username, "dflja@3","085859600019", "dkjafjla", 20)
                    == "exitingUsername"
        )
    }
    @Test
    fun phoneNumberWrong(){
        val phone = "08585"
        assert(
            register.validateRegister("xnasssaa", "dflja@3", phone,"dkjafjla", 20)
                    == "please enter valid phone number"
        )

    }
    @Test
    fun passwordToSort(){
        val username="assxsaxasxsa"
        val password = "a"
        assert(
            register.validateRegister(username, "dflja@3","085859600019", password, 20)
                    == "please enter valid password"
        )
    }
    @Test
    fun passwordToLong(){
        val username="sxsxasxsa"
        val password = "xaxsaskxxaxasxasxsaxasxsaxsaxxasxasxasxasxasxasjxnaskxjnasxkjasnxkasjnxasxsaxsaxsaxasmxlaksx"
        assert(
            register.validateRegister(username, "dflja@3","085859600019", password, 20)
                    == "please enter valid password"
        )
    }
}