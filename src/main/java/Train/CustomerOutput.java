package Train;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomerOutput {
    private ArrayList<CustomerBill> customerSummaries;

    public CustomerOutput() {
    }

    public ArrayList<CustomerBill> getCustomerSummaries()
    {
        return customerSummaries;
    }


    public void setCustomerSummaries(ArrayList<CustomerBill> customerSummaries) {
        this.customerSummaries = customerSummaries;
    }

    @Override
    public String toString() {
        return "CustomerOutput{" +
                "customerSummaries=" + customerSummaries +
                '}';
    }
/***
 this method will initialize the pricing of the trips in matrix
 ***/
    public long[][] generateMatPricing()
    {
        long mat[][]=new long[4][4];
        mat[0][0]=240; mat[0][1]=240; mat[0][2]=280; mat[0][3]=300;
        mat[1][0]=240; mat[1][1]=240; mat[1][2]=280; mat[1][3]=300;
        mat[2][0]=280; mat[2][1]=280; mat[2][2]=200; mat[2][3]=200;
        mat[3][0]=300; mat[3][1]=300; mat[3][2]=200; mat[3][3]=200;
        return mat;
    }

    /***
     *
     *
     * @param startsZone : all possible starting Zone
     * @param endsZone  :  all possible ending Zone
     * @return  the start zone and the end zone with the lowest price
     */
    public List<Integer> getZone(List<Integer> startsZone,List<Integer> endsZone )
    {

        if(startsZone.size()==1&&endsZone.size()==1)
            return  Arrays.asList(startsZone.get(0),endsZone.get(0));
        else {
            long[][]mat=generateMatPricing();
            List<Integer> result = new ArrayList<>(2);
            int start=startsZone.get(0);
            int ends=endsZone.get(0);
            long min = mat[start-1][ends-1];

            for(int i:startsZone)
                for (int j:endsZone)
                {
                    if(mat[i-1][j-1]<min)
                    {
                        min=mat[i-1][j-1];
                        start=i;
                        ends=j;
                    }
                }
            result.add(start);
            result.add(ends);
            return result;
        }

    }

    /***
     *
     * @param customerInput : the object correspond to  the InputFile
     * @return : the object correspond to  the OutputFile
     */
    public CustomerOutput GenerateBill(CustomerInput customerInput)
    {
        long[][]mat=generateMatPricing();

        CustomerOutput customerOutput = new CustomerOutput();
        ArrayList<CustomerBill> customerSummaries = new ArrayList<>();
        for (Customer customer : customerInput.getTaps())
        {
            boolean exist=false;
            for (CustomerBill customerBill : customerSummaries) {

                if (customerBill.getCustomerId() == customer.getCustomerId()) {
                  //in this case the customer have only a  start Station ,
                  // so we will set the end Station to the current trip and all the other JSON attributes
                        if (customerBill.getTrips().get(customerBill.getTrips().size() - 1).getStartedJourneyAt() > 0 && customerBill.getTrips().get(customerBill.getTrips().size() - 1).getStationEnd() == null)
                        {
                        List<Integer> start = customer.getListZoneForStation(customerBill.getTrips().get(customerBill.getTrips().size() - 1).getStationStart());
                        List<Integer> ends = customer.getListZoneForStation(customer.getStation());
                        List<Integer> result_zone = getZone(start, ends);
                        customerBill.getTrips().get(customerBill.getTrips().size() - 1).setStationEnd(customer.getStation());
                        customerBill.getTrips().get(customerBill.getTrips().size() - 1).setZoneFrom(result_zone.get(0));
                        customerBill.getTrips().get(customerBill.getTrips().size() - 1).setZoneTo(result_zone.get(1));
                        customerBill.getTrips().get(customerBill.getTrips().size() - 1).setCostInCents(mat[result_zone.get(0)-1][result_zone.get(1)-1]);
                        customerBill.setTotalCostInCents(customerBill.getTotalCostInCents()+mat[result_zone.get(0)-1][result_zone.get(1)-1]);

                    }
                        //in this case we will add a new Trip to the current Customer
                        else
                        {
                        Trip trip = new Trip();
                        trip.setStartedJourneyAt(customer.getUnixTimestamp());
                        trip.setStationStart(customer.getStation());
                        customerBill.getTrips().add(trip);
                    }
                    exist = true;
                    break;
                }
            }
//in this case we will add a new customer object to our outputFile
            if(!exist)
                {
                    CustomerBill newCustomerBill = new CustomerBill();
                    newCustomerBill.setCustomerId(customer.getCustomerId());
                    newCustomerBill.setTotalCostInCents(0);
                    ArrayList<Trip> trips = new ArrayList<>();
                    Trip trip = new Trip();
                    trip.setStartedJourneyAt(customer.getUnixTimestamp());
                    trip.setStationStart(customer.getStation());
                    trips.add(trip);
                    newCustomerBill.setTrips(trips);
                    customerSummaries.add(newCustomerBill);
                }
            }
        customerOutput.setCustomerSummaries(customerSummaries);
        return customerOutput;

        }



}
