package org.prem.mylearning.CamelExamples;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by prem on 22/08/2017.
 */
@Component
public class SampleCamelRouter extends RouteBuilder {

    //timer:name[?options] period-> generate periodic events every period milliseconds.
    // The stream: component provides access to the System.in,
    // System.out and System.err streams as well as allowing streaming of file ex file?fileName=/foo/bar.txt
    // and URL stream:url[?options]

    @Override
    public void configure() throws Exception {
        from("timer:hello?period={{timer.period}}")
                .transform(method("myBean","saySomething"))
                .to("stream:out");
    }
}
