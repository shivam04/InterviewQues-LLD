package rate.limit.algorithms.tokenbucket;

public class SendPacketThread extends Thread {
    private TokenBucket bucket;

    public SendPacketThread(TokenBucket bucket) {
        this.bucket = bucket;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(500 + (int) (Math.random()*3000));
            } catch (Exception ex) {}
            bucket.sendPacket(1 + (int) (Math.random()*9));
        }
    }
}
