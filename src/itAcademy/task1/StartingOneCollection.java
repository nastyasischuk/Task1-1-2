package itAcademy.task1;

import itAcademy.threads.PrimeFinderWithGlobalCollection;
import itAcademy.threads.StartingThreads;

import java.util.Set;

public class StartingOneCollection extends StartingThreads {
    private Set<Integer> globalCollection;

    public StartingOneCollection(Set<Integer> globalCollection) {
        this.globalCollection = globalCollection;
    }

    @Override
    public void executeAllThreads() {
        Thread[] threads = new Thread[countThreads];
        for (int i = 0; i < countThreads; i++) {
            threads[i] = new Thread(new PrimeFinderWithGlobalCollection(counter, end, globalCollection));
            threads[i].start();
        }

        try {
            for (Thread thread : threads)
                thread.join();
        } catch (InterruptedException e) {

        }
    }
}
