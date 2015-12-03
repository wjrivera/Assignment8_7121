/**
 * Author:      7121
 * Date:        12/1/15
 * Class:       Operating Systems
 * Purpose:     PageReplacementLongTest class for Stack-Based Least Recently Used algorithm.
 *              This program should complete in less than 100 milliseconds (0.5 seconds)
 */

import java.util.Random;

public class PageReplacementLongTest{

    public static final int CAPACITY=100000;

    public static void main(String args[]){

        long before = System.currentTimeMillis();
        test(new MemorySpace(CAPACITY));
        long after = System.currentTimeMillis();
        System.out.printf("Test completed in %d milliseconds", after-before);

    }

    private static void test(MemorySpace stack){

        Random rand = new Random();

        for(int i=0;i<CAPACITY/2;i++){

            stack.update(i, i);

        }

        for(int i=0;i<CAPACITY;i++){

            int randNum = rand.nextInt(CAPACITY);

            if(i%2==0){

                stack.update(randNum, randNum);

            }
            else{

                stack.read(randNum);

            }

        }

    }

}