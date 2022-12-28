package rate.limit.algorithms.leakingbucket;

public class ProcessRequestThread extends Thread{
    private LeakyTokenBucket leakyTokenBucket;

    public ProcessRequestThread(LeakyTokenBucket leakyTokenBucket) {
        this.leakyTokenBucket = leakyTokenBucket;
    }

    public void run() {
        while (true) {
            leakyTokenBucket.processRequest();
            try {
                Thread.sleep(60000);
            } catch (Exception ex) {}
        }
    }
}
