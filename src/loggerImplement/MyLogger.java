package loggerImplement;

import java.util.*;

public class MyLogger implements Logger{
    HashMap<String, Long> startLogMap;
    HashMap<String, Long> endLogMap;

    public MyLogger() {
        this.startLogMap = new HashMap<>();
        this.endLogMap = new HashMap<>();
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
        LogEntity [] logs = new LogEntity[startLogMap.size()];
        int index = 0;
        for (Map.Entry<String,Long> m : startLogMap.entrySet()) {
            logs[index++] = new LogEntity(m.getKey(),m.getValue());
        }

        Arrays.sort(logs, (x, y) -> (int)(x.getStartTime()-y.getStartTime()));
        for (int i = 0; i < logs.length; i++) {
            LogEntity current = logs[i];
            if (endLogMap.containsKey(current.getProcessId())) {
                System.out.println(current.getProcessId() + " started at " + current.getStartTime() + " and ended at " + endLogMap.get(current.getProcessId()));
                startLogMap.remove(current.getProcessId());
                endLogMap.remove(current.getProcessId());
            }
        }
    }
}
