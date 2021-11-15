package itAcademy.threads;

import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class PrimeFinderWithGlobalCollection implements Runnable {
    private int end;
    private AtomicInteger currentNumberToCheck;
    Set<Integer> set;

    public PrimeFinderWithGlobalCollection(AtomicInteger currentNumberToCheck, int end, Set set) {
        this.end = end;
        this.set = set;
        this.currentNumberToCheck = currentNumberToCheck;
    }

    @Override
    public void run() {
        while (true) {
            int number = currentNumberToCheck.getAndIncrement();
            if (number > end) break;
            if (isPrime(number))
                set.add(number);
        }

    }


    boolean isPrime(int number) {
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }
}