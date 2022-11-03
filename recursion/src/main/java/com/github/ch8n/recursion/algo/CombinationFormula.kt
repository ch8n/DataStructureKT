package com.github.ch8n.recursion.algo

import com.github.ch8n.recursion.recursion

// TODO
// check if answer is correct
//  using pascal triangle method
//  apply memorzation for performance
class CombinationFormula {
    //ncr = n!/r!(n-r)!
    operator fun invoke(n: Int, r: Int): Int {
        val factorialN = recursion { head { factorial(n) } }
        val factorialR = recursion { head { factorial(r) } }
        val factorialNMinusR = recursion { head { factorial(n - r) } }
        return factorialN / (factorialR * (factorialNMinusR))
    }
}