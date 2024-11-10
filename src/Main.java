import java.util.List;

public class Main {
    public static void main(String[] args) {
        String inputFilePath = "C:\\Users\\WIN10\\Downloads\\Multithreaded-Parking-System-Simulation\\src\\parking_data.txt";
        ParkingLot sharedParkingLot = new ParkingLot(); // Single shared instance
        List<Car> Cars = ParkingDataLoader.loadVehicleData(inputFilePath, sharedParkingLot);

        // Validate parsed vehicle data before processing
        if (DataValidator.checkVehicleData(Cars)) {
            System.out.println("Validation Complete: All vehicle data is correct!");
            for (Car car : Cars) {
                new Thread(car).start();
            }

            // Simulate waiting for the threads to finish (you can adjust this depending on the simulation time)
            try {
                // Wait enough time to allow all cars to arrive and leave
                Thread.sleep(5000);  // Adjust this time based on the actual time required for your simulation
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            // Final report after all cars have parked and left
            sharedParkingLot.updateStatus();  // Print the total cars served, current parking status, and details for each gate
        } else {
            System.out.println("Error: Vehicle data validation failed!");
        }
    }
}
