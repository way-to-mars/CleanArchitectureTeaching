package ru.way2mars.exampledi.domain.usecase

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class GetDataUseCaseTest {

    @Test
    fun test1(){
        val expected = 4
        val actual = 2 + 2
        Assertions.assertEquals(expected, actual)
    }
}