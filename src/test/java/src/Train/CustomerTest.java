package src.Train;

import Train.Customer;
import Train.CustomerInput;
import Train.CustomerOutput;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;


public class CustomerTest {

    @Test
    public   void customerTest(){
      Customer customer=new Customer();
       List<Integer> expected=new ArrayList<>();
       expected.add(1);
        assertEquals(expected,customer.getListZoneForStation("A"));
    }
    @Test
    public  void CustomerOutputTestZone()
    {
        CustomerOutput customerOutput=new CustomerOutput();
        Customer customer=new Customer();
        List<Integer> start= customer.getListZoneForStation("D");
        List<Integer> ends= customer.getListZoneForStation("F");
        List<Integer>expected=new ArrayList<>(2);
        expected.add(2);expected.add(3);
        assertEquals(expected,customerOutput.getZone(start,ends));
        expected=new ArrayList<>();
        start=customer.getListZoneForStation("C");
        ends=customer.getListZoneForStation("E");
        expected.add(3);expected.add(3);
        assertEquals(expected,customerOutput.getZone(start,ends));
    }

    @Test
    public  void CustomerOutputTestBill() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            CustomerInput customerInput = objectMapper.readValue(new File("CandidateInputExample.txt"), CustomerInput.class);
           CustomerOutput customerOutputExpected=objectMapper.readValue(new File("CandidateOutputExample.txt"), CustomerOutput.class);
            CustomerOutput customerOutput=new CustomerOutput();
            customerOutput=customerOutput.GenerateBill(customerInput);
            assertEquals(customerOutputExpected.toString(),customerOutput.toString());


        }
        catch (Exception exception)
        {
            Assert.fail("Exception " + exception);
        }

    }

}
