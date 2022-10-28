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

    // 4 = 1 * 2 * 3 * 4
   override fun factorial(target: Int): Int {
        if (target > 1) {
            return factorial(target - 1) * target
        }
        return 1
    }

}
