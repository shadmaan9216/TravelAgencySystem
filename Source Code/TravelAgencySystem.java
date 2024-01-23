
// Main class for testing
public class TravelAgencySystem {
    public static void main(String[] args) {
        // Sample usage
        TravelPackage europeTour = new TravelPackage("Europe Tour", 20);

        Destination paris = new Destination("Paris");
        paris.addActivity(new Activity("Eiffel Tower Tour", "Visit Eiffel Tower", 50.0, 10));
        paris.addActivity(new Activity("Louvre Museum", "Explore Louvre Museum", 40.0, 15));

        Destination rome = new Destination("Rome");
        rome.addActivity(new Activity("Colosseum Tour", "Visit Colosseum", 60.0, 12));

        europeTour.addDestination(paris);
        europeTour.addDestination(rome);

        StandardPassenger john = new StandardPassenger("John", 101, 500.0);
        GoldPassenger anna = new GoldPassenger("Anna", 102, 700.0);
        PremiumPassenger emily = new PremiumPassenger("Emily", 103);

        john.signUpForActivity(paris.getActivityByName("Eiffel Tower Tour"), europeTour);
        anna.signUpForActivity(paris.getActivityByName("Louvre Museum"), europeTour);
        emily.signUpForActivity(paris.getActivityByName("Eiffel Tower Tour"), europeTour);

        europeTour.printItinerary();
        europeTour.printPassengerList();

        System.out.println("\nDetails of John:");
        europeTour.printIndividualPassengerDetails(john);
        System.out.println("\nDetails of Anna:");
        europeTour.printIndividualPassengerDetails(anna);
        System.out.println("\nDetails of Emily:");
        europeTour.printIndividualPassengerDetails(emily);

        System.out.println("\nAvailable Activities:");
        europeTour.printAvailableActivities();
    }

}
