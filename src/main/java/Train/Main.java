package Train;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
try{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter  the location of Input file information to generate the customers trips and total costings ...");
        String PathFileInput=scanner.next();
        ObjectMapper objectMapper = new ObjectMapper();
        CustomerInput customerInput = objectMapper.readValue(new File(PathFileInput), CustomerInput.class);
        String PathFileOutput="BillCustomers_"+new Date();
        CustomerOutput customerOutput=new CustomerOutput();
        ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
        customerOutput=customerOutput.GenerateBill(customerInput);
        File Output=new File(PathFileOutput);
        writer.writeValue(Output,customerOutput);
        System.out.println("file was successfully generated ");
        System.out.println("PathFile=="+Output.getAbsolutePath());




}

catch (Exception e)

{
    e.printStackTrace();
}
    }

}
