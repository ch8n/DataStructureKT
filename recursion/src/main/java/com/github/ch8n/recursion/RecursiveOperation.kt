package com.github.ch8n.recursion


interface RecursiveOperation {
    fun repeat(times: Int, step: Int = 0, action: (step: Int) -> Unit)
}

interface HeadRecursion : RecursiveOperation

interface TailRecursion : RecursiveOperation
