package algorithms.sort

class BucketSort {

    companion object {
        fun biggestGap(target: IntArray): Int {
            val n = target.size
            if (n < 2) return 0

            val min = target.min()
            val max = target.max()

            val d = (max - min) / (n - 1)
            val bucketSize = (max - min) / d + 1

            val tempBucket = Array(bucketSize) { IntArray(2) }

            for (i in tempBucket.indices) {
                tempBucket[i][0] = -1
                tempBucket[i][1] = -1
            }

            for (num in target) {
                val idx = (num - min) / d
                if (tempBucket[idx][0] == -1) {
                    tempBucket[idx][0] = num
                    tempBucket[idx][1] = num
                } else {
                    tempBucket[idx][0] = tempBucket[idx][0].coerceAtMost(num)
                    tempBucket[idx][1] = tempBucket[idx][1].coerceAtLeast(num)
                }
            }

            println(tempBucket.map { it.contentToString() })

            var ret = 0
            var prev = 0
            for (range in 0 until bucketSize) {
                if (tempBucket[range][0] == -1) {
                    continue
                } else {
                    ret = (tempBucket[range][0] - tempBucket[prev][1]).coerceAtLeast(ret)
                }
                prev = range
            }
            return ret
        }
    }
}