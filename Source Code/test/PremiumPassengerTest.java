import static org.junit.Assert.assertEquals;

import org.junit.*;

public class PremiumPassengerTest {

    /**
     * 
     */
    @Test
    public void testPremiumPassengerInitialization() {
        PremiumPassenger premiumPassenger = new PremiumPassenger("Test Premium Passenger", 103);

        assertEquals("Test Premium Passenger", premiumPassenger.getName());
        assertEquals(103, premiumPassenger.getPassengerNumber());
    }

    // Add more test methods to thoroughly test PremiumPassenger class functionality
}
