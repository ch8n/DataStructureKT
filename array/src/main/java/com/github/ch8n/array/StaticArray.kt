package com.github.ch8n.array


/***
 * Fixed array doesn't have ability to add or remove elements
 * it can only set and get data from array
 */
interface StaticArrayOperations<T> : Iterable<T> {

    // returns element at given index
    fun get(index: Int): T

    // update value at given index
    fun set(index: Int, item: T)

    // number of elements in array
    val size: Int

    // index of last element
    val lastIndex: Int
}

class StaticArray<T> private constructor(size: Int, initializer: (index: Int) -> T) : StaticArrayOperations<T> {

    private val _array = Array(size) { initializer.invoke(it) as Any }

    companion object {
        fun <T> of(size: Int, initializer: (index: Int) -> T): StaticArray<T> = StaticArray(size, initializer)
    }

    private fun checkValidRange(index: Int) {
        val isValidRange = index in 0.._array.lastIndex
        if (!isValidRange) {
            throw IndexOutOfBoundsException("Invalid index range!")
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun get(index: Int): T {
        checkValidRange(index)
        return _array.get(index) as T
    }

    override val size: Int = _array.size

    override val lastIndex: Int
        get() = size - 1

    override fun iterator(): Iterator<T> {
        return GenericIterator(size, ::get)
    }

    override fun set(index: Int, item: T) {
        checkValidRange(index)
        _array.set(index, item as Any)
    }
}

fun <T> staticArrayOf(size: Int, initializer: (index: Int) -> T): StaticArray<T> =
    StaticArray.of(size, initializer)

fun <T> staticArrayOf(vararg items: T) = StaticArray.of(items.size, items::get)

fun <T> List<T>.toStaticArray(): StaticArray<T> {
    return staticArrayOf(size) { get(it) }
}