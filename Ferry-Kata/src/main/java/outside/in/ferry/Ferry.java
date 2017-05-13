package outside.in.ferry;

import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Ferry {

    private static final String ACCEPTED = "accepted";
    private static final String REJECTED = "rejected";
    private static final String HALF_PRICE = "half price!";
    private static final String FREE_TRIP = "you go free!";

    private int peopleCount;
    private int carCount;

    private final int allowedCars;
    private final int allowedPassengers;

    private final Set<Car> boardedCars = new HashSet<>();

    public Ferry(int allowedCars, int allowedPassengers) {
        this.allowedCars = allowedCars;
        this.allowedPassengers = allowedPassengers;
    }

    public Set<Car> getBoardedCars() {
        return boardedCars;
    }

    public int getPeopleCount() { return peopleCount; }

    public String board(Car car) {
        if (isThereEnoughSpace(car)) {
            increaseCapacity(car);
            car.addTripTo(this);
            if (car.isHalfPriceTrip(this)) {
                return HALF_PRICE;
            } else if (car.isFreeTrip()) {
                return FREE_TRIP;
            }

            return ACCEPTED;
        }

        return REJECTED;
    }

    public void leave(Car car) {
        decreaseCapacity(car);
    }

    public int getColoredCars(String color) {
        Map<String, Long> coloredCars = boardedCars.stream()
                .collect(Collectors.groupingBy(Car::getColor, Collectors.counting()));

        return Optional.ofNullable(coloredCars.get(color))
                .orElse(0L)
                .intValue();
    }

    private void decreaseCapacity(Car car) {
        boardedCars.remove(car);
        peopleCount -= car.getPassengers();
        carCount = boardedCars.size();
    }

    private void increaseCapacity(Car car) {
        boardedCars.add(car);
        peopleCount += car.getPassengers();
        carCount = boardedCars.size();
    }

    private boolean isThereEnoughSpace(Car car) {
        return isCarAllowed() && arePassengersAllowed(car.getPassengers());
    }

    private boolean isCarAllowed() {
        return carCount < allowedCars;
    }

    private boolean arePassengersAllowed(int passengers) {
        return peopleCount + passengers <= allowedPassengers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ferry)) return false;

        Ferry ferry = (Ferry) o;

        if (allowedCars != ferry.allowedCars) return false;
        return allowedPassengers == ferry.allowedPassengers;

    }

    @Override
    public int hashCode() {
        int result = allowedCars;
        result = 31 * result + allowedPassengers;
        return result;
    }
}
