package com.example.challangechapter7.view

import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class ProfileUtilsTest{
    lateinit var profile : ProfileUtils

    @Before
    fun setUp() {
        profile = ProfileUtils
    }

    @After
    fun tearDown() {
    }


    @Test
    fun phone_less() {
        val assert = profile.validateProfile("0123","hahahahahaha","xnasxjasnxjasxnsakjxnaskxjasnxkasjnxka")
            assert(assert == "please enter valid phone number")
    }

    @Test
    fun phonetolong() {
        val assert = profile.validateProfile("0123456789101112","hahahahahaha","xnasxjasnxjasxnsakjxnaskxjasnxkasjnxka")
        assert(assert == "please enter valid phone number")
    }

    @Test
    fun aboutme_in_null() {
        val assert = profile.validateProfile("08585960019","","xnasxjasnxjasxnsakjxnaskxjasnxkasjnxka")
        assert(assert == "address require")
    }

    @Test
    fun adress_to_long() {
        val assert = profile.validateProfile("08585960019","hahahahahaha","aaaaxsaxasxsxs")
        assert(assert == "please enter valid adress")
    }

}