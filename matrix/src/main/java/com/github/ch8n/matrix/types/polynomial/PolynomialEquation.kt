package com.github.ch8n.matrix.types.polynomial

import kotlin.math.pow


data class EquationTerm(
    val coefficient: Int,
    val power: Int
)

data class EquationBuilder(val variable: Double) {

    private var _result = 0.0
    val result get() = _result

    operator fun plus(term: EquationTerm) {
        val compute = term.coefficient * (variable.pow(term.power))
        _result += compute
    }

    operator fun minus(term: EquationTerm) {
        val compute = term.coefficient * (variable.pow(term.power))
        _result -= compute
    }

    operator fun times(term: EquationTerm) {
        val compute = term.coefficient * (variable.pow(term.power))
        _result *= compute
    }

    operator fun div(term: EquationTerm) {
        val compute = term.coefficient * (variable.pow(term.power))
        _result /= compute
    }

}


fun equation(variable: Double, build: EquationBuilder.() -> Unit): Double {
    val equationBuilder = EquationBuilder(variable)
    build.invoke(equationBuilder)
    return equationBuilder.result
}
