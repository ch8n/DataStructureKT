package com.github.ch8n.stringBuffer

interface StringBufferOperation {
    fun append(str: String)
    fun appendLine(str: String = "")
    fun build(): String
}

class StringBuffer : StringBufferOperation {

    private var _accumulator = mutableListOf<String>()
    override fun append(str: String) {
        _accumulator.add(str)
    }

    override fun appendLine(str: String) {
        _accumulator.add("$str\n")
    }

    override fun build(): String {
        return _accumulator.joinToString("")
    }

}

fun buildString(builder: StringBuffer.() -> Unit): String {
    val buffer = StringBuffer()
    builder.invoke(buffer)
    return buffer.build()
}