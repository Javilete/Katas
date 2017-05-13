Ferry-kata

In an island country far far away there are lots of Ferries that allow people to travel by car between all the different islands of this country.
This country’s government would like to control the number of cars and people that can get onto a Ferry.
To help them they need you to:
- Create a Car class: the constructor should specify the colour and the number of passengers in the car.
- Create a Ferry class: the constructor should specify the number of cars allowed on the ferry and also how many people are allowed on the ferry.

Cars are allowed onto the Ferry using the board method. If the ferry is not full yet the board method returns ‘accepted’. If there are enough people or cars on the Ferry already, the board method should return ‘rejected’.
The Ferry class instance should keep track of the number of people and cars on the Ferry using the peopleCount and carCount properties.

Once you can load cars into the Ferry, look at other things the Ferry company is interested in:
- Knowing how many cars of a certain color are on the Ferry;
- Updating the people and car counts correctly when a car leaves the Ferry;
- Giving a car 50% discount after three trips on the same ferry. The board method should return ‘half price!’;
- Giving a free trip after 7 trips on any Ferry. The board method should return ‘you go free!’

To resolve and accomplish all the criteria specified I have followed the following:
- TDD classicists where I have worked with real objects in the tests. With this approach, I have
done state verification in my tests.
- Tell, do not ask principle where basically data and behaviour resides in the same class.
The example is within Car.java class. The first thought was to create getters and do the checking
inside the Ferry.java to verify whether it was a half-price ride or a free ride.
Instead of that, I have exposed a couple of methods isHalfPriceTrip(Ferry ferry) and isFreeTrip()
and the calculations to accomplish those results are done internally in the Car.java class, therefore
the logic is inside.

