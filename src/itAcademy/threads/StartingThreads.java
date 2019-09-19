package itAcademy.threads;

import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class StartingThreads {
    protected Set<Integer> primeNumbers;
    protected int countThreads;
    protected int start;
    protected int end;
    protected AtomicInteger counter;

    public void getInputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Count of thread = ");
        countThreads = scanner.nextInt();
        System.out.println("Interval ");
        start = scanner.nextInt();
        end = scanner.nextInt();
        counter = new AtomicInteger(start);
    }

    public abstract void executeAllThreads();

    public Set<Integer> getPrimeNumbers() {
        return primeNumbers;
    }

}
