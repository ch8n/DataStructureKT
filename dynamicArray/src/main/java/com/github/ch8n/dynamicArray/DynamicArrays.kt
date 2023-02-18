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
    fun insert(targetIndex: Int, item: T)

    /**
     * Removes the element at the given index from the array, shifting all subsequent elements to the left. If the number of elements in the array is less than half the size of the underlying array, a new, smaller array is created and the existing elements are copied into it.
     */
    fun remove(targetIndex: Int): T

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

    private fun isArrayLimitReached(itemsInArray: Int, totalSizeOfArray: Int): Boolean {
        return itemsInArray == totalSizeOfArray
    }

    private fun isSurplusMemoryInArray(itemsInArray: Int, totalSizeOfArray: Int): Boolean {
        return itemsInArray <= totalSizeOfArray / 2
    }

    private fun checkIndexBounds(index: Int) {
        val isValidRange = index in 0.._numberOfElements
        if (!isValidRange) {
            throw IndexOutOfBoundsException("Invalid index range!")
        }
    }

    private fun getExpandedArray(expandFactor: Int = 2): Array<Any?> {
        val currentArray = _array
        val currentSize = 1.coerceAtLeast(currentArray.size)
        val expandedSize = currentSize * expandFactor
        val expandedArray = arrayOfNulls<Any>(expandedSize)
        for (index in currentArray.indices) {
            expandedArray.set(index, currentArray.get(index))
        }
        return expandedArray
    }

    private fun getShrunkArray(shrinkFactor: Int = 2): Array<Any?> {
        val currentArray = _array
        val currentSize = currentArray.size
        val shrinkSize = currentSize / shrinkFactor
        val shrinkArray = arrayOfNulls<Any>(shrinkSize)
        val lastIndex = _numberOfElements - 1
        for (index in 0..lastIndex) {
            shrinkArray.set(index, currentArray.get(index))
        }
        return shrinkArray
    }

    @Suppress("UNCHECKED_CAST")
    override fun get(index: Int): T {
        checkIndexBounds(index)
        return (_array.get(index) as? T) ?: throw NullPointerException("Item null at index $index")
    }

    override fun set(index: Int, item: T) {
        checkIndexBounds(index)
        _array.set(index, item)
    }

    private val _numberOfElements: Int
        get() {
            var count = 0
            for (index in _array.indices) {
                _array.get(index) ?: return count
                count++
            }
            return count
        }
    override val size: Int get() = _numberOfElements

    override fun isEmpty(): Boolean = size == 0

    override fun insert(targetIndex: Int, item: T) {
        checkIndexBounds(targetIndex)

        if (isEmpty()) {
            add(item)
            return
        }

        val isExpandRequired = isArrayLimitReached(_numberOfElements + 1, _array.size)
        if (isExpandRequired) {
            val expandedArray = getExpandedArray()
            _array = expandedArray
        }

        val lastIndex = _numberOfElements - 1
        for (index in lastIndex downTo targetIndex) {
            _array.set(index + 1, get(index))
        }

        _array.set(targetIndex, item)
    }

    @Suppress("UNCHECKED_CAST")
    override fun remove(targetIndex: Int): T {
        checkIndexBounds(targetIndex)
        if (isEmpty()) throw IndexOutOfBoundsException("empty array!")

        val targetItem = _array.get(targetIndex)
        val lastIndex = _numberOfElements - 1
        val secondLastIndex = lastIndex - 1
        for (index in targetIndex..secondLastIndex) {
            val nextItem = get(index + 1)
            _array.set(index, nextItem)
        }

        _array.set(lastIndex, null)

        val isShrinkRequired = isSurplusMemoryInArray(_numberOfElements, _array.size)
        if (isShrinkRequired) {
            _array = getShrunkArray()
        }
        return targetItem as T
    }


    override fun add(item: T) {
        val isLimitReached = isArrayLimitReached(_numberOfElements, _array.size)
        if (isLimitReached) {
            val expandedArray = getExpandedArray()
            _array = expandedArray
        }
        _array.set(_numberOfElements, item)
    }


    override fun iterator(): Iterator<T> {
        return GenericIterator(size, ::get)
    }

}
