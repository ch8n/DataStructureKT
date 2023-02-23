<h1>DataStructure-KT</h1>
<p>DataStructure-KT is an open-source project that provides a set of common data structures implemented in Kotlin.</p>

<h2>Table of Contents</h2>
<ul>
	<li><a href="#features">Features</a></li>
	<li><a href="#installation">Installation</a></li>
	<li><a href="#usage">Usage</a></li>
	<li><a href="#contributing">Contributing</a></li>
	<li><a href="#license">License</a></li>
</ul>

<h2>Features</h2>
<p>DataStructure-KT provides the following data structures:</p>
<ul>
	<li>Stack</li>
	<li>Queue</li>
	<li>Singly Linked List</li>
	<li>Doubly Linked List</li>
	<li>Binary Search Tree</li>
</ul>

<h2>Installation</h2>
<p>DataStructure-KT is available on Maven Central. To use it in your project, add the following dependency to your build file:</p>
<pre>
<code>implementation 'com.github.ch8n.DataStructureKT:linked-list-kt:Version' </code>
</pre>
<h2>Usage</h2>
<h3>Stack</h3>
<pre>
<code>val stack = Stack<Int>()
stack.push(1)
stack.push(2)
stack.push(3)
println(stack.pop()) // Output: 3</code>
</pre>

<h3>Queue</h3>
<pre>
<code>val queue = Queue<Int>()
queue.enqueue(1)
queue.enqueue(2)
queue.enqueue(3)
println(queue.dequeue()) // Output: 1</code>
</pre>

<h3>Singly Linked List</h3>
<pre>
<code>val linkedList = SinglyLinkedList<Int>()
linkedList.addFirst(1)
linkedList.addLast(2)
linkedList.addLast(3)
println(linkedList.first()) // Output: 1</code>
</pre>

<h3>Doubly Linked List</h3>
<pre>
<code>val linkedList = DoublyLinkedList<Int>()
linkedList.addFirst(1)
linkedList.addLast(2)
linkedList.addLast(3)
println(linkedList.last()) // Output: 3</code>
</pre>

<h3>Binary Search Tree</h3>
<pre>
<code>val bst = BinarySearchTree<Int>()
bst.insert(5)
bst.insert(3)
bst.insert(7)
bst.insert(1)
bst.insert(4)
bst.insert(6)
bst.insert(8)
println(bst.contains(3)) // Output: true</code>
</pre>

<p>For more usage examples, check out the <a href="src/test/kotlin/io/github/chatgpt/datastructure">tests</a> directory.</p>

<h2>Contributing</h2>
<p>Contributions are welcome! If you find a bug or have a feature request, please open an issue. If you want to contribute code, please open a pull request.</p>

<h2>License</h2>
<p>DataStructure-KT is released under the <a href="LICENSE">
