package Train;

import java.util.Arrays;
import java.util.List;

public class Customer {
    private long unixTimestamp,customerId;
           private String station;

    public Customer() {
    }

    public long getUnixTimestamp() {
        return unixTimestamp;
    }

    public void setUnixTimestamp(long unixTimestamp) {
        this.unixTimestamp = unixTimestamp;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }
    public List<Integer> getListZoneForStation(String station)
    {
        switch (station)
        {
            case "A":
                return Arrays.asList(1);

            case "B":
                return Arrays.asList(1);
            case "C":
                return Arrays.asList(3,2);

            case "D":
                return Arrays.asList(2);

            case "E":
                return Arrays.asList(3,2);

            case "F":
                return Arrays.asList(3,4);

            case "G":
                return Arrays.asList(4);

            case "H":
                return Arrays.asList(4);
            case "I":
                return Arrays.asList(4);


        }
        return  null;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "unixTimestamp=" + unixTimestamp +
                ", customerId=" + customerId +
                ", station='" + station + '\'' +
                '}';
    }
}
