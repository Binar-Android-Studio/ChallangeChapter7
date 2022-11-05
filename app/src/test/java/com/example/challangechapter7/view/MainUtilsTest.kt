package com.example.challangechapter7.view

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class MainUtilsTest{
    lateinit var main : MainUtils

    @Before
    fun setUp() {
        main = MainUtils
    }
    @Test
    fun product_show_to_long() {
        assert(
            main.validateMain(75,2500)
                    == "product Show To Many"
        )
    }
    @Test
    fun loading_time_to_long() {
        assert(
            main.validateMain(50,3500)
                    == "Loading Time To Long"
        )
    }
}
