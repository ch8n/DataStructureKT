package com.github.ch8n.array


/***
 * Fixed array doesn't have ability to add or remove elements
 * it can only set and get data from array
 */
interface FixedArrayOperations<T> : Iterable<T> {

    // returns element at given index
    fun get(index: Int): T

    // update value at given index
    fun set(index: Int, item: T)

    // number of elements in array
    val size: Int
}

class FixedArray<T> private constructor(size: Int, initializer: (index: Int) -> T) : FixedArrayOperations<T> {

    private val _array = Array(size) { initializer.invoke(it) as Any }

    companion object {
        fun <T> of(size: Int, initializer: (index: Int) -> T): FixedArray<T> = FixedArray(size, initializer)
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

    override fun iterator(): Iterator<T> {
        return GenericIterator(size, ::get)
    }

    override fun set(index: Int, item: T) {
        checkValidRange(index)
        _array.set(index, item as Any)
    }
}

fun <T> fixedArrayOf(size: Int, initializer: (index: Int) -> T): FixedArray<T> =
    FixedArray.of(size, initializer)

fun <T> fixedArrayOf(vararg items: T) = FixedArray.of(items.size, items::get)
