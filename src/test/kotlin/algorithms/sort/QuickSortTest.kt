package algorithms.sort

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class QuickSortTest {

    @Test
    fun quickSort() {
        val arr = intArrayOf(5, 2, 9, 7, 1, 8, 10, 4)
        QuickSort.quickSort(arr, 0, arr.size - 1)
        println(arr.contentToString()) // prints "[1, 2, 4, 5, 7, 8, 9, 10]"
    }
    /**
     * 5, 2, 9, 7, 1, 8, 10, 4
     *
     * 5, 2, 4, 7, 1, 8, 10, 9
     * 5, 2, 4, 1, 7, 8, 10, 9
     *
     * 1, 2, 4, 5, 7, 8, 10, 9
     *
     * 1, 2, 4, 5, 7, 8, 9, 10
     */
}