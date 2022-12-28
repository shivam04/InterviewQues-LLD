package loggerImplement;

import java.util.Map;
import java.util.TreeMap;

public class MyLoggerTreeMap implements Logger{
    Map<String, Long> startLogMap;
    Map<String, Long> endLogMap;

    public MyLoggerTreeMap() {
        startLogMap = new TreeMap<>();
        endLogMap = new TreeMap<>();
    }
/**
     * When a process starts, it calls 'start' with processId and startTime.
     *
     * @param processId
     * @param startTime
     */
    @Override
    public void start(String processId, long startTime) {
        startLogMap.put(processId, startTime);
    }

    /**
     * When the same process ends, it calls 'end' with processId and endTime.
     *
     * @param processId
     * @param endTime
     */
    @Override
    public void end(String processId, long endTime) {
        endLogMap.put(processId, endTime);
    }

    /**
     * Prints the logs of this system sorted by the start time of processes in the below format
     * {processId} started at {startTime} and ended at {endTime}
     */
    @Override
    public void print() {
        for (Map.Entry<String, Long> en : startLogMap.entrySet()) {
            if (endLogMap.containsKey(en.getKey())) {
                System.out.println(" " + en.getKey() + " started at " + en.getValue() + " and ended at "
                        + endLogMap.get(en.getKey()));
                //startLogMap.remove(en.getKey());
                //endLogMap.remove(en.getKey());
            }
        }
    }
}
