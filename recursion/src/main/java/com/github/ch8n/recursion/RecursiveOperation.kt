package com.github.ch8n.recursion


interface RecursiveOperation {
    fun sum(): Int
}

interface HeadRecursion : RecursiveOperation

interface TailRecursion : RecursiveOperation
