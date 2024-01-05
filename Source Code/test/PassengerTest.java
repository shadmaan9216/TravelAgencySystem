import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.*;

public class PassengerTest {

    // Since Passenger is an abstract class, testing will be done through its
    // concrete subclasses

    @Test
    public void testStandardPassengerInitialization() {
        StandardPassenger standardPassenger = new StandardPassenger("Test Standard Passenger", 101, 500.0);

        assertEquals("Test Standard Passenger", standardPassenger.getName());
        assertEquals(101, standardPassenger.getPassengerNumber());
        assertEquals(500.0, standardPassenger.getBalance(), 0.001);
    }

    @Test
    public void testStandardPassengerSignUpForActivityWithSufficientBalance() {
        StandardPassenger standardPassenger = new StandardPassenger("Test Standard Passenger", 101, 500.0);
        Activity activity = new Activity("Test Activity", "Description", 50.0, 10);

        standardPassenger.signUpForActivity(activity, null);

        assertEquals(1, standardPassenger.getActivities().size());
        assertTrue(standardPassenger.getActivities().contains(activity));
    }

    @Test
    public void testGoldPassengerInitialization() {
        GoldPassenger goldPassenger = new GoldPassenger("Test Gold Passenger", 102, 700.0);

        assertEquals("Test Gold Passenger", goldPassenger.getName());
        assertEquals(102, goldPassenger.getPassengerNumber());
        assertEquals(700.0, goldPassenger.getBalance(), 0.001);
    }

    @Test
    public void testGoldPassengerGetSignedUpPriceWithSufficientBalance() {
        GoldPassenger goldPassenger = new GoldPassenger("Test Gold Passenger", 102, 500.0);
        Activity activity = new Activity("Test Activity", "Description", 50.0, 10);

        double price = goldPassenger.getSignedUpPrice(activity);

        assertEquals(45.0, price, 0.001); // 10% discount on activity cost
    }

    // Add more test methods to thoroughly test Passenger subclasses
}
