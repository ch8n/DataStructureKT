import com.github.ch8n.linkedlist.LinkedList
import com.github.ch8n.recursion.recursion

fun main(args: Array<String>) {
    // 6699 is recursive call limit for my device
    recursion {
        head {
            repeat(5) { step ->
                println("head repeat...$step")
            }
        }

        head {
            listOf(1, 2, 3, 4, 5).onEach { item ->
                println("head onEach...$item")
            }
        }

        head {
            listOf(1, 2, 3, 4, 5).onReversed { item ->
                println("head onReversed...$item")
            }
        }

    }

    recursion {
        tail {
            repeat(5) { step ->
                println("tail repeat...$step")
            }
        }

        tail {
            listOf(1, 2, 3, 4, 5).onEach { item ->
                println("tail onEach...$item")
            }
        }

        tail {
            listOf(1, 2, 3, 4, 5).onReversed { item ->
                println("tail onReversed...$item")
            }
        }

        val fibonacciSeries = tail {
            fibonacci(
                first = 0,
                second = 1,
                target = 5,
                inclusive = true
            )
        }
        println(fibonacciSeries)
    }


}