package com.wear.example.printerest

import java.math.BigInteger


class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun reverseListNode(l: ListNode): Int {
    var newList = l
    var integrer = l.`val`.toString()
    while(newList.next != null){
        newList = newList.next!!
        integrer += newList.`val`.toString()
    }
    return integrer.reversed().toInt()
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode {
    val firstInt = l1?.let{reverseListNode(it)} ?: 0
    val secondInt = l2?.let{reverseListNode(it)} ?: 0
    val sum = firstInt + secondInt

    return sum.toListNode()
}

fun Int.toListNode(): ListNode {
    val iterator = this.toString().reversed().iterator()
    val finalList = ListNode(iterator.next().digitToInt())

    var nextList = finalList

    while (iterator.hasNext()){
        val item = iterator.next().digitToInt()
        val tempList = ListNode(item)
        nextList.next = tempList
        nextList = tempList
    }
    return finalList
}


fun main() {

    val listNode = ListNode(2).apply {
        next = ListNode(1).apply {
            next = ListNode(5)
        }
    }
    println(reverseListNode(listNode))

    val delta = 2345.toListNode()
    println("delta")
    val deltaa = "1000000000000000000000000000001".toBigInteger()
    val deltaaa = "1000000000000000000000000000001".toBigInteger()
    val asdd = 22 % 10
    println(asdd.toString())
}