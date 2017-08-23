package org.prem.mylearning.CamelExamples.processor;

import org.apache.camel.Exchange;
import org.prem.mylearning.CamelExamples.domain.Employee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.StringTokenizer;

/**
 * Created by prem on 23/08/2017.
 */
public class CustomStreamProcessor implements org.apache.camel.Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE;
        String sendString = exchange.getIn().getBody(String.class);
        StringTokenizer tokenizer =new StringTokenizer(sendString,",");
        Employee employee =new Employee();

        while(tokenizer.hasMoreElements()){

            employee.setFirstName((String)tokenizer.nextElement());
            employee.setLastName((String)tokenizer.nextElement());
            //employee.setDateOfBirth(LocalDate.parse((String)tokenizer.nextElement(),dateTimeFormatter));
        }
        exchange.getIn().setBody(employee);
    }
}
