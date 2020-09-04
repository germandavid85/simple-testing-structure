package reports;

public class JamaReport implements Reportable {
    @Override
    public void report(String message) {
        System.out.println("Sending this to jama " + message);
    }
}
