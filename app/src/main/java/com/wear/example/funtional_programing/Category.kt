package com.wear.example.funtional_programing

inline infix fun <A, B, C> Fun<B, C>.after(crossinline f: Fun<A, B>): Fun<A, C> {
    return { a: A ->
        this(f(a))
    }
}

inline infix fun <A, B, C> Fun<A, B>.compose(crossinline g: Fun<B, C>): Fun<A, C> {
    return { a: A ->
        g(this(a))
    }
}


val functionAB: (Int) -> String = { it.toString() }
val functionBC: (String) -> Long = { it.toLong() }

val functionAC = functionBC after functionAB
val functionAC2 = functionAB compose functionBC


fun main() {

    println("The result is ${functionAC(10)}")
    println("The result is function 2 ${functionAC2(10)}")
}

