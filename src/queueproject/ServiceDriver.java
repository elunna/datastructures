package queueproject;

/**
 * The driver for the ServiceFacility class.
 *
 * @author Erik Lunna
 */
public class ServiceDriver {

    public static void main(String[] args) throws InterruptedException {

        ServiceFacility sf = new ServiceFacility();
        sf.runWorkday(8);
    }
}
