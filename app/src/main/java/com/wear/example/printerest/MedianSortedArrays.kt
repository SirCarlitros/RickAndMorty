package com.wear.example.printerest


fun main() {
    val array1 : IntArray = intArrayOf(1,3)
    val array2 : IntArray = intArrayOf(2)

    println(findMedianSortedArrays(array1,array2))
}

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val newArray = if(nums1.size >= 1 && nums2.size >= 1) nums1 + nums2 else if(nums2.size == 0) nums1 else nums2

    val sortedArray = newArray.sortedArray()

    val middleIndex = (sortedArray.size / 2)

    if(sortedArray.size == 1 ) return sortedArray[0].toDouble()


    return if(sortedArray.size % 2 != 0){
        sortedArray[middleIndex].toDouble()
    }
    else{
        (sortedArray[middleIndex] + sortedArray[middleIndex - 1]) / 2.0
    }
}