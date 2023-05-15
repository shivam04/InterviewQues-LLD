package rate.limit.algorithms.slidingwindowalgo;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class SlidingWindowCounter {
    private int maxRequest;
    private final ConcurrentHashMap<Long, AtomicInteger> windows;

    public SlidingWindowCounter(int maxRequest) {
        this.maxRequest = maxRequest;
        this.windows = new ConcurrentHashMap<>();
    }

    public boolean allow() {
        long currTime = System.currentTimeMillis();
        System.out.println("Current Time of Request: " + new Date(currTime) + " " + currTime);
        long curWindowKey = currTime / 60000 * 60000;
        System.out.println("Current Window Key: " + curWindowKey);
        windows.putIfAbsent(curWindowKey, new AtomicInteger(0));
        long preWindowKey = curWindowKey - 60000;
        System.out.println("Previous Window Key: " + preWindowKey);
        AtomicInteger preCount = windows.get(preWindowKey);
        if (preCount == null) {
            int count = windows.get(curWindowKey).incrementAndGet();
            System.out.println("Existing Count: " + count);
            return  count <= maxRequest;
        }
        double preWeight = 1 - (currTime - curWindowKey) / 60000.0;
        long count = (long) (preCount.get() * preWeight
                + windows.get(curWindowKey).incrementAndGet());
        System.out.println("Existing Count: " + count);
        return count <= maxRequest;
    }
}
