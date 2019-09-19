package itAcademy.task2;

import itAcademy.threads.PrimeFinderWithOwnCollection;
import itAcademy.threads.StartingThreads;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class StartExecutorsCollectionPerThread extends StartingThreads {
    public StartExecutorsCollectionPerThread() {
        this.primeNumbers = new HashSet<>();
    }

    @Override
    public void executeAllThreads() {
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Future<Integer>> executedThreads= new ArrayList<>();
        try {
            for (int i = 0; i < countThreads; i++) {
                Future<LinkedList<Integer>> result = executor.submit(new PrimeFinderWithOwnCollection(new AtomicInteger(start), end));
                addToCollection(result.get());
            }
        }catch (Exception e){

        }

    }
    private void addToCollection(List<Integer> addedpart){
        primeNumbers.addAll(addedpart);
    }
}
