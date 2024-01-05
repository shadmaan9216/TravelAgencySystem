import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.*;

public class DestinationTest {

    @Test
    public void testDestinationInitialization() {
        Destination destination = new Destination("Test Destination");

        assertEquals("Test Destination", destination.getName());
        assertNotNull(destination.getActivities());
        assertTrue(destination.getActivities().isEmpty());
    }

    @Test
    public void testAddActivityToDestination() {
        Destination destination = new Destination("Test Destination");
        Activity activity = new Activity("Test Activity", "Description", 50.0, 10);

        assertEquals(0, destination.getActivities().size());

        destination.addActivity(activity);

        assertEquals(1, destination.getActivities().size());
        assertTrue(destination.getActivities().contains(activity));
    }

    @Test
    public void testGetActivityByName() {
        Destination destination = new Destination("Test Destination");
        Activity activity1 = new Activity("Activity 1", "Description 1", 50.0, 10);
        Activity activity2 = new Activity("Activity 2", "Description 2", 60.0, 15);

        destination.addActivity(activity1);
        destination.addActivity(activity2);

        assertEquals(activity1, destination.getActivityByName("Activity 1"));
        assertEquals(activity2, destination.getActivityByName("Activity 2"));
        assertNull(destination.getActivityByName("Non-existent Activity"));
    }

    // Add more test methods to thoroughly test Destination class functionality
}
