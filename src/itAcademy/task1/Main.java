package itAcademy.task1;

import itAcademy.threads.StartingThreads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) {
        double startTime;
        double timeSpent;
        Set<Integer> set = ConcurrentHashMap.newKeySet();
        StartingThreads startingThread = new StartingOneCollection(set);
        startingThread.getInputData();

        startTime = System.currentTimeMillis();

        startingThread.executeAllThreads();
        timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("Time " + timeSpent);

        StartingThreads startingThread2 = new StartingCollectionPerThread();
        startingThread2.getInputData();
        startTime = System.currentTimeMillis();
        startingThread2.executeAllThreads();
        timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("Time " + timeSpent);

        System.out.println("First");
        ArrayList<Integer> f = new ArrayList<>(set);
        Collections.sort(f);
        System.out.println(f);

        System.out.println("Second");
        ArrayList<Integer> f2 = new ArrayList<>(startingThread2.getPrimeNumbers());
        Collections.sort(f);
        System.out.println(f);
    }
}
