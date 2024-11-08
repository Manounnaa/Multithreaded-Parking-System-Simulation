import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DataValidator {
    // validation pv data to ensure accuracy and consistency
    public static boolean checkVehicleData(List<ParkingVehicle> vehicles) {
        Set<String> uniqueIdentifiers = new HashSet<>();
        for (ParkingVehicle vehicle : vehicles) {
            // Ensure arrival time and duration are within acceptable ranges
            if (vehicle.arrivalTimeUnits < 0 || vehicle.parkingDurationUnits <= 0) {
                System.out.println("Data Error: Vehicle ID " + vehicle.vehicleId +
                        " at " + vehicle.entryGate + " has invalid time values ");
                return false;
            }
            //unique vehicle ID per gate to prevent duplicate entries
            String uniqueID = vehicle.entryGate + "-" + vehicle.vehicleId;
            if (!uniqueIdentifiers.add(uniqueID)) {
                System.out.println("Duplicate Entry Detected: Vehicle ID " + vehicle.vehicleId +
                        " at " + vehicle.entryGate);
                return false;
            }
        }
        // Return true if all vehicles pass the validation
        return true;
    }
}

