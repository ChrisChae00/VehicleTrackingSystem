import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    private int x, y; // Current location in Cartesian coordinates
    private List<VehicleObserver> observers; // List of observers
    private double totalDistance = 0.0; // Total traveled distance

    // Constructor
    public Vehicle() {
        this.x = 0;
        this.y = 0;
        this.observers = new ArrayList<>();
    }

    // Method to add an observer
    public void addObserver(VehicleObserver observer) {
        observers.add(observer);
    }

    // Method to remove an observer
    public void removeObserver(VehicleObserver observer) {
        observers.remove(observer);
    }

    // Notify all observers when location changes
    private void notifyObservers() {
        for (VehicleObserver observer : observers) {
            observer.update(x, y);
        }
    }

    // Change the vehicle's location and notify observers
    public void changeLocation(int newX, int newY) {
        System.out.println("\nVehicle moving to (" + newX + ", " + newY + ")");
        
        // Calculate distance traveled from previous position
        double distance = Math.sqrt(Math.pow(newX - x, 2) + Math.pow(newY - y, 2));
        totalDistance += distance;

        // Update location
        this.x = newX;
        this.y = newY;

        // Notify observers of the change
        notifyObservers();
    }

    // Getter for total traveled distance
    public double getTotalDistance() {
        return totalDistance;
    }
}
