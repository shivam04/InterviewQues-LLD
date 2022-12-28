package rate.limit.algorithms.tokenbucket;

public class AddTokenThread extends Thread {
    private TokenBucket bucket;

    public AddTokenThread(TokenBucket bucket) {
        this.bucket = bucket;
    }

    public void run() {
        while (true) {
            bucket.addToken();
            try {
                Thread.sleep(300);
            } catch (Exception ex) {}
        }
    }
}
