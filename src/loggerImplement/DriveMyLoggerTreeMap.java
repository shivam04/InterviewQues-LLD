package loggerImplement;

public class DriveMyLoggerTreeMap {
    public static void main(String[] args) {
        Logger log = new MyLoggerTreeMap();
        log.start("2", 100);
        log.start("1", 101);
        log.end("2", 102);
        log.start("3", 103);
        log.end("1", 104);
        log.end("3", 105);
        log.start("4", 102);
        log.print();
        log.end("4", 106);
        log.print();
    }
}
