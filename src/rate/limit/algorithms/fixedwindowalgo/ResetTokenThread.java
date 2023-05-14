package rate.limit.algorithms.fixedwindowalgo;

public class ResetTokenThread implements Runnable{
    private FixedWindowBucket fixedWindowBucket;

    public ResetTokenThread(FixedWindowBucket fixedWindowBucket) {
        this.fixedWindowBucket = fixedWindowBucket;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            fixedWindowBucket.resetTokens();
        }
    }
}
