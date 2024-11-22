public class Car extends Thread {
    private final int car_id;
    private final int arrival_time;
    private final int parking_duration;
    private final String gate_id;
    private final ParkingLot parkingLot;

    public Car(int carId, int arrivalTime, int parkingDuration, String gateId, ParkingLot parkingLot) {
        this.car_id = carId;
        this.arrival_time = arrivalTime;
        this.parking_duration = parkingDuration;
        this.gate_id = gateId;
        this.parkingLot = parkingLot;
    }

    public int getCarId() {
        return car_id;
    }

    public int getarrival_time() {
        return arrival_time;
    }

    public int getparking_duration() {
        return parking_duration;
    }

    public String getGateId() {
        return gate_id;
    }

    @Override
    public void run() {
        try {
            // Wait for arrival time
            Thread.sleep(arrival_time * 1000L);
            // Log arrival
            parkingLot.carEnter(this);
            // Wait for parking duration
            Thread.sleep(parking_duration * 1000L);
            // Log exit
            parkingLot.carExit(this);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public String toString() {
        return "Vehicle [Gate " + gate_id +
                ", Car " + car_id +
                ", Arrive " + arrival_time +
                ", Parks " + parking_duration + "]";
    }
}
