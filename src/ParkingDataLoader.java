import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ParkingDataLoader {
    public static List<Car> loadVehicleData(String filePath,ParkingLot parkingLot) {
        List<Car> vehicleList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] dataParts = currentLine.split(", ");
                String gateId = dataParts[0];
                int id = Integer.parseInt(dataParts[1].split(" ")[1]);
                int arrivalTime = Integer.parseInt(dataParts[2].split(" ")[1]);
                int duration = Integer.parseInt(dataParts[3].split(" ")[1]);
                vehicleList.add(new Car(id, arrivalTime, duration, gateId, parkingLot));
            }
        } catch (Exception e) {
            System.out.println("Error while reading the input file: " + e.getMessage());
        }
        return vehicleList;
    }
}
