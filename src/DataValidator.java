import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DataValidator {
    public static boolean checkVehicleData(List<Car> vehicles) {
        Set<String> uniqueIdentifiers = new HashSet<>();
        for (Car vehicle : vehicles) {
            // Ensure arrival time and duration are within acceptable ranges
            if (vehicle.getarrival_time() < 0 || vehicle.getparking_duration() <= 0) {
                System.out.println("Data Error: Car ID " + vehicle.getCarId() +
                        " at " + vehicle.getGateId() + " has invalid time values!");
                return false;
            }
            // Unique vehicle ID per gate to prevent duplicate entries
            String uniqueID = vehicle.getGateId() + "-" + vehicle.getCarId();
            if (!uniqueIdentifiers.add(uniqueID)) {
                System.out.println("Duplicate Entry Detected: Car ID " + vehicle.getCarId() +
                        " at " + vehicle.getGateId());
                return false;
            }
        }
        return true;
    }
}
