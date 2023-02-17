package com.github.ch8n.dynamicArray

/***
 * Fixed array doesn't have ability to add or remove elements
 * it can only set and get data from array
 */
interface DynamicArrayOperations<T> : Iterable<T> {

    /**
     * Returns the element at the given index in the array.
     */
    fun get(index: Int): T

    /**
     * Sets the element at the given index to the given value.
     */
    fun set(index: Int, item: T)

    /**
     * Adds the given value to the end of the array. If the underlying array is full, a new, larger array is created and the existing elements are copied into it.
     */
    fun add(item: T)

    /**
     * Inserts the given value at the given index in the array, shifting all subsequent elements to the right. If the underlying array is full, a new, larger array is created and the existing elements are copied into it.
     */
    fun insert(index: Int, value: T)

    /**
     * Removes the element at the given index from the array, shifting all subsequent elements to the left. If the number of elements in the array is less than half the size of the underlying array, a new, smaller array is created and the existing elements are copied into it.
     */
    fun remove(index: Int): T

    /**
     * Returns the number of elements in the array.
     */
    val size: Int

    /**
     * Returns true if the array is empty, false otherwise.
     */
    fun isEmpty(): Boolean

}

class DynamicArray<T> constructor(initialCapacity: Int) : DynamicArrayOperations<T> {

    private var _array = arrayOfNulls<Any>(initialCapacity)

    private fun checkArrayLimitReached(): Boolean {
        val numberOfItems = size
        val currentArraySize = _array.size
        val isExpandRequired = numberOfItems == currentArraySize
        return isExpandRequired
    }

    private fun checkArrayUnncessayMemory(): Boolean {
        val numberOfItems = size
        val currentArraySize = _array.size
        val isShrinkRequired = numberOfItems <= currentArraySize / 2
        return isShrinkRequired
    }

    private fun checkIndexBounds(index: Int) {
        val lastIndex = size - 1
        val isValidRange = index in 0..lastIndex
        if (!isValidRange) {
            throw IndexOutOfBoundsException("Invalid index range!")
        }
    }

    private fun expandedArray(expandFactor: Int = 2): Array<Any?> {
        val currentArray = _array
        val currentSize = 1.coerceAtLeast(currentArray.size)
        val expandedSize = currentSize * expandFactor
        val expandedArray = arrayOfNulls<Any>(expandedSize)
        for (index in currentArray.indices) {
            expandedArray.set(index, currentArray.get(index))
        }
        return expandedArray
    }

    private fun shrunkArray(shrinkFactor: Int = 2): Array<Any?> {
        val currentArray = _array
        val currentSize = currentArray.size
        val shrinkSize = currentSize / shrinkFactor
        val shrinkArray = arrayOfNulls<Any>(shrinkSize)
        for (index in currentArray.indices) {
            shrinkArray.set(index, currentArray.get(index))
        }
        return shrinkArray
    }

    @Suppress("UNCHECKED_CAST")
    override fun get(index: Int): T {
        checkIndexBounds(index)
        val targetItem = _array.get(index) ?: throw NullPointerException("Item null at index $index")
        return targetItem as T
    }

    override val size: Int
        get() {
            var count = 0
            for (index in _array.indices) {
                _array.get(index) ?: return count
                count++
            }
            return count
        }

    override fun isEmpty(): Boolean = size == 0

    override fun insert(index: Int, value: T) {
        TODO("Not yet implemented")
    }

    override fun remove(index: Int): T {
        TODO("Not yet implemented")
    }


    override fun add(item: T) {
        val isLimitReached = checkArrayLimitReached()
        if (isLimitReached) {
            val expandedArray = expandedArray()
            _array = expandedArray
        }
        val lastIndex = if (isEmpty()) 0 else size - 1
        _array.set(lastIndex, item)
    }

    override fun set(index: Int, item: T) {
        checkIndexBounds(index)
        _array.set(index, item)
    }

    override fun iterator(): Iterator<T> {
        return GenericIterator(size, ::get)
    }

}
