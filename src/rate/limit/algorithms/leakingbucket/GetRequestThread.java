package rate.limit.algorithms.leakingbucket;

public class GetRequestThread extends Thread{
    private LeakyTokenBucket leakyTokenBucket;

    public GetRequestThread(LeakyTokenBucket leakyTokenBucket) {
        this.leakyTokenBucket = leakyTokenBucket;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(20000);
            } catch (Exception ex) {}
            leakyTokenBucket.addRequest(1 + (int)(Math.random()*9));
        }
    }
}
