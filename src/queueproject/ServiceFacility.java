package queueproject;

import java.util.Random;
import datastructures.QueueInterface;
import datastructures.Queue_Linked;

/**
 * Runs a service station that can simulate queues in action. Different
 * scenarios like waiting line, waiting lines with 2 cash registers, or a
 * process line like a carwash, or a simple
 *
 * @author Erik Lunna
 */
public class ServiceFacility {

    private static final Random randomGenerator = new Random();
    private final QueueInterface<Integer> queue;
    private static final int MIN_PER_HOUR = 60;
    private static final int SEC_PER_MIN = 60;
    private int timeOpen;
    private int clientsServed;
    private int totalWaitTime;
    private int totalServiceTime;
    private int serviceCountdown;
    private int arrivalCountdown;
    int downtime;

    boolean processAllInQueue = true;

    public ServiceFacility() {
        this.queue = new Queue_Linked<>();
        arrivalCountdown = generateRandomTime();
        timeOpen = 0;
        clientsServed = 0;
        totalWaitTime = 0;
        totalServiceTime = 0;
        serviceCountdown = 0;
        downtime = 0;
    }

    /**
     * Runs a simulation for the duration of a workday in the hours specified.
     *
     * @param hours
     * @throws InterruptedException
     */
    public void runWorkday(int hours) throws InterruptedException {
        // Setup time the service station is open
        final int maxTimeOpen = hours * SEC_PER_MIN * MIN_PER_HOUR;

        // Print welcome screen, menu, etc.
        intro();

        // Main Loop
        // Keep processing until maxTimeOpen is reached.
        while (timeOpen < maxTimeOpen
                || processAllInQueue && queue.size() > 0) {

            // There is a new arrival in the door
//            if (arrivalCountdown == 0 && clientsServed < MAX_CUSTOMERS) {
            if (arrivalCountdown == 0 && timeOpen < maxTimeOpen) {
            

                System.out.println("Time(" + timeOpen + ") *** New Arrival! ");
                displayQueueLength();

                // Is the service available?
                if (serviceCountdown <= 0) {
                    // Yes, if no one is in service, assume noone's in queue
                    // Because in our method when the serviceCountdown 
                    // reaches 0 we auto dequeue the next person in line.

                    // service the arrival
                    System.out.println("Time(" + timeOpen + ") Servicing arrival ");
                    downtime += serviceCountdown;
                    serviceCountdown = generateRandomTime();
                    totalServiceTime += serviceCountdown;
                    arrivalCountdown = generateRandomTime();
                } else {
                    // No - service is busy -  put arrival in line.
                    // store the current time as the data piece for the queue
                    //      (other things that could go in the queue)
                    // we could compare it to the time it gets out for the waiting time.
                    System.out.println("Time(" + timeOpen + ") Enqueueing arrival");

                    Integer forQueue = timeOpen;
                    queue.enqueue(timeOpen);
//                    queue.enqueue(forQueue);
                    arrivalCountdown = generateRandomTime();
                    runService();
                }
            } else {
                runService();
            }
            Thread.sleep(2);

            timeOpen++;
        }
        summary();
    }

    private void summary() {
        System.out.println("");
        System.out.println("###################################################");
        System.out.println("");
        System.out.println("Service Facility Closed!");
        System.out.println(clientsServed + " served!");
        System.out.println("Total time open = " + timeOpen / MIN_PER_HOUR + " minutes.");
        double avgWait = (double) totalWaitTime / clientsServed;
        System.out.println("Average Customer Wait Time: " + avgWait / MIN_PER_HOUR + " minutes");
        System.out.println("Total downtime (no service): " + downtime / MIN_PER_HOUR + " minutes");
    }

    private void intro() {
        System.out.println("Opening Service Facility:");
        System.out.println("Today we are serving customers.");
        System.out.println(". . . .");
        System.out.println("The waiting queue updates with new arrivals");
        System.out.println("The people waiting are represented by '@' signs");
        System.out.println("Get to work!");
        System.out.println("##################################################");
        System.out.println("##################################################");
    }

    private void runService() {
        serviceCountdown--;

        // Count a service as completed when serviceCountdown = 0;
        // When it is negative, it is building the downtime for us.
        if (serviceCountdown == 0) {
            clientsServed++;
            System.out.println("Time(" + timeOpen + ") Service # " + clientsServed + " completed");
            if (!queue.isEmpty()) {
                queue.dequeue();
                System.out.println("Time(" + timeOpen + ") Dequeueing and Servicing next client ");
                downtime += serviceCountdown;
                serviceCountdown = generateRandomTime();
            }
        }
        arrivalCountdown--;
    }

    public int generateRandomTime() {
        Double timeDouble = randomGenerator.nextDouble();

        if (timeDouble > 0 && timeDouble < .6) {
            return 150; // SECONDS
        } else if (timeDouble >= .6 && timeDouble < .8) {
            return 450;
        } else if (timeDouble >= .8 && timeDouble < .9) {
            return 750;
        } else {
            return 1050;
        }
    }

    public void displayQueueLength() {
        System.out.print("\nTime(" + timeOpen + ") QUEUE:  ");
        for (int i = 0; i < queue.size(); i++) {
            System.out.print(" @ ");
        }
        System.out.print("\n");
    }
}
