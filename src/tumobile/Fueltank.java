package tumobile;

public class Fueltank {

    private double capacity;
    private double fuelLevel;

    public Fueltank(double capacity, double fuelLevel) {
        this.capacity = capacity;
        this.fuelLevel = fuelLevel;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public double fill(double amount) {
        if (amount < 0) {
            return amount;
        }
        if (fuelLevel + amount > capacity) {
            double remaining = fuelLevel + amount - capacity;
            fuelLevel = capacity;
            return remaining;
        } else {
            fuelLevel += amount;
            return 0;
        }
    }

    public double consume(double amount) {
        if (amount < 0) {
            return amount;
        }
        if (fuelLevel - amount < 0) {
            double remaining = amount - fuelLevel;
            fuelLevel = 0;
            return remaining;
        } else {
            fuelLevel -= amount;
            return 0;
        }
    }
}
