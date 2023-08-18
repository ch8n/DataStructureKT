package com.github.ch8n.matrix.types.polynomial

fun main() {

    val equationResult = equation(2.0) {
        this + EquationTerm(3, 2)
        this + EquationTerm(2, 1)
        this - EquationTerm(5, 0)
    }

    println(equationResult)
}