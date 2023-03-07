package algorithms.sort

internal class TwoSumSolution {
    fun twoSum1(nums: IntArray, target: Int): IntArray {
        val n = nums.size
        for (i in 0 until n) {
            for (j in i + 1 until n) {
                if (nums[i] + nums[j] == target) {
                    return intArrayOf(i, j)
                }
            }
        }
        return IntArray(0)
    }

    fun twoSum2(nums: IntArray, target: Int): IntArray {
        val n = nums.size
        val hashMap = HashMap<Int, Int>()
        for (i in 0 until n) {
            if (hashMap.containsKey(target - nums[i])) {
                return intArrayOf(i, hashMap[target - nums[i]]!!)
            }
            hashMap.put(nums[i], i)
        }
        return intArrayOf()
    }

}