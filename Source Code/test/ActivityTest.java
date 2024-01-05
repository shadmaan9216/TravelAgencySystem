
import static org.junit.Assert.assertEquals;

import org.junit.*;

public class ActivityTest {

    @Test
    public void testActivityInitialization() {
        Activity activity = new Activity("Test Activity", "Description", 50.0, 10);

        assertEquals("Test Activity", activity.getName());
        assertEquals("Description", activity.getDescription());
        assertEquals(50.0, activity.getCost(), 0.001); // Using delta for double comparison
        assertEquals(10, activity.getCapacity());
    }

    @Test
    public void testDecreaseCapacity() {
        Activity activity = new Activity("Test Activity", "Description", 50.0, 10);

        assertEquals(10, activity.getCapacity());
        activity.decreaseCapacity();
        assertEquals(9, activity.getCapacity());
    }

    @Test
    public void testActivityCapacityCannotBeNegative() {
        Activity activity = new Activity("Test Activity", "Description", 50.0, 0);

        assertEquals(0, activity.getCapacity());
        activity.decreaseCapacity();
        assertEquals(0, activity.getCapacity()); // Capacity cannot be negative
    }

    // Add more test methods to thoroughly test Activity class functionality
}
