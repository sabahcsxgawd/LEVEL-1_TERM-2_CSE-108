//Complete the following Java code that finds the total number of square numbers from a 100000 random integers array using an array of 20 threads in parallel.
// You cannot write any more classes.

import java.util.Random;

class ParallelSquareCounter implements Runnable {
    private int[] numbers;
    private int startIndex;
    private static final int NUMBER_COUNT = 5000;
    private int squareCount;
	// you are not allowed to add any more fields
	
	// you are not allowed to change this constructor, and you are not allowed to add any more constructor
    ParallelSquareCounter(int[] numbers, int startIndex) {
        this.numbers = numbers;
        this.startIndex = startIndex;
        this.squareCount = 0;
    }

	// your code here

    public int isSquare(int n) {
        if(n < 0) {
            return 0;
        }
        if(n == 0) {
            return 1;
        }
        int low = 1, high = n;
        int mid;
        for(int i = 0;i < 50;i++) {
            mid = low + (high - low)/2;
            if((long)mid * mid == n) { return 1; }
            else if((long)mid * mid < n) {
                low = mid;
            }
            else {
                high = mid;
            }
        }
        return 0;
    }

    @Override
    public void run() {
        for(int i = this.startIndex;i < this.startIndex+this.NUMBER_COUNT;i++) {
            this.squareCount += isSquare(this.numbers[i]);
        }
    }

    public int getSquareCount() {
        return this.squareCount;
    }
}

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        final int NUMBER_COUNT = 100000;
        final int THREAD_COUNT = 20;
        int[] numbers = new int[NUMBER_COUNT];
        for (int i = 0; i < numbers.length; i++) {
            //numbers[i] = random.nextInt();
            numbers[i] = i+1;
        }
        ParallelSquareCounter[] parallelSquareCounters = new ParallelSquareCounter[THREAD_COUNT];
        Thread[] threads = new Thread[THREAD_COUNT];

		// your code here

        for(int i = 0;i < THREAD_COUNT;i++) {
            parallelSquareCounters[i] = new ParallelSquareCounter(numbers,i*NUMBER_COUNT/THREAD_COUNT);
            threads[i] = new Thread(parallelSquareCounters[i]);
            threads[i].start();
        }
        for(int i = 0;i < THREAD_COUNT;i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        int totalSquareCount = 0;
        for(int i = 0;i < THREAD_COUNT;i++) {
            totalSquareCount += parallelSquareCounters[i].getSquareCount();
        }
        System.out.println(totalSquareCount);
    }
}