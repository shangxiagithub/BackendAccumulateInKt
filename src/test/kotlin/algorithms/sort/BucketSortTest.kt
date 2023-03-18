package algorithms.sort

import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Test

class BucketSortTest {

    @BeforeEach
    fun setUp() {
    }

    @Test
    fun testBucketSort() {
        val arr = intArrayOf(78, 17, 39, 26, 72, 94, 21, 12, 23, 68)
        val biggestGap = BucketSort.biggestGap(arr)
        println("biggestGap = $biggestGap")
    }
    /**
     * 78, 17, 39, 26, 72, 94, 21, 12, 23, 68
     *
     * 12, 17, 21, 23, 26, 39, 68, 72, 78, 94
     */
}