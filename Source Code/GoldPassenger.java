
// Gold Passenger class
class GoldPassenger extends Passenger {
    private double balance;

    public GoldPassenger(String name, int passengerNumber, double balance) {
        super(name, passengerNumber);
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public double getSignedUpPrice(Activity activity) {
        double discountedCost = activity.getCost() * 0.9; // 10% discount
        if (getBalance() >= discountedCost) {
            return discountedCost;
        } else {
            System.out.println("Insufficient balance to sign up for this activity.");
            return 0.0;
        }
    }
}