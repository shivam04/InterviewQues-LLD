package rate.limit.algorithms.fixedwindowalgo;

public class ProcessRequestThread implements Runnable{
    private FixedWindowBucket fixedWindowBucket;

    public ProcessRequestThread(FixedWindowBucket fixedWindowBucket) {
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
                fixedWindowBucket.processRequest((int) (1 + Math.random() * 9));
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
