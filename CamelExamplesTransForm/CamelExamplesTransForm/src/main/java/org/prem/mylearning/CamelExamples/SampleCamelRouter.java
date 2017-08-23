package org.prem.mylearning.CamelExamples;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by prem on 22/08/2017.
 */
@Component
public class SampleCamelRouter extends RouteBuilder {

  //Direct component mostly used for testing producers

    @Override
    public void configure() throws Exception {
        from("file:sampleInput?noop=true")
                .process(new CamelExampleProcessor())
                .log("Received Message ${body} and Header is ${headers}")
                .to("file:sampleOutput?fileName=output.txt");
    }
}
