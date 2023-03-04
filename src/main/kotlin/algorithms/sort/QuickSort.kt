package algorithms.sort

class QuickSort {

    companion object {
        fun quickSort(arr: IntArray, left: Int, right: Int) {
            if (left >= right) return

            // choose pivot as the middle element
            val pivot = arr[(left + right) / 2]

            // partition the array around pivot
            val index = partition(arr, left, right, pivot)

            // sort the subarrays recursively
            quickSort(arr, left, index - 1)
            quickSort(arr, index, right)
        }

        private fun partition(arr: IntArray, left: Int, right: Int, pivot: Int): Int {
            var i = left
            var j = right

            while (i <= j) {
                while (arr[i] < pivot) {
                    i++
                }

                while (arr[j] > pivot) {
                    j--
                }

                if (i <= j) {
                    val temp = arr[i]
                    arr[i] = arr[j]
                    arr[j] = temp
                    i++
                    j--
                }
            }

            return i
        }

    }
}