package itAcademy.task1;

import itAcademy.threads.PrimeFinderWithOwnCollection;
import itAcademy.threads.StartingThreads;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.FutureTask;


public class StartingCollectionPerThread extends StartingThreads {

    public StartingCollectionPerThread() {
        this.primeNumbers = new HashSet<>();
    }

    @Override
    public void executeAllThreads() {
        Thread threads[] = new Thread[countThreads];
        FutureTask<LinkedList<Integer>>[] futureTasks = new FutureTask[countThreads];
        for (int i = 0; i < countThreads; i++) {
            futureTasks[i] = new FutureTask<>(new PrimeFinderWithOwnCollection(counter, end));
            threads[i] = new Thread(futureTasks[i]);
            threads[i].start();
        }

        try {
            for (int i = 0; i < countThreads; i++) {
                threads[i].join();
                addToCollection(futureTasks[i].get());
            }
        } catch (InterruptedException e) {

        } catch (Exception e) {

        }


    }

    private void addToCollection(List<Integer> addedpart) {
        primeNumbers.addAll(addedpart);
    }
}
