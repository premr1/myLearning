package org.prem.mylearning.CamelExamples;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by prem on 22/08/2017.
 */
@Component
public class SampleFromFilServerCamelRouter extends RouteBuilder {


    // camel route has two parts from & to
    //they have component/uri .Here we have file component
    //which will mention about uri path
    //for file a default schedule poll -fixed delay with initial delay of 1000 and delay of 500 ms
    @Override
    public void configure() throws Exception {

       /* from("file:data/input?noop=true")
                .to("file:data/output")
                .log("Downloaded file @{file:name} complete");*/

       //with no option.camel will back it up in .camel directory
        from("file:data/input")
                .to("file:data/output")
                .log("Downloaded file @{file:name} complete");

    }


}
