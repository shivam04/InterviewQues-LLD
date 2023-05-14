package rate.limit.algorithms.fixedwindowalgo;

public class FixedWindowBucket {
    private int tokens;
    private int bucketSize;

    public FixedWindowBucket(int bucketSize) {
        this.tokens = 0;
        this.bucketSize = bucketSize;
    }

    public synchronized void resetTokens() {
        System.out.println("Resetting tokens");
        this.tokens = 0;
    }

    public synchronized void processRequest(int n) {
        System.out.println("Packet of size " + n + " arrived");
        if (tokens + n > bucketSize) {
            System.out.println("Packet is non comformant, discarded");
        } else {
            tokens += n;
            System.out.println("Processing " + n + " requests");
        }
    }
}
