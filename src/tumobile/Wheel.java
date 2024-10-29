package tumobile;

public class Wheel {

    private double diameter;
    private double width;
    private double pressure;

    public Wheel(double diameter, double width, double pressure) {
        this.diameter = diameter;
        this.width = width;
        this.pressure = pressure;
    }

    public double getDiameter() {
        return diameter;
    }

    public double getWidth() {
        return width;
    }

    public double getPressure() {
        return pressure;
    }
}
