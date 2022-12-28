package rate.limit.algorithms.leakingbucket;

public class LeakyTokenBucketDriver {
    public static void main(String[] args) {
        LeakyTokenBucket leakyTokenBucket = new LeakyTokenBucket(5, 10);
        Thread getRequestThread = new GetRequestThread(leakyTokenBucket);
        Thread processRequestThread = new ProcessRequestThread(leakyTokenBucket);
        getRequestThread.start();
        processRequestThread.start();
    }
}
