package loggerImplement;

public class LogEntity {
    private String processId;
    private long startTime;

    public long getStartTime() {
        return startTime;
    }

    public String getProcessId() {
        return processId;
    }

    public LogEntity(String processId, long startTime) {
        this.processId = processId;
        this.startTime = startTime;
    }
}
