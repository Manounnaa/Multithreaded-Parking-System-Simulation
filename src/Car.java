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
    public void run() {  // Set run() method to public to match the superclass method visibility
        try {
            Thread.sleep(arrival_time);
            parkingLot.carEnter(this);
            Thread.sleep(parking_duration);
            parkingLot.carExit(this);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public String toString() { //toString : debugging and logging vehicleinfo
        return "Vehicle [Gate " + gate_id +
                ", Car " + car_id +
                ", Arrive " + arrival_time +
                ", Parks " + parking_duration + "]";
    }
}




