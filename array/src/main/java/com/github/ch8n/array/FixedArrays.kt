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

    private val internalArray = buildMutableList {
        repeat(size) {
            add(initializer.invoke(it))
        }
    }

    companion object {
        fun <T> of(size: Int, initializer: (index: Int) -> T): FixedArray<T> = FixedArray(size, initializer)
    }

    private fun checkValidRange(index: Int) {
        val isValidRange = index >= 0 && index <= internalArray.size
        if (!isValidRange) {
            throw IndexOutOfBoundsException("Invalid index range!")
        }
    }

    override fun get(index: Int): T {
        checkValidRange(index)
        return internalArray.get(index)
    }

    override val size: Int = internalArray.size

    override fun iterator(): Iterator<T> {
        return GenericIterator(size, ::get)
    }

    override fun set(index: Int, item: T) {
        checkValidRange(index)
        internalArray.set(index, item)
    }
}

fun <T> fixedArrayOf(size: Int, initializer: (index: Int) -> T): FixedArray<T> =
    FixedArray.of(size, initializer)

fun <T> fixedArrayOf(vararg items: T) = FixedArray.of(items.size, items::get)
