import models.MilitaryType;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;

import java.util.Arrays;
import java.util.List;

public class Runner {
    static List<Plane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT)
    );

    public static void main(String[] args) {
        Airport airport = new Airport(planes);
        Airport militaryAirport = new Airport(airport.GetMilitaryPlanes());
        Airport passengerAirport = new Airport(airport.GetPassengerPlanes());
        System.out.println("Military airport sorted by max distance: " + militaryAirport
                .SortPlanesByMaxDistance()
                .ToString());
        System.out.println("Passenger airport sorted by max speed: " + passengerAirport
                .SortByMaxSpeed()
                .ToString());

        System.out.println("Plane with max passenger capacity: " + passengerAirport.GetPassengerPlaneWithMaxPassengersCapacity());
    }
}
