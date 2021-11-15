package itAcademy.task2;

import itAcademy.threads.StartingThreads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Main2 {
    public static void main(String[] args) {
      
        Set<Integer> globalCollection = ConcurrentHashMap.newKeySet();
        StartingThreads startingThread = new StartThreadsWithExecutors(globalCollection);
       startAndCountTime(new StartThreadsWithExecutors(globalCollection));
       StartingThreads startingThread2 =  new StartExecutorsCollectionPerThread();
        startAndCountTime(startingThread2);

printResultCollections(globalCollection);
printResultCollections(startingThread2.getPrimeNumbers());
    }
    public static void startAndCountTime(StartingThreads startingThreads){
        double startTime;
        double timeSpent;
        StartingThreads startingThread = startingThreads;
        startingThread.getInputData();

        startTime = System.currentTimeMillis();

        startingThread.executeAllThreads();
        timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("Time "+timeSpent);
    }

    public static void printResultCollections(Collection<Integer> collection){
        ArrayList<Integer> resultCollection = new ArrayList<>(collection);
        Collections.sort(resultCollection);
        System.out.println(resultCollection);
    }
}
