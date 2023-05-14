package rate.limit.algorithms.fixedwindowalgo;

public class FixedWindowBucketDriver {
    public static void main(String[] args) {
        FixedWindowBucket fixedWindowBucket = new FixedWindowBucket(10);
        Thread resetTokenThread = new Thread(new ResetTokenThread(fixedWindowBucket));
        Thread processRequestThread = new Thread(new ProcessRequestThread(fixedWindowBucket));
        resetTokenThread.start();
        processRequestThread.start();
    }
}
