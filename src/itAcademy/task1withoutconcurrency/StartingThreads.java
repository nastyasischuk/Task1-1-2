package itAcademy.task1withoutconcurrency;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StartingThreads {
    private int countThreads;
    private int start;
    private int end;
    private Set<Integer> globalCollection;

    public StartingThreads(){
        globalCollection = Collections.synchronizedSet(new HashSet<>());
    }

    public void getInputData(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Count of thread = ");
        countThreads = scanner.nextInt();
        System.out.println("Interval ");
        start = scanner.nextInt();
        end = scanner.nextInt();
    }
    public void executeThreads(){
        Partition partition = new Partition(start,end,countThreads);
        int[] endOfIntervals = partition.getendOfSplitInervals();
        Thread[] threads = new Thread[countThreads];
        int startOfInterval = start;
        for(int i=0;i<countThreads;i++) {
            threads[i] = new Thread(new PrimeFinderThread(startOfInterval,endOfIntervals[i],globalCollection));
            threads[i].start();
            startOfInterval = endOfIntervals[i] + 1;
        }

        try {
            for(Thread thread:threads)
                thread.join();
        }catch (InterruptedException e){

        }
    }

    public Set<Integer> getGlobalCollection() {
        return globalCollection;
    }
}
