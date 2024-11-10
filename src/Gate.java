import java.util.List;

public class Gate {
    private final String gate_id;
    private final ParkingLot parkingLot;
    private final List<Car> arrival_schedule;

    public Gate(String gateId, ParkingLot parkingLot, List<Car> arrivalSchedule) {
        this.gate_id = gateId;
        this.parkingLot = parkingLot;
        this.arrival_schedule = arrivalSchedule;
    }

    public void start() {
        for (Car car : arrival_schedule) {
            new Thread(car).start();
        }
    }
}
