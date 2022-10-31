package com.github.ch8n.recursion.impl

import com.github.ch8n.recursion.TailRecursion

internal class TailRecursionImpl : TailRecursion {
    override fun repeat(times: Int, step: Int, action: (step: Int) -> Unit) {
        if (times > 0) {
            action.invoke(step)
            repeat(times = times - 1, step = step + 1, action = action)
        }
    }

    override fun <T> List<T>.onEach(index: Int, action: (item: T) -> Unit) {
        if (index <= lastIndex) {
            action.invoke(get(index))
            onEach(index + 1, action)
        }
    }

    override fun <T> List<T>.onReversed(index: Int, action: (item: T) -> Unit) {
        val currentIndex = lastIndex - index
        if (currentIndex >= 0) {
            action.invoke(get(currentIndex))
            onReversed(index + 1, action)
        }
    }

    override fun fibonacci(first: Int, second: Int, target: Int, inclusive: Boolean): List<Int> {
        val accumulator = mutableListOf<Int>()

        if (inclusive) {
            accumulator.add(first)
            accumulator.add(second)
            if (target <= 2) {
                return accumulator.take(target)
            }
        }

        val _target = if (inclusive) target - 2 else target

        if (_target > 0) {
            val sum = first + second
            accumulator.add(sum)
            accumulator.addAll(
                fibonacci(
                    first = second,
                    second = sum,
                    target = _target - 1,
                    inclusive = false
                )
            )
        }

        return accumulator
    }

    override fun factorial(target: Int): Int {
        return if (target > 1) {
            target * factorial(target - 1)
        } else {
            1
        }
    }

    override fun Int.power(times: Int): Int {
        if (times == 0) {
            return 1
        }
        if (times == 1) {
            return this
        }
        return this * power(times - 1)
    }
}
