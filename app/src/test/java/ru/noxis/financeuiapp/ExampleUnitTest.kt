package ru.noxis.financeuiapp

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
//        assertEquals(4, 2 + 2)

        val list: List<Float> = listOf(10f, 20f, 3f, 1f)
        val zipList: List<Pair<Float, Float>> = list.zipWithNext()
        val max = list.max()
        val min = list.min()
        println(zipList)
        println(max)
        println(min)

        for (pair in zipList) {
            println(pair)
            val fromValuePercentage = getValuePercentageForRange(pair.first, max, min)
            val toValuePercentage = getValuePercentageForRange(pair.second, max, min)
            println(fromValuePercentage)
            println(toValuePercentage)
        }

    }
}

private fun getValuePercentageForRange(value: Float, max: Float, min: Float) =
    (value - min) / (max - min)