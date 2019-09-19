package itAcademy.threads;

import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class PrimeFinderWithOwnCollection implements Callable<LinkedList<Integer>> {

    int end;
    private AtomicInteger currentNumberToCheck;

    public PrimeFinderWithOwnCollection(AtomicInteger currentNumberToCheck, int end) {
        this.currentNumberToCheck = currentNumberToCheck;
        this.end = end;
    }

    @Override
    public LinkedList<Integer> call() throws Exception {
        LinkedList<Integer> partOfPRimes = new LinkedList<>();
        while (true) {

            int number = currentNumberToCheck.getAndIncrement();

            if (number > end) {
                break;
            }
            if (isPrime(number))
                partOfPRimes.add(number);
        }
        return partOfPRimes;
    }

    boolean isPrime(int number) {
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }
}
