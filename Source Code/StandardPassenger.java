

// Standard Passenger class
class StandardPassenger extends Passenger {
    private double balance;

    public StandardPassenger(String name, int passengerNumber, double balance) {
        super(name, passengerNumber);
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public double getSignedUpPrice(Activity activity) {
        if (getBalance() >= activity.getCost()) {
            return activity.getCost();
        } else {
            System.out.println("Insufficient balance to sign up for this activity.");
            return 0.0;
        }
    }
}