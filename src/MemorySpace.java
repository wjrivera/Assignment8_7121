/**
 * Created by WilliamJ on 12/2/2015.
 */
// suppose each page stores just an integer
public class MemorySpace {

    // feel free to declare any variables

    /**
     * capacity indicates the maximum number of pages in the physical memory space
     *
     * @param capacity suppose it is always positive
     */
    public MemorySpace(int capacity) {
        // add your code
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
        return 0;
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
    }
}

