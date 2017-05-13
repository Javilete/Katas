package outside.in.ferry;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Car {

    private static final int HALF_PRICE_TRIPS_NUMBER = 3;
    private static final int FREE_TRIPS_NUMBER = 7;

    private final int passengers;
    private final String color;
    private final String numberPlate;
    private final Map<Ferry, Integer> trips = new HashMap<>();

    public Car(int passengers, String color, String numberPlate) {
        this.color = color;
        this.passengers = passengers;
        this.numberPlate = numberPlate;
    }

    public int getPassengers() {
        return this.passengers;
    }

    public String getColor() {
        return this.color;
    }

    public void addTripTo(Ferry ferry) {
        int currentTrips = trips.getOrDefault(ferry, 0);
        currentTrips++;
        trips.put(ferry, currentTrips);
    }

    public int getTripsFor(Ferry ferry) {
        return Optional.ofNullable(trips.get(ferry)).orElse(0);
    }

    public boolean isHalfPriceTrip(Ferry ferry) {
        return getTripsFor(ferry) == HALF_PRICE_TRIPS_NUMBER ? Boolean.TRUE : Boolean.FALSE;
    }

    public boolean isFreeTrip() {
        int totalTrips = getTotalTrips();
        return totalTrips == FREE_TRIPS_NUMBER ? Boolean.TRUE : Boolean.FALSE;
    }

    private int getTotalTrips() {
        return trips.values().stream()
                .mapToInt(i -> i)
                .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;

        Car car = (Car) o;

        return numberPlate.equals(car.numberPlate);

    }

    @Override
    public int hashCode() {
        return numberPlate.hashCode();
    }
}
