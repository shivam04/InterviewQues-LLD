package loggerproblem;

public class DriveLogger {
    public static void main(String[] args) {
        Logger logger = new Logger();
        logger.shouldPrintMessage(1, "foo");
        logger.shouldPrintMessage(2,"bar");
        logger.shouldPrintMessage(3,"foo");
        logger.shouldPrintMessage(8,"bar");
        logger.shouldPrintMessage(10,"foo");
        logger.shouldPrintMessage(11,"foo");
    }
}
