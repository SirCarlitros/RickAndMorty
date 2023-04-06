package com.wear.example.printerest

fun main() {
    val stringTest01 = "babad"
    val stringTest02 = "cbbd"
    val stringTest03 = "aacabdkacaa"
    println(longestPalindrome(stringTest03))
}


fun longestPalindrome(s: String): String {
    val reversed = s.reversed()
    var maxLength= ""

    for (i in s.indices){
        for(j in i+1..s.length){
            val sub = s.substring(i,j)
            if(sub.reversed().contains(sub)) if(maxLength.length < sub.length) maxLength = sub
        }
    }

    return maxLength
}