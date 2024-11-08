public class ParkingVehicle {
        String entryGate;
        int vehicleId;
        int arrivalTimeUnits;
        int parkingDurationUnits;

        ParkingVehicle(String entryGate, int vehicleId, int arrivalTimeUnits, int parkingDurationUnits) {
            this.entryGate = entryGate;
            this.vehicleId = vehicleId;
            this.arrivalTimeUnits = arrivalTimeUnits;
            this.parkingDurationUnits = parkingDurationUnits;
        }

        //toString : debugging and logging vehicleinfo
        @Override
        public String toString() {
            return "Vehicle [Gate: " + entryGate +
                    ", ID: " + vehicleId +
                    ", Arrival Time: " + arrivalTimeUnits +
                    ", Parking Duration: " + parkingDurationUnits + "]";
        }
    }


