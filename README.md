# Multithreaded Parking System Simulation

## Overview
The Multithreaded Parking System Simulation is a Java-based project designed to simulate the behavior of a parking lot with multiple gates, using multithreading to manage car arrivals, parking durations, and exits. The system leverages synchronization, semaphores, and locks to ensure proper management of shared resources and prevent race conditions.

## Features
- **Multithreaded Simulation**: Each car operates as a separate thread, simulating real-time car arrivals and departures.
- **Concurrency Control**: Uses semaphores to manage parking spot availability and locks for updating shared resources.
- **Dynamic Input**: Reads car data (arrival time, parking duration, gate ID) from a structured input file.
- **Validation**: Validates car data for correctness before starting the simulation.
- **Statistics**: Provides detailed reports on total cars served, current parking status, and cars served by each gate.

## Project Structure
### Key Components
1. **`Car` Class**
   - Represents a car in the simulation.
   - Runs as a thread to simulate parking behavior.
   - Attributes: Car ID, arrival time, parking duration, gate ID.

2. **`Gate` Class**
   - Manages cars entering the parking lot through specific gates.
   - Spawns threads for each car in its schedule.

3. **`ParkingLot` Class**
   - Manages parking spots and keeps track of cars currently in the lot.
   - Uses a custom semaphore for parking spot management.
   - Maintains statistics for total cars served and per-gate car counts.

4. **`semaphore` Class**
   - A custom implementation of a semaphore to manage the availability of parking spots.

5. **`DataValidator` Class**
   - Ensures the integrity of input data by checking for duplicate entries and invalid time values.

6. **`ParkingDataLoader` Class**
   - Reads car data from an input file and initializes `Car` objects.

7. **`Main` Class**
   - Entry point of the application.
   - Orchestrates data loading, validation, and simulation execution.

## How It Works
1. **Input File**: The system reads an input file containing car data. Each line specifies a car's gate ID, car ID, arrival time, and parking duration.
   ```
   Gate A, Car 1, Arrive 3, Parks 5
   Gate B, Car 2, Arrive 2, Parks 4
   ```

2. **Data Validation**: The `DataValidator` ensures that:
   - Arrival times and durations are valid.
   - Each car has a unique ID per gate.

3. **Simulation Execution**:
   - Each car thread starts after its specified arrival time.
   - Cars attempt to park, waiting if no spots are available.
   - After parking for the specified duration, cars exit and free up parking spots.

4. **Final Report**: After all cars have completed their parking, the system generates a report summarizing:
   - Total cars served.
   - Current parking status.
   - Cars served by each gate.

## Example Usage
### Input File Format
- Place the input file in the `src/TEST CASES/` directory.
- Example file: `test11.txt`

### Running the Program
1. Clone the repository:
   ```bash
   git clone https://github.com/Manounnaa/Multithreaded-Parking-System-Simulation.git
   ```
2. Compile and run the program:
   ```bash
   javac src/*.java
   java src.Main
   ```
3. View the final report in the console.

## Sample Output
```
Validation Complete: All vehicle data is correct!
Car 1 from Gate A arrived at time 3
Car 1 from Gate A parked. (Parking Status: 1 spots occupied)
Car 2 from Gate B arrived at time 2
Car 2 from Gate B parked. (Parking Status: 2 spots occupied)
Car 1 from Gate A left after 5 units of time. (Parking Status: 1 spots occupied)
Total Cars Served: 2
Current Cars in Parking: 0
Details:
- Gate A served 1 cars.
- Gate B served 1 cars.
```

## Technology Stack
- **Programming Language**: Java
- **Concurrency Tools**: Threads, Semaphores, Locks

## Repository Structure
```
Multithreaded-Parking-System-Simulation/
├── src/
│   ├── Car.java
│   ├── Gate.java
│   ├── Main.java
│   ├── ParkingDataLoader.java
│   ├── ParkingLot.java
│   ├── DataValidator.java
│   ├── semaphore.java
├── TEST CASES/
│   ├── test11.txt
└── README.md
```

## Future Improvements
- Add a graphical user interface (GUI) for better visualization.
- Extend the parking lot functionality to support different parking zones.
- Add more detailed logs and error handling for edge cases.


