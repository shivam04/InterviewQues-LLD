package deginhotcounter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class HitCounter2 {
    private static final int threshold = 300;
    Integer[] times;
    Integer[] hits;
    public HitCounter2() {
        times = new Integer[threshold];
        hits = new Integer[threshold];
    }

    public void hit(int timeStamp) {
        int idx = timeStamp%threshold;
        if (times[idx] == null || times[idx] != timeStamp) {
            times[idx] = timeStamp;
            hits[idx] = 1;
        } else {
            ++hits[idx];
        }
    }

    public int getHits(int timeStamp) {
        int totalHits = 0;
        for (int i = 0; i < 300; ++i) {
            if (times[i] != null && timeStamp - times[i] < 300) {
                totalHits += hits[i];
            }
        }
        return totalHits;
    }
}
