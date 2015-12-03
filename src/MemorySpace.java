/**
 * Author:      7121
 * Date:        12/1/15
 * Class:       Operating Systems
 * Purpose:     MemorySpace class for Stack-Based Least Recently Used algorithm.
 *              Suppose each page store just an integer
 */

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


public class MemorySpace {

    // feel free to declare any variables

    Queue<Object> queue;
    int CAPACITY;

    Map<Integer, Integer> linkedHashMap;


    /**
     * capacity indicates the maximum number of pages in the physical memory space
     *
     * @param capacity suppose it is always positive
     */
    public MemorySpace(int capacity) {

        // add your code
        CAPACITY=capacity;
        linkedHashMap= new LinkedHashMap<Integer, Integer>(capacity);
        queue=new LinkedList<Object>();
        queue.add("HI");

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

        // add your code
        if(linkedHashMap.containsKey(page)){
            return linkedHashMap.get(page);
        }else{
            return -1;
        }
        //return 0;

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

        // add your code

        if(linkedHashMap.containsKey(page)){
            linkedHashMap.replace(page, content);
        }else{
            if(linkedHashMap.size()==CAPACITY){
                linkedHashMap.get(linkedHashMap.size()-1);


            }else{
                linkedHashMap.put(page, content);
            }

        }

    }

}

