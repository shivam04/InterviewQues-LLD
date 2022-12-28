package deginhotcounter;

import java.util.LinkedList;
import java.util.Queue;

public class HitCounter {
    private static final int threshold = 300;
    Queue<Integer> q;
    public HitCounter() {
        q = new LinkedList<Integer>();
    }

    public void hit(int timeStamp) {
        q.add(timeStamp);
    }

    public int getHits(int timeStamp) {
        while (!q.isEmpty() && timeStamp - q.peek() >= threshold) {
            q.poll();
        }
        return q.size();
    }
}
