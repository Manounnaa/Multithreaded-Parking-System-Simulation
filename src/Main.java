import java.util.List;
public class Main {
    public static void main(String[] args) {
                String inputFilePath = "parking_data.txt";
                List<ParkingVehicle> parkingVehicles = ParkingDataLoader.loadVehicleData(inputFilePath);
                // Validate parsed vehicle data before processing
                if (DataValidator.checkVehicleData(parkingVehicles)) {
                    System.out.println("Validation Complete: All vehicle data is correct!");
                    // display each vehicle's info for verifying
                    for (ParkingVehicle vehicle : parkingVehicles) {
                        System.out.println(vehicle);
                    }
                } else {
                    System.out.println("Error: Vehicle data validation failed!");}}}
