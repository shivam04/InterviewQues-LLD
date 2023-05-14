package rate.limit.algorithms.slidingwindowlogalgo;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindow {
    private final Queue<Long> log = new LinkedList<>();
    private int maxRequest;

    public SlidingWindow(int maxRequest) {
        this.maxRequest = maxRequest;
    }

    public boolean allow() {
        long currTime = System.currentTimeMillis();
        System.out.println("Current Time of Request: " + new Date(currTime));
        long boundary = currTime - 60000;
        System.out.println("Boundary Time: " + new Date(boundary));
        synchronized (log) {
            while (!log.isEmpty() && log.element() <= boundary) {
                log.poll();
            }
            log.add(currTime);
            System.out.println("Current Element Size:" + log.size());
            return log.size() <= maxRequest;
        }
    }
}
