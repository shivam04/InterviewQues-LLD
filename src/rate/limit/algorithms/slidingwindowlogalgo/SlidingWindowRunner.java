package rate.limit.algorithms.slidingwindowlogalgo;

public class SlidingWindowRunner {
    public static void main(String[] args) {
        SlidingWindow slidingWindow = new SlidingWindow(5);
        Thread sendRequestThread = new Thread(new SendRequestThread(slidingWindow));
        sendRequestThread.start();
    }
}
