import com.github.ch8n.linkedlist.LinkedList
import com.github.ch8n.recursion.recursion

fun main(args: Array<String>) {
    val linked = LinkedList()
    linked.test()

    recursion { head { repeat(3) { println(it) } } }
}