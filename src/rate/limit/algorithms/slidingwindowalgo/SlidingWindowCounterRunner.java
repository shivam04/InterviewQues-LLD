package rate.limit.algorithms.slidingwindowalgo;

public class SlidingWindowCounterRunner {
    public static void main(String[] args) {
        SlidingWindowCounter slidingWindowCounter = new SlidingWindowCounter(5);
        Thread sendRequestSWCounterThread = new Thread(new SendRequestSWCounterThread(slidingWindowCounter));
        sendRequestSWCounterThread.start();
    }
}
