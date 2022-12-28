package rate.limit.algorithms.leakingbucket;

public class LeakyTokenBucket {
    private int outFlowRate;
    private int bucketSize;
    private int currentCounter;

    public LeakyTokenBucket(int outFlowRate, int bucketSize) {
        this.outFlowRate = outFlowRate;
        this.bucketSize = bucketSize;
        this.currentCounter = 0;
    }

    public synchronized void addRequest(int n) {
        System.out.println("Get " + n + " Requests");
        if (currentCounter + n > bucketSize) {
            System.out.println("Packet is non comformant, discarded");
            return;
        }
        System.out.println("Added " + n + " Requests in the Queue");
        currentCounter += n;
    }

    public void processRequest() {
        if (currentCounter == 0) {
            return;
        }

        int currentProcessReq = Math.min(outFlowRate, currentCounter);
        System.out.println("Processed " + currentProcessReq + " Requests from the Queue");
        currentCounter -= currentProcessReq;
    }
}
