package Train;

import java.util.ArrayList;

public class CustomerBill {
    private long customerId,totalCostInCents;
    private ArrayList<Trip>trips;

    public CustomerBill() {
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getTotalCostInCents() {
        return totalCostInCents;
    }

    public void setTotalCostInCents(long totalCostInCents) {
        this.totalCostInCents = totalCostInCents;
    }

    public ArrayList<Trip> getTrips() {
        return trips;
    }

    public void setTrips(ArrayList<Trip> trips) {
        this.trips = trips;
    }

    @Override
    public String toString() {
        return "CustomerBill{" +
                "customerId=" + customerId +
                ", totalCostInCents=" + totalCostInCents +
                ", trips=" + trips +
                '}';
    }



}
