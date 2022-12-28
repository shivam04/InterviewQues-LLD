package loggerproblem;

import java.util.HashMap;
import java.util.Map;

public class Logger {
    Map<String, Integer> messageTracker;

    public Logger() {
        messageTracker = new HashMap<String, Integer>();
    }

    public void shouldPrintMessage(int time, String message) {
        boolean willPrint = false;
        Integer prevTime = messageTracker.get(message);
        if (prevTime == null || time - prevTime >= 10) {
            willPrint = true;
            messageTracker.put(message, time);
        }
        System.out.println(willPrint);
    }
}
