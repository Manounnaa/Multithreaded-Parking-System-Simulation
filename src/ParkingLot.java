import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ParkingLot {
    private static final int totalSpots = 4;
    private static int occupiedSpots = 0;
    private static int totalCarsServed = 0;


    private static Semaphore parkingSemaphore = new Semaphore(totalSpots); // Semaphore to manage spot availability
    private static Lock statusLock = new ReentrantLock(); // Lock to manage status updates that no one will edit it while it edited

    public static void carEnter (Car car) throws InterruptedException {
        parkingSemaphore.acquire();
        statusLock.lock();
        try {
            occupiedSpots++;
            totalCarsServed++;
            System.out.println("Car " + car.getCarId() + " entered the parking lot ");
        }
        finally {
        statusLock.unlock();
        }
    }

    public static void carExit (Car car) throws InterruptedException {
        statusLock.lock();
        try {
            occupiedSpots--;
            System.out.println("Car " + car.getCarId() + " exited the parking lot.");
        }
        finally {
            statusLock.unlock();
        }
        parkingSemaphore.release();
    }

    public static void updateStatus() {
        statusLock.lock();
        try {
            System.out.println("Current Cars in Parking: " + occupiedSpots);
            System.out.println("Total Cars Served: " + totalCarsServed);
        } finally {
            statusLock.unlock();
        }
    }



}
