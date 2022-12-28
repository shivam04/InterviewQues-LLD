package rate.limit.algorithms.tokenbucket;

public class TokenBucketDriver {
    public static void main(String[] args) {
        TokenBucket tokenBucket = new TokenBucket(10);
        Thread addTokenThread = new AddTokenThread(tokenBucket);
        Thread sendPacketThread = new SendPacketThread(tokenBucket);
        addTokenThread.start();
        sendPacketThread.start();
    }
}
