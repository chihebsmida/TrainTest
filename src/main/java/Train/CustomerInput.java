package Train;

import java.util.ArrayList;

public class CustomerInput {
    private ArrayList<Customer> taps;

    public ArrayList<Customer> getTaps() {
        return taps;
    }

    public void setTaps(ArrayList<Customer> taps) {
        this.taps = taps;
    }

    @Override
    public String toString() {
        return "CustomerInput{" +
                "taps=" + taps +
                '}';
    }

}
