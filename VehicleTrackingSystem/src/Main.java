// Main.java
public class Main {
    public static void main(String[] args) {
        // Create Vehicle (Subject)
        Vehicle vehicle = new Vehicle();

        // Create Observers
        CurrentLocationDisplay locationDisplay = new CurrentLocationDisplay();
        TotalTravelledDistanceDisplay distanceDisplay = new TotalTravelledDistanceDisplay();
        DangerZoneDisplay dangerZoneDisplay = new DangerZoneDisplay();

        // Register Observers
        vehicle.addObserver(locationDisplay);
        vehicle.addObserver(distanceDisplay);
        vehicle.addObserver(dangerZoneDisplay);

        // Start Simulation at (0,0)
        System.out.println("\n--- Vehicle Tracking Simulation ---");
        vehicle.changeLocation(0, 0); // Initial position

        // Simulating the given test locations (example)
        int[][] testLocations = {
            {0, 0}, 
            {2, 2},  
            {2, 4}, 
            {4, 6},	// Danger zone
            {6, 8},	// Danger zone
            {8, 10} 
        };

        // Move the vehicle to each test location
        for (int[] location : testLocations) {
            vehicle.changeLocation(location[0], location[1]);
        }

        // Final Display of Travelled Distance
        System.out.println("\nFinal Total Distance Travelled: " + distanceDisplay.getTotalDistance() + " units");
    }
}
