package itAcademy.task2;

import itAcademy.threads.PrimeFinderWithGlobalCollection;
import itAcademy.threads.StartingThreads;

import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public  class StartThreadsWithExecutors extends StartingThreads {
    public StartThreadsWithExecutors(Set<Integer> globalCollection) {
        primeNumbers = globalCollection;
    }

    @Override
    public void executeAllThreads() {
        ExecutorService executor = Executors.newFixedThreadPool(countThreads);
        for(int i=0;i<countThreads;i++){
            executor.execute(new PrimeFinderWithGlobalCollection(counter,end,primeNumbers));
        }
        executor.shutdown();
    }
}
