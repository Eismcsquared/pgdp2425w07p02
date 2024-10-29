package tumobile;

public class Car {

    private Engine engine;
    private Fueltank fueltank;
    private Wheel frontLeftWheel;
    private Wheel frontRightWheel;
    private Wheel rearLeftWheel;
    private Wheel rearRightWheel;

    public Car(Engine engine, Fueltank fueltank, Wheel frontLeftWheel, Wheel frontRightWheel, Wheel rearLeftWheel, Wheel rearRightWheel) {
        this.engine = engine;
        this.fueltank = fueltank;
        this.frontLeftWheel = frontLeftWheel;
        this.frontRightWheel = frontRightWheel;
        this.rearLeftWheel = rearLeftWheel;
        this.rearRightWheel = rearRightWheel;
    }

    public Engine getEngine() {
        return engine;
    }

    public Fueltank getFueltank() {
        return fueltank;
    }

    public Wheel getFrontLeftWheel() {
        return frontLeftWheel;
    }

    public Wheel getFrontRightWheel() {
        return frontRightWheel;
    }

    public Wheel getRearLeftWheel() {
        return rearLeftWheel;
    }

    public Wheel getRearRightWheel() {
        return rearRightWheel;
    }

    public double getRange() {
        return fueltank.getFuelLevel() / engine.getConsumption() * 100;
    }

    public double getMaxRange() {
        return fueltank.getCapacity() / engine.getConsumption() * 100;
    }
}
