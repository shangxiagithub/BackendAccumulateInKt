package algorithms.sort

import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Test

class BucketSortTest {

    @BeforeEach
    fun setUp() {
    }

    @Test
    fun testBucketSort() {
        val arr = intArrayOf(1,1,1,1)
//        val arr = intArrayOf(2,1,1,1)
//        val arr = intArrayOf(3,6,9,1)
//        val arr = intArrayOf(1,10000000)
        val biggestGap = BucketSort.biggestGap(arr)
        println("biggestGap = $biggestGap")
    }
    /**
     * 78, 17, 39, 26, 72, 94, 21, 12, 23, 68
     *
     * 12, 17, 21, 23, 26, 39, 68, 72, 78, 94
     */
}