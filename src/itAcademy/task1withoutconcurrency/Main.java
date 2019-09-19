package itAcademy.task1withoutconcurrency;


public class Main {
    public static void main(String[] args) throws Exception {
        StartingThreads startingThreads = new StartingThreads();
        startingThreads.getInputData();
        long startTime = System.currentTimeMillis();
        startingThreads.executeThreads();
        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println(timeSpent);
        System.out.println(startingThreads.getGlobalCollection());
    }

}
