package itAcademy.task1withoutconcurrency;

import java.util.Set;

public class PrimeFinderThread implements Runnable {
    private int start;
    private int end;
    private Set<Integer> globalCollection;
    int counter;

    public PrimeFinderThread(int start, int end, Set<Integer> globalCollection) {
        this.start = start;
        this.end = end;
        this.globalCollection = globalCollection;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            if (isPrime(i))
                globalCollection.add(i);
        }
    }

    boolean isPrime(int number) {
        for (int i = 2; i <= number / 2; i++) {
            counter++;
            if (number % i == 0)
                return false;
        }
        return true;
    }
}
