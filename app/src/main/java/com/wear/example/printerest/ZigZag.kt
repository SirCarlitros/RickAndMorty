package com.wear.example.printerest

fun main() {
    val testCase01 = "PAYPALISHIRING"
    println(convert(testCase01,3))

    testCase01.split(" ")
    val number= -123
    println()

}

fun convert(s: String, numRows: Int): String {
    if(numRows == 1) return s

    if (numRows == 2){
        var first = ""
        var second = ""
        s.forEachIndexed { index, c -> if (index % 2 == 0) first += c else second += c}
        return first + second
    }

    val mutableList = MutableList(numRows){""}
    val cycle = 2 * (numRows - 1)

    s.forEachIndexed { index, c ->
        val module = index % cycle

        if(module == 0) {
            mutableList[0] = mutableList[0] + c
        }
        else if(module == (numRows - 1)) {
            mutableList[numRows - 1] = mutableList[numRows - 1] + c
        }
        else if(module >= numRows ) {
            mutableList[cycle - module] = mutableList[cycle - module] + c
        }
        else{
            mutableList[module] = mutableList[module] + c
        }
    }

    return mutableList.joinToString("")
}