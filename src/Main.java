import java.util.List;

public class Main {
    public static void main(String[] args) {
        String inputFilePath = "parking_data.txt";
        ParkingLot sharedParkingLot = new ParkingLot(); // Single shared instance
        List<Car> Cars = ParkingDataLoader.loadVehicleData(inputFilePath, sharedParkingLot);

        // Validate parsed vehicle data before processing
        if (DataValidator.checkVehicleData(Cars)) {
            System.out.println("Validation Complete: All vehicle data is correct!");
            for (Car vehicle : Cars) {
                System.out.println(vehicle);
            }
        } else {
            System.out.println("Error: Vehicle data validation failed!");
        }
    }
}
