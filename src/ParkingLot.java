import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private static final int totalSpots = 4;
    private static int occupiedSpots = 0;
    private static int totalCarsServed = 0;

    // To track how many cars each gate has served
    private static Map<String, Integer> gateCarCount = new HashMap<>();
    private static semaphore parkingSemaphore = new semaphore(totalSpots); // Semaphore to manage spot availability
    private static Lock statusLock = new ReentrantLock(); // Lock to manage status updates

    public static void carEnter(Car car) throws InterruptedException {
        // Wait if no spots are available
        parkingSemaphore.acquire();
        statusLock.lock();
        try {
            occupiedSpots++;
            totalCarsServed++;

            // Increment the car count for the respective gate
            gateCarCount.put(car.getGateId(), gateCarCount.getOrDefault(car.getGateId(), 0) + 1);

            System.out.println("Car " + car.getCarId() + " from " + car.getGateId() + " arrived at time " + car.getarrival_time());
            System.out.println("Car " + car.getCarId() + " from " + car.getGateId() + " parked. (Parking Status: " + occupiedSpots + " spots occupied)");
        } finally {
            statusLock.unlock();
        }
    }

    public static void carExit(Car car) throws InterruptedException {
        statusLock.lock();
        try {
            occupiedSpots--;
            System.out.println("Car " + car.getCarId() + " from " + car.getGateId() + " left after " + car.getparking_duration() + " units of time. (Parking Status: " + occupiedSpots + " spots occupied)");
        } finally {
            statusLock.unlock();
        }
        parkingSemaphore.release();
    }

    public static void updateStatus() {
        statusLock.lock();
        try {
            System.out.println("Total Cars Served: " + totalCarsServed);
            System.out.println("Current Cars in Parking: " + occupiedSpots);

            // Print the details of cars served by each gate
            System.out.println("Details:");
            for (Map.Entry<String, Integer> entry : gateCarCount.entrySet()) {
                System.out.println("- " + entry.getKey() + " served " + entry.getValue() + " cars.");
            }
        } finally {
            statusLock.unlock();
        }
    }
}
