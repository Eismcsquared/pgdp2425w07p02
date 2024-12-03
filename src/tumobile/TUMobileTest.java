package tumobile;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TUMobileTest {

    private static Car car;

    @BeforeEach
    public void instantiate() {
        car = CarFactory.getInstance().getAssembledCar();
    }
    @Test
    public void consumptionPositive() {
        assertTrue(car.getEngine().getConsumption() > 0);
    }
    
    @Test
    public void capacityPositive() {
        assertTrue(car.getFueltank().getCapacity() >= 0);
    }

    @Test
    public void fillLevelValide() {
        assertTrue(car.getFueltank().getFuelLevel() >= 0);
        assertTrue(car.getFueltank().getFuelLevel() <= car.getFueltank().getCapacity());
    }
    @Test
    public void fillTankNegative() {
        double oldFillLevel = car.getFueltank().getFuelLevel();
        assertEquals(-3, car.getFueltank().fill(-3), 1e-12);
        assertEquals(oldFillLevel, car.getFueltank().getFuelLevel(), 1e-12);
    }

    @Test
    public void fillTankValide() {
        double oldFillLevel = car.getFueltank().getFuelLevel();
        double toFill = (car.getFueltank().getCapacity() - car.getFueltank().getFuelLevel()) / 2;
        car.getFueltank().fill(toFill);
        assertEquals(oldFillLevel + toFill, car.getFueltank().getFuelLevel(), 1e-12);
    }

    @Test
    public void fillTankOverflow() {
        double oldFillLevel = car.getFueltank().getFuelLevel();
        double toFill = (car.getFueltank().getCapacity() - car.getFueltank().getFuelLevel()) * 3 / 2;
        assertEquals(toFill / 3, car.getFueltank().fill(toFill), 1e-12);
        assertEquals(car.getFueltank().getCapacity(), car.getFueltank().getFuelLevel(), 1e-12);
    }

    @Test
    public void consumeTankNegative() {
        double oldFillLevel = car.getFueltank().getFuelLevel();
        assertEquals(-3, car.getFueltank().consume(-3), 1e-12);
        assertEquals(oldFillLevel, car.getFueltank().getFuelLevel(), 1e-12);
    }

    @Test
    public void consumeTankValide() {
        double oldFillLevel = car.getFueltank().getFuelLevel();
        double toFill = oldFillLevel / 2;
        car.getFueltank().consume(toFill);
        assertEquals(oldFillLevel / 2, car.getFueltank().getFuelLevel(), 1e-12);
    }

    @Test
    public void consumeTankOverflow() {
        double oldFillLevel = car.getFueltank().getFuelLevel();
        double toFill = oldFillLevel * 3 / 2;
        assertEquals(toFill / 3, car.getFueltank().consume(toFill), 1e-12);
        assertEquals(0, car.getFueltank().getFuelLevel(), 1e-12);
    }

    @Test
    public void carComponentsPresent() {
        assertNotNull(car.getEngine());
        assertNotNull(car.getFueltank());
        assertNotNull(car.getFrontLeftWheel());
        assertNotNull(car.getFrontRightWheel());
        assertNotNull(car.getRearLeftWheel());
        assertNotNull(car.getRearRightWheel());
    }

    @Test
    public void sameWheelSize() {
        Wheel fr = car.getFrontRightWheel();
        Wheel fl = car.getFrontLeftWheel();
        Wheel rr = car.getRearRightWheel();
        Wheel rl = car.getRearLeftWheel();
        assertEquals(fr.getDiameter(), fl.getDiameter());
        assertEquals(fl.getDiameter(), rr.getDiameter());
        assertEquals(rr.getDiameter(), rl.getDiameter());
        assertEquals(fr.getWidth(), fl.getWidth());
        assertEquals(fl.getWidth(), rr.getWidth());
        assertEquals(rr.getWidth(), rl.getWidth());
    }

    @Test
    public void differentWheels() {
        Wheel fr = car.getFrontRightWheel();
        Wheel fl = car.getFrontLeftWheel();
        Wheel rr = car.getRearRightWheel();
        Wheel rl = car.getRearLeftWheel();
        assertNotSame(fr, fl);
        assertNotSame(fr, rr);
        assertNotSame(fr, rl);
        assertNotSame(fl, rr);
        assertNotSame(fl, rl);
        assertNotSame(rr, rl);
    }

    @Test
    public void correctRange() {
        assertEquals(car.getFueltank().getFuelLevel() * 100 / car.getEngine().getConsumption(), car.getRange(), 1e-12);
    }

    @Test
    public void correctMaxRange() {
        assertEquals(car.getFueltank().getCapacity() * 100 / car.getEngine().getConsumption(), car.getMaxRange(), 1e-12);
    }

}
