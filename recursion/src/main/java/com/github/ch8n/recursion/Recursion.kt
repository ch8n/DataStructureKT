package com.github.ch8n.recursion

import com.github.ch8n.recursion.impl.HeadRecursionImpl
import com.github.ch8n.recursion.impl.MemoizationRecursionImpl
import com.github.ch8n.recursion.impl.TailRecursionImpl

class Recursion {
    private val headRecursionImpl = HeadRecursionImpl()
    private val tailRecursionImpl = TailRecursionImpl()
    private val memoizationRecursionImpl = MemoizationRecursionImpl()

    fun <T> head(headRecursion: HeadRecursion.() -> T): T {
        return headRecursion.invoke(headRecursionImpl)
    }

    fun <T> tail(tailRecursion: TailRecursion.() -> T): T {
        return tailRecursion.invoke(tailRecursionImpl)
    }

    fun <T> memo(memoizationRecursion: MemoizationRecursion.() -> T): T {
        return memoizationRecursion.invoke(memoizationRecursionImpl)
    }
}

inline fun <T> recursion(recursion: Recursion.() -> T): T {
    val _recursion = Recursion()
    return recursion.invoke(_recursion)
}
