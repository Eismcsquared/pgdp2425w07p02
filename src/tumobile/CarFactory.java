package tumobile;

public class CarFactory {

    private static CarFactory instance;

    protected CarFactory() {
    }

    public static CarFactory getInstance() {
        if (instance == null) {
            instance = new CarFactory();
        }
        return instance;
    }

    public Car getAssembledCar() {
        Engine engine = new Engine(5.0);
        Fueltank fueltank = new Fueltank(60.0, 60.0);
        Wheel frontLeftWheel = new Wheel(17.0, 225.0, 2.0);
        Wheel frontRightWheel = new Wheel(17.0, 225.0, 2.0);
        Wheel rearLeftWheel = new Wheel(17.0, 225.0, 2.0);
        Wheel rearRightWheel = new Wheel(17.0, 225.0, 2.0);
        return new Car(engine, fueltank, frontLeftWheel, frontRightWheel, rearLeftWheel, rearRightWheel);
    }
}
