public class Car extends Thread{
    int car_id;
    int arrival_time;
    int parking_duration;
    String gate_id;
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

    public String getGateId() {
        return gate_id;
    }
    @Override
    void run() throws InterruptedException{
        Thread.sleep(arrival_time);
        parkingLot.carEnter(this);
        Thread.sleep(parking_duration);
        parkingLot.carExit(this);

    }
    @Override
    public String toString() {
        return "Vehicle [Gate: " + gate_id +
                ", ID: " + car_id +
                ", Arrival Time: " + arrival_time +
                ", Parking Duration: " + parking_duration + "]";
    }
}