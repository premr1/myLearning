package org.prem.mylearning.CamelExamples;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by prem on 22/08/2017.
 */
@Component
public class SampleCamelRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer:hello?period={{timer.period}}")
                .transform(method("myBean","saySomething"))
                .to("stream:out");
    }
}
