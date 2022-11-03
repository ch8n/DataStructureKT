package com.github.ch8n.recursion.impl

import com.github.ch8n.recursion.MemoizationRecursion

internal class MemoizationRecursionImpl : MemoizationRecursion {

    override fun sumFibonacci(target: Int, memory: Map<Int, Int>): Int {

        if (memory.containsKey(target)) {
            return requireNotNull(memory.get(target))
        }

        val memo = memory.toMutableMap()

        if (target <= 1) {
            return target
        }

        val result1 = sumFibonacci(target - 2, memory)
            .apply { memo.put(target, this) }

        val result2 = sumFibonacci(target - 1, memory)
            .apply { memo.put(target, this) }

        return result1 + result2
    }

}
