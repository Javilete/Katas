package outside.in.ferry;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class CarShould {

    private Car car;

    @Before
    public void setUp() throws Exception {
        car = new Car(4, "red", "GB1234");;
    }

    @Test
    public void addAtripWithTheFerryToTheList() {
        Ferry ferry = new Ferry(4, 9);

        car.addTripTo(ferry);

        assertThat(car.getTripsFor(ferry), is(1));
    }

    @Test
    public void checkIfItIsHalfPriceRideWhenNumberOfTripsInTheSameFerryIsThree() {
        Ferry ferry = new Ferry(4, 9);

        car.addTripTo(ferry);
        car.addTripTo(ferry);
        car.addTripTo(ferry);

        assertTrue(car.isHalfPriceTrip(ferry));
    }

    @Test
    public void checkIfItIsFreeRideWhenNumberOfTripsInAnyFerrryIsSeven() {
        Ferry ferry = new Ferry(4, 9);
        Ferry ferry2 = new Ferry(4, 8);

        car.addTripTo(ferry);
        car.addTripTo(ferry);
        car.addTripTo(ferry);
        car.addTripTo(ferry2);
        car.addTripTo(ferry2);
        car.addTripTo(ferry2);
        car.addTripTo(ferry2);

        assertTrue(car.isFreeTrip());
    }
}
