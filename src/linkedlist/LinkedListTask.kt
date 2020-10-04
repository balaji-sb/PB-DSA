package linkedlist

class LinkedListTask {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val firstLinkedList = LinkedListTask()
            firstLinkedList.insertToLinkedList("A")
            firstLinkedList.insertToLinkedList("B")
            firstLinkedList.insertToLinkedList("C")
            firstLinkedList.insertToLinkedList("D")
            firstLinkedList.insertToLinkedList("E")
            firstLinkedList.insertToLinkedList("F")
            //println("FirstLinkedListSize ${firstLinkedList.size}")
            val secondLinkedList = LinkedListTask()
            secondLinkedList.insertToLinkedList("X")
            secondLinkedList.insertToLinkedList("Y")
            //println("SecondLinkedListSize ${secondLinkedList.size}")
            val joiningNode = findJoiningNode(secondLinkedList,firstLinkedList)
            println("Joining Node is $joiningNode")
        }

        class Node(val data: String) {
            var next: Node? = null
        }

        @JvmStatic
        fun findJoiningNode(firstList: LinkedListTask, secondList: LinkedListTask): String? {
            var counter = if (firstList.size > secondList.size) secondList.size else firstList.size
            val head = if (firstList.size > secondList.size) firstList.head else secondList.head
            if (counter > 0) {
                var firstCurrent = head
                while (firstCurrent?.next != null && counter > 0) {
                    firstCurrent = firstCurrent.next
                    if (counter > 0) counter--
                }
                return firstCurrent?.data
            }
            return null
        }

    }

    var size: Int = 0
    var head: Node? = null
    var tail: Node? = null

    fun insertToLinkedList(node: String) {
        val newNode = Node(node)
        // To check if linkedlist is empty
        if (head == null || tail == null) {
            tail = newNode
            head = tail
            size++
            return
        }

        // Add the last position to linkedlist
        var currentNode = head
        while (currentNode?.next != null) {
            currentNode = currentNode.next
        }

        currentNode?.next = newNode
        size++
    }


}