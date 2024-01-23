
import java.util.ArrayList;
import java.util.List;

// Passenger class
abstract class Passenger {
    private String name;
    private int passengerNumber;
    private List<Activity> activities;

    public Passenger(String name, int passengerNumber) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.activities = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void signUpForActivity(Activity activity, TravelPackage travelPackage) {
        // Check if the activity has available capacity
        if (activity.getCapacity() > 0) {
            if (!activities.contains(activity)) {
                activities.add(activity);
                activity.decreaseCapacity();
                travelPackage.addPassenger(this);
            } else {
                System.out.println("Passenger is already signed up for this activity.");
            }
        } else {
            System.out.println("This activity is already full.");
        }
    }
}