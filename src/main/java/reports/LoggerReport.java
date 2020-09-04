package reports;

public class LoggerReport implements Reportable {
    @Override
    public void report(String message) {
        System.out.println("Sending this to a logger " + message);
    }
}
