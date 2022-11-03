package com.github.ch8n.recursion.algo

import com.github.ch8n.recursion.ifZero


// TODO
//  taylor with Horners Rule
//  Interative method
//  update current to remove globals
class TaylorSeries {
    // 3e^x

    operator fun invoke(x: Int, terms: Int): Double {
        terms.ifZero { return 1.0 }
        val result = invoke(x, terms - 1)
        power *= x
        factorial *= terms
        return result + power / factorial
    }

    companion object {
        private var power = 1.0
        private var factorial = 1.0
    }
}