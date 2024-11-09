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
                new Thread(car).start();}

                finalReport(sharedParkingLot);
        }
            else {
            System.out.println("Error: Vehicle data validation failed!");
        }
    }
    public static void finalReport(ParkingLot parkingLot) {
        try {
            // Give time for simulation to complete
            Thread.sleep(1000); // Adjust this sleep time to match the simulation duration
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        // Print final status
        parkingLot.updateStatus();  // Will print total cars served and current occupied spots
    }
}

