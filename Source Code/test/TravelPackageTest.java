import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.List;

public class TravelPackageTest {

    @Test
    public void testTravelPackageInitialization() {
        TravelPackage travelPackage = new TravelPackage("Test Package", 5);

        assertEquals("Test Package", travelPackage.getName());
        assertEquals(5, travelPackage.getPassengerCapacity());
        assertNotNull(travelPackage.getItinerary());
        assertNotNull(travelPackage.getPassengers());
        assertTrue(travelPackage.getItinerary().isEmpty());
        assertTrue(travelPackage.getPassengers().isEmpty());
    }

    @Test
    public void testAddDestinationToTravelPackage() {
        TravelPackage travelPackage = new TravelPackage("Test Package", 5);
        Destination destination = new Destination("Test Destination");

        assertEquals(0, travelPackage.getItinerary().size());

        travelPackage.addDestination(destination);

        assertEquals(1, travelPackage.getItinerary().size());
        assertTrue(travelPackage.getItinerary().contains(destination));
    }

    @Test
    public void testAddPassengerToTravelPackage() {
        TravelPackage travelPackage = new TravelPackage("Test Package", 2);
        Passenger passenger1 = new StandardPassenger("Passenger 1", 101, 200.0);
        Passenger passenger2 = new GoldPassenger("Passenger 2", 102, 300.0);

        travelPackage.addPassenger(passenger1);
        travelPackage.addPassenger(passenger2);

        List<Passenger> passengers = travelPackage.getPassengers();

        assertEquals(2, passengers.size());
        assertTrue(passengers.contains(passenger1));
        assertTrue(passengers.contains(passenger2));

        // Ensure exceeding passenger capacity doesn't add more passengers
        Passenger passenger3 = new PremiumPassenger("Passenger 3", 103);
        travelPackage.addPassenger(passenger3);

        assertEquals(2, passengers.size());
        assertFalse(passengers.contains(passenger3));
    }

    // Add more test methods to thoroughly test TravelPackage class functionality
}
