package com.github.ch8n.recursion.impl

import com.github.ch8n.recursion.HeadRecursion

class HeadRecursionImpl : HeadRecursion {
    override fun repeat(times: Int, step: Int, action: (step: Int) -> Unit) {
        val currentStep = times - 1
        if (times > 0) {
            repeat(times = times - 1, step = currentStep, action = action)
            action.invoke(currentStep)
        }
    }
}
