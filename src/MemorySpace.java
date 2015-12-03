/**
 * Author:      7121
 * Date:        12/1/15
 * Class:       Operating Systems
 * Purpose:     MemorySpace class for Stack-Based Least Recently Used algorithm.
 *              Suppose each page store just an integer
 */

public class MemorySpace{

    //Create Node, head, capacity and size variables
    private final Node[] pages = new Node[100000];
    private final Node head = new Node(-1);
    private final int capacity;
    private int size;

    /**
     * capacity indicates the maximum number of pages in the physical memory space
     *
     * @param capacity suppose it is always positive
     */
    //Constructor
    public MemorySpace(int capacity) {

        this.capacity = capacity;
        head.next = head.previous = head;

    }

    /**
     * Finds the content in a page given the number.
     *
     * Returns -1 if the page is not in the physical memory.
     *
     * The time complexity is O(1)
     *
     * @param page
     * @return
     */
    public int read(int page) {

        //Complexity of O(1)
        Node node = pages[page];

        if (node == null) {

            return -1;                  //No content on node

        }
        else {

            return node.content;        //node has content

        }

    }

    /**
     * Sets the content for a page given its page number. If the page is in the physical memory,
     * overwrite its current content. Otherwise, add a new page in the physical memory. If the capacity
     * was already reached, remove the one that was last referenced in the farthest past.
     *
     * The time complexity is O(1).
     *
     * @param page
     * @param content
     */
    public void update(int page, int content) {

        //Complexity of O(1)
        Node node = pages[page];

        if (node == null) {

            node = pages[page] = new Node(page);        //Create new page
            size++;

        }
        else {

            node.next.previous = node.previous;         //Remove existing page
            node.previous.next = node.next;

        }

        Node last = head.previous;          //Add node to head of list
        last.next = node;
        node.previous = last;
        head.previous = node;
        node.next = head;
        node.content = content;


        if (size >= capacity) {                         //If capacity was reached

            Node first = head.next;                     //Remove first page
            first.next.previous = first.previous;
            first.previous.next = first.next;
            pages[first.page] = null;
            size--;

        }

    }

    //Linked List Node class that, last node is null
    private static final class Node {

        private final int page;
        private int content;
        private Node previous;
        private Node next;

        //Constructor
        public Node(int page) {

            this.page = page;

        }

    }

}

