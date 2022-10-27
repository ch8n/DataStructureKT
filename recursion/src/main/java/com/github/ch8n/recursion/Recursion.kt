package com.github.ch8n.recursion

import com.github.ch8n.recursion.impl.HeadRecursionImpl
import com.github.ch8n.recursion.impl.TailRecursionImpl

class Recursion {
    private val headRecursionImpl = HeadRecursionImpl()
    private val tailRecursionImpl = TailRecursionImpl()

    fun <T> head(headRecursion: HeadRecursion.() -> T): T {
        return headRecursion.invoke(headRecursionImpl)
    }

    fun <T> tail(tailRecursion: TailRecursion.() -> T): T {
        return tailRecursion.invoke(tailRecursionImpl)
    }
}

inline fun <T> recursion(recursion: Recursion.() -> T): T {
    val _recursion = Recursion()
    return recursion.invoke(_recursion)
}
