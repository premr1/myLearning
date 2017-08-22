package org.prem.mylearning.CamelExamples;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by prem on 22/08/2017.
 */
@Component
public class SampleFromFTPServerCamelRouter extends RouteBuilder {



    @Override
    public void configure() throws Exception {
        from("{{ftp.server}}")
                .to("stream:out")
                .log("Downloaded file @{file:name} complete");
    }
}
