package itAcademy.task1withoutconcurrency;

public class Partition {
    private int start;
    private int end;
    private int countOfThreads;

    public Partition(int start, int end, int countOfThreads) {
        this.start = start;
        this.end = end;
        this.countOfThreads = countOfThreads;
    }

    public int[] getendOfSplitInervals() {
        int[] endOfIntervals = new int[countOfThreads];
        int partitionEl;
        int counterOfParts = countOfThreads;
        int startOfInterval = start;
        for (int i = 0; i < countOfThreads; i++) {
            int a = counterOfParts;
            int b = counterOfParts;
            long c = -(end * end + end + (counterOfParts - 1) * (startOfInterval * startOfInterval - startOfInterval));
            partitionEl = endOfIntervals[i] = quadraticEquationSolver(a, b, c);
            endOfIntervals[i] = partitionEl;
            startOfInterval = partitionEl;
            counterOfParts--;
        }
        return endOfIntervals;
    }

    public int quadraticEquationSolver(long a, long b, long c) {
        long d = b * b - 4 * a * c;
        d = (long) Math.sqrt(d);
        long x = -b + d;
        x /= 2 * a;
        return (int) x;
    }
}
