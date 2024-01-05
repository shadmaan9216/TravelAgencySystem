import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TravelAgencySystemTest {

    @Test
    public void testAddDestination() {
        TravelPackage travelPackage = new TravelPackage("Test Package", 10);
        Destination destination = new Destination("Paris");

        travelPackage.addDestination(destination);

        assertTrue(travelPackage.getItinerary().contains(destination));
    }

    @Test
    public void testAddPassengerToPackage() {
        TravelPackage travelPackage = new TravelPackage("Test Package", 10);
        Passenger passenger = new StandardPassenger("John", 101, 500.0);

        travelPackage.addPassenger(passenger);

        assertTrue(travelPackage.getPassengers().contains(passenger));
    }

    @Test
    public void testPrintItinerary() {
        TravelPackage travelPackage = new TravelPackage("Test Package", 10);
        Destination destination = new Destination("Paris");
        destination.addActivity(new Activity("Eiffel Tower Tour", "Visit Eiffel Tower", 50.0, 10));
        travelPackage.addDestination(destination);

        // Redirect standard output to capture printed output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        travelPackage.printItinerary();

        // Define your expected output based on the behavior of your system
        String expectedOutput = "Travel Package: Test Package\r\n" + //
                "Destination: Paris\r\n" + //
                "- Activity: Eiffel Tower Tour, Description: Visit Eiffel Tower, Cost: 50.0, Capacity: 10";

        // Get the printed content
        String printedContent = outContent.toString().trim(); // Trim to remove extra spaces/newlines

        // Assert that the printed output matches the expected output
        assertEquals(expectedOutput, printedContent);
    }

    // Write more test cases to cover other functionalities in TravelAgencySystem
}
