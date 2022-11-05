package com.example.challangechapter7.view

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class SplashscreenUtilsTest {
    lateinit var spalsscreen: SplashscreenUtils

    @Before
    fun setUp() {
        spalsscreen = SplashscreenUtils
    }

    @Test
    fun loading_time_to_long() {
        assert(
            spalsscreen.SplashscreenValidate(1500)
                    == "loading time to Long"
        )
    }
}