
import static org.junit.Assert.assertEquals;

import org.junit.*;

public class GoldPassengerTest {

    @Test
    public void testGoldPassengerInitialization() {
        GoldPassenger goldPassenger = new GoldPassenger("Test Gold Passenger", 101, 500.0);

        assertEquals("Test Gold Passenger", goldPassenger.getName());
        assertEquals(101, goldPassenger.getPassengerNumber());
        assertEquals(500.0, goldPassenger.getBalance(), 0.001);
    }

    @Test
    public void testSignedUpPriceWithSufficientBalance() {
        GoldPassenger goldPassenger = new GoldPassenger("Test Gold Passenger", 101, 500.0);
        Activity activity = new Activity("Test Activity", "Description", 50.0, 10);

        double price = goldPassenger.getSignedUpPrice(activity);

        assertEquals(45.0, price, 0.001); // 10% discount on activity cost
    }

    @Test
    public void testSignedUpPriceWithInsufficientBalance() {
        GoldPassenger goldPassenger = new GoldPassenger("Test Gold Passenger", 101, 20.0);
        Activity activity = new Activity("Test Activity", "Description", 50.0, 10);

        double price = goldPassenger.getSignedUpPrice(activity);

        assertEquals(0.0, price, 0.001); // Insufficient balance, price should be 0.0
    }

    // Add more test methods to thoroughly test GoldPassenger class functionality
}
