import java.util.ArrayList;
import java.util.List;
class TravelPackage {
    private String name;
    private int passengerCapacity;
    private List<Destination> itinerary;
    private List<Passenger> passengers;

    public TravelPackage(String name, int passengerCapacity) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.itinerary = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public List<Destination> getItinerary() {
        return itinerary;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void addDestination(Destination destination) {
        this.itinerary.add(destination);
    }

    public void addPassenger(Passenger passenger) {
        if (passengers.size() < passengerCapacity) {
            this.passengers.add(passenger);
        } else {
            System.out.println("Cannot add more passengers. The travel package is full.");
        }
    }

    // Other methods...

    public void printItinerary() {
        System.out.println("Travel Package: " + name);
        for (Destination destination : itinerary) {
            System.out.println("Destination: " + destination.getName());
            for (Activity activity : destination.getActivities()) {
                System.out.println("- Activity: " + activity.getName() +
                        ", Description: " + activity.getDescription() +
                        ", Cost: " + activity.getCost() +
                        ", Capacity: " + activity.getCapacity());
            }
        }
    }

    public void printPassengerList() {
        System.out.println("Passenger List for Travel Package: " + name);
        System.out.println("Passenger Capacity: " + passengerCapacity);
        System.out.println("Number of Passengers Enrolled: " + passengers.size());
        for (Passenger passenger : passengers) {
            System.out.println("- Passenger: " + passenger.getName() +
                    ", Passenger Number: " + passenger.getPassengerNumber());
        }
    }

    public void printIndividualPassengerDetails(Passenger passenger) {
        System.out.println("Passenger Details:");
        System.out.println("Name: " + passenger.getName());
        System.out.println("Passenger Number: " + passenger.getPassengerNumber());

        if (passenger instanceof StandardPassenger) {
            StandardPassenger standardPassenger = (StandardPassenger) passenger;
            System.out.println("Balance: " + standardPassenger.getBalance());
        }

        System.out.println("Activities Signed Up:");
        for (Activity activity : passenger.getActivities()) {
            Destination destination = getActivityDestination(activity);
            if (destination != null) {
                double pricePaid = getSignedUpPrice(passenger, activity);
                System.out.println("- Activity: " + activity.getName() +
                        ", Destination: " + destination.getName() +
                        ", Price Paid: " + pricePaid);
            }
        }
    }

    public void printAvailableActivities() {
        System.out.println("Available Activities:");
        for (Destination destination : itinerary) {
            System.out.println("Destination: " + destination.getName());
            for (Activity activity : destination.getActivities()) {
                if (activity.getCapacity() > 0) {
                    System.out.println("- Activity: " + activity.getName() +
                            ", Description: " + activity.getDescription() +
                            ", Cost: " + activity.getCost() +
                            ", Capacity Available: " + activity.getCapacity());
                }
            }
        }
    }

    private Destination getActivityDestination(Activity activity) {
        for (Destination destination : itinerary) {
            if (destination.getActivities().contains(activity)) {
                return destination;
            }
        }
        return null;
    }

    private double getSignedUpPrice(Passenger passenger, Activity activity) {
        double price = activity.getCost();

        if (passenger instanceof StandardPassenger) {
            StandardPassenger standardPassenger = (StandardPassenger) passenger;
            price = standardPassenger.getSignedUpPrice(activity);
        } else if (passenger instanceof GoldPassenger) {
            GoldPassenger goldPassenger = (GoldPassenger) passenger;
            price = goldPassenger.getSignedUpPrice(activity);
        }

        return price;
    }
}
