package rate.limit.algorithms.slidingwindowalgo;

import java.util.Date;

public class SendRequestSWCounterThread implements Runnable{
    private SlidingWindowCounter slidingWindowCounter;

    public SendRequestSWCounterThread(SlidingWindowCounter slidingWindowCounter) {
        this.slidingWindowCounter = slidingWindowCounter;
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
            int p = (int) (1 + Math.random()*4);
            System.out.println("Trying with " + p + " requests");
            for (int i=0; i<p; i++) {
                System.out.println("Is Allowed? " + slidingWindowCounter.allow());
            }
            try {
                long waitTime = (long)(Math.random()*55000.0 + 5000.0);
                System.out.println("Next Request Time: " + new Date(System.currentTimeMillis() + waitTime));
                System.out.println("===========================");
                System.out.println("===========================");
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
