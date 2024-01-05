import static org.junit.Assert.assertEquals;

import org.junit.*;

public class StandardPassengerTest {

    @Test
    public void testStandardPassengerInitialization() {
        StandardPassenger standardPassenger = new StandardPassenger("Test Standard Passenger", 101, 500.0);

        assertEquals("Test Standard Passenger", standardPassenger.getName());
        assertEquals(101, standardPassenger.getPassengerNumber());
        assertEquals(500.0, standardPassenger.getBalance(), 0.001);
    }

    @Test
    public void testSignedUpPriceWithSufficientBalance() {
        StandardPassenger standardPassenger = new StandardPassenger("Test Standard Passenger", 101, 500.0);
        Activity activity = new Activity("Test Activity", "Description", 50.0, 10);

        double price = standardPassenger.getSignedUpPrice(activity);

        assertEquals(50.0, price, 0.001); // Balance covers the full activity cost
    }

    @Test
    public void testSignedUpPriceWithInsufficientBalance() {
        StandardPassenger standardPassenger = new StandardPassenger("Test Standard Passenger", 101, 20.0);
        Activity activity = new Activity("Test Activity", "Description", 50.0, 10);

        double price = standardPassenger.getSignedUpPrice(activity);

        assertEquals(0.0, price, 0.001); // Insufficient balance, price should be 0.0
    }

    // Add more test methods to thoroughly test StandardPassenger class
    // functionality
}
