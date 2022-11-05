package com.example.challangechapter7.view

import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class LoginUtilsTest {
    lateinit var login : LoginUtils

    @Before
    fun setUp() {
        login = LoginUtils
    }

    @After
    fun tearDown() {
    }

    @Test
    fun username_is_empty() {
        val username = ""
        val assert = login.validate(username, "dflja@3", "dkjafjla", 20)
        assert(assert == "please enter username")
    }


    @Test
    fun username_length_less_than_6() {
        val username = "xnaaa"
        assert(
            LoginUtils.validate(username, "dflja@3", "dkjafjla", 20)
                    == "very short username"
        )
    }

    @Test
    fun username_length_very_long(){
        val username="xaxsaxasxmaskxasmxlaksx"
        assert(
            LoginUtils.validate(username, "dflja@3", "dkjafjla", 20)
                    == "long username"
        )
    }
    @Test
    fun exitingUsername(){
        val username="Behroz"
        assert(
            LoginUtils.validate(username, "dflja@3", "dkjafjla", 20)
                    == "exitingUsername"
        )
    }

    @Test
    fun passwordToSort(){
        val username="assxsaxasxsa"
        val password = "a"
        assert(
            LoginUtils.validate(username, "dflja@3", password, 20)
                    == "please enter valid password"
        )
    }
    @Test
    fun passwordToLong(){
        val username="sxsxasxsa"
        val password = "xaxsaskxxaxasxasxsaxasxsaxsaxxasxasxasxasxasxasjxnaskxjnasxkjasnxkasjnxasxsaxsaxsaxasmxlaksx"
        assert(
            LoginUtils.validate(username, "dflja@3", password, 20)
                    == "please enter valid password"
        )
    }
}