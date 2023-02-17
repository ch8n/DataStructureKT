package com.github.ch8n.array

inline fun <T> buildMutableList(operation: MutableList<T>.() -> Unit): MutableList<T> =
    buildList(operation).toMutableList()


class GenericIterator<T>(
    private val iterableSize: Int,
    private val getItemAt: (index: Int) -> T
) : Iterator<T> {

    private var currentIndex = 0
    override fun hasNext(): Boolean = currentIndex < iterableSize

    override fun next(): T {
        if (!hasNext()) throw NoSuchElementException()
        return getItemAt(currentIndex)
            .also { currentIndex += 1 }
    }
}