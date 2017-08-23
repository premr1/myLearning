package org.prem.mylearning.CamelExamples;

import org.apache.camel.Exchange;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by prem on 23/08/2017.
 */
public class CamelExampleProcessor implements org.apache.camel.Processor {

    String newValue ="";
    @Override
    public void process(Exchange exchange) throws Exception {


        File file = new File((String) exchange.getIn().getHeaders().get("CamelFilePath"));
        System.out.println("File is"+file);
        String readLine = null;
        if(file !=null) {
            System.out.println("File is 1111"+file);
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            while((readLine = reader.readLine())!=null) {
                String oldValue = readLine;
                System.out.println("--------------oldValue is"+oldValue);
                newValue.concat(oldValue.replaceAll(":",",")).concat("\n");
                System.out.println("--------------newValue is"+newValue);
                exchange.getIn().setBody(newValue);
            }


        }

    }
}
