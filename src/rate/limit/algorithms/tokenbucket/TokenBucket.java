package rate.limit.algorithms.tokenbucket;

public class TokenBucket {
    private int tokens;
    private int bucketSize;

    public TokenBucket(int bucketSize) {
        this.tokens = 0;
        this.bucketSize = bucketSize;
    }

    public synchronized void addToken() {
        if (tokens >= bucketSize) {
            return;
        }
        tokens += 1;
        System.out.println("Added a token. Total:" + tokens);
    }

    public synchronized void sendPacket(int n) {
        System.out.println("Packet of size " + n + " arrived");
        if (n > tokens) {
            System.out.println("Packet is non comformant, discarded");
        } else {
            tokens -= n;
            System.out.println("Forwarding packet");
        }
    }
}
