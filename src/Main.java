import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Path to the input file
        String inputFilePath = "src/TEST CASES/test11.txt";

        // Create a single shared ParkingLot instance
        ParkingLot sharedParkingLot = new ParkingLot();

        // Load vehicle data from the input file
        List<Car> cars = ParkingDataLoader.loadVehicleData(inputFilePath, sharedParkingLot);

        // Validate parsed vehicle data before processing
        if (cars != null && DataValidator.checkVehicleData(cars)) {
            System.out.println("Validation Complete: All vehicle data is correct!");

            // Start threads for each car
            for (Car car : cars) {
                car.start(); // Start the thread associated with each Car
            }

            // Wait for all car threads to complete
            for (Car car : cars) {
                try {
                    car.join(); // Ensure each thread finishes before proceeding
                } catch (InterruptedException e) {
                    System.err.println("Main thread interrupted while waiting for car threads to finish.");
                    Thread.currentThread().interrupt();
                }
            }

            // Final report after all cars have parked and exited
            sharedParkingLot.updateStatus(); // Print total cars served, parking status, and gate details
        } else {
            System.out.println("Error: Vehicle data validation failed!");
        }
    }
}
