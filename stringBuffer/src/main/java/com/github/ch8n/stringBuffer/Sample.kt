package com.github.ch8n.stringBuffer

internal fun main() {
    val stringBuffer = StringBuffer()
    stringBuffer.appendLine("Hello")
    stringBuffer.append("world!")
    val str = stringBuffer.build()
    println(str)

    val str2 = buildString {
        appendLine("hello")
        append("world")
        append("!")
    }
    println(str2)
}
