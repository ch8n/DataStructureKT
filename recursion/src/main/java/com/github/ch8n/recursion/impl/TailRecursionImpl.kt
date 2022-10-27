package com.github.ch8n.recursion.impl

import com.github.ch8n.recursion.TailRecursion

internal class TailRecursionImpl : TailRecursion {
    override fun repeat(times: Int, step: Int, action: (step: Int) -> Unit) {
        if (times > 0) {
            action.invoke(step)
            repeat(times = times - 1, step = step + 1, action = action)
        }
    }

}
