package com.github.ch8n.recursion.impl

import com.github.ch8n.recursion.HeadRecursion

internal class HeadRecursionImpl : HeadRecursion {

    override fun repeat(times: Int, step: Int, action: (step: Int) -> Unit) {
        val currentStep = times - 1
        if (times > 0) {
            repeat(times = times - 1, step = currentStep, action = action)
            action.invoke(currentStep)
        }
    }

    override fun <T> List<T>.onEach(index: Int, action: (item: T) -> Unit) {
        val currentIndex = lastIndex - index
        if (currentIndex >= 0) {
            onEach(index + 1, action)
            action.invoke(get(currentIndex))
        }
    }

    override fun <T> List<T>.onReversed(index: Int, action: (item: T) -> Unit) {
        if (lastIndex - index >= 0) {
            onReversed(index + 1, action)
            action.invoke(get(index))
        }
    }

    override fun factorial(target: Int): Int {
        if (target > 1) {
            return factorial(target - 1) * target
        }
        return 1
    }

    override fun Int.power(times: Int): Int {
        if (times == 0) return 1
        if (times == 1) return this
        return power(times - 1) * this
    }

    override fun List<Int>.sum(step: Int): Int {
        val currentIndex = lastIndex - step
        if (currentIndex >= 0) {
            return sum(step + 1) + get(currentIndex)
        }
        return 0
    }
}
