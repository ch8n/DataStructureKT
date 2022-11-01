package com.github.ch8n.recursion

inline fun Int.ifZero(action: () -> Unit) {
    if (this == 0) {
        action.invoke()
    }
}