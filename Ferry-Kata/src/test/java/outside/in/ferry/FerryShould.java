package outside.in.ferry;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FerryShould {

    @Test
    public void addAnewCarToTheFerryWhenAcarBoards() {
        Ferry ferry = new Ferry(1, 4);
        Car car = new Car(4, "red", "GB1234");

        ferry.board(car);

        assertThat(ferry.getBoardedCars().size(), is(1));
    }

    @Test
    public void addAcarToTheFerryIfIsNotFullAndReturnedAccepted() {
        Ferry ferry = new Ferry(1, 4);
        Car car = new Car(4, "red", "GB4563");

        String result = ferry.board(car);

        assertThat(result, is("accepted"));
    }

    @Test
    public void returnRejectedWhenThereAreEnoughCarsInTheFerry() {
        Ferry ferry = new Ferry(1, 4);
        Car car = new Car(4, "red", "GB8724");
        ferry.board(car);

        String result = ferry.board(car);

        assertThat(result, is("rejected"));
    }

    @Test
    public void returnRejectedWhenThereAreEnoughPeople() {
        Ferry ferry = new Ferry(2, 3);
        Car car = new Car(4, "red", "GB4983");
        ferry.board(car);

        String result = ferry.board(car);

        assertThat(result, is("rejected"));
    }

    @Test
    public void returnNumberOfCarsInTheFerryForAcolorProvided() {
        Ferry ferry = new Ferry(5, 20);
        ferry.board(new Car(4, "red", "GB1111"));
        ferry.board(new Car(4, "red", "GB4456"));
        ferry.board(new Car(4, "red", "GB6763"));
        ferry.board(new Car(4, "blue", "GB8989"));

        int redCars = ferry.getColoredCars("red");

        assertThat(redCars, is(3));
    }

    @Test
    public void returnZeroWhenThereAreNoCarsWithTheColorProvided() {
        Ferry ferry = new Ferry(5, 20);
        ferry.board(new Car(4, "red", "GB9191"));
        ferry.board(new Car(4, "red", "GB2736"));
        ferry.board(new Car(4, "red", "GB9502"));
        ferry.board(new Car(4, "blue", "GB7401"));

        int purpleCars = ferry.getColoredCars("purple");

        assertThat(purpleCars, is(0));
    }

    @Test
    public void decreaseNumberOfCarsWhenAcarLeavesTheFerry() {
        Ferry ferry = new Ferry(5, 20);
        Car redOne = new Car(3, "red", "GB9076");
        ferry.board(redOne);
        ferry.board(new Car(2, "blue", "GB9999"));
        ferry.board(new Car(1, "green", "GB7654"));

        ferry.leave(redOne);

        assertThat(ferry.getBoardedCars().size(), is(2));
    }

    @Test
    public void decreaseNumberOfPeopleWhenAcarLeavesTheFerry() {
        Ferry ferry = new Ferry(5, 20);
        Car redOne = new Car(3, "red", "GB9076");
        ferry.board(redOne);
        ferry.board(new Car(5, "blue", "GB9999"));

        ferry.leave(redOne);

        assertThat(ferry.getPeopleCount(), is(5));
    }

    @Test
    public void returnHalfPriceWhenAcarHasDoneAtripThreeTimesWithTheSameFerry() {
        Ferry ferry = new Ferry(5, 20);
        Car car = new Car(3, "red", "GB9011");
        makeTrips(car, ferry, 2);

        String boardingResult = ferry.board(car);

        assertThat(boardingResult, is("half price!"));
    }

    @Test
    public void returnFreeTripWhenAcarHasDoneSevenTripsWithAnyFerry() {
        Ferry ferry1 = new Ferry(5, 20);
        Ferry ferry2 = new Ferry(8, 20);
        Car car = new Car(3, "red", "GB9011");
        makeTrips(car, ferry1, 2);
        makeTrips(car, ferry2, 4);

        String boardingResult = ferry2.board(car);

        assertThat(boardingResult, is("you go free!"));
    }

    private void makeTrips(Car car, Ferry ferry, int trips) {
        for(int i = 0; i < trips; i++) {
            ferry.board(car);
            ferry.leave(car);
        }
    }
}
