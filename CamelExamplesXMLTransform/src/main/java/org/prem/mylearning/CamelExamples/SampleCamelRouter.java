package org.prem.mylearning.CamelExamples;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.XStreamDataFormat;
import org.prem.mylearning.CamelExamples.domain.Employee;
import org.prem.mylearning.CamelExamples.processor.CustomStreamProcessor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prem on 22/08/2017.
 */
@Component
public class SampleCamelRouter extends RouteBuilder {

  //Direct component mostly used for testing producers

    @Override
    public void configure() throws Exception {
        from("direct:sampleInput")
                .process(new CustomStreamProcessor())
                .marshal(populateStreamDef())
                .log("Received Message ${body} and Header is ${headers}")
                .to("file:sampleOutput?fileName=output.txt");

        from("file:sampleOutput?fileName=output.txt")
                .unmarshal(populateunMarshallStreamDef())
                .to("mock:output");
    }

    private XStreamDataFormat populateunMarshallStreamDef() {
        Map<String, String> reference = new HashMap<String, String>();
        reference.put("employee", Employee.class.getName());

        XStreamDataFormat xstreamDataFormat = new XStreamDataFormat();
        xstreamDataFormat.setAliases(reference);
        xstreamDataFormat.setPermissions(Employee.class.getName());
        return xstreamDataFormat;
    }


    private XStreamDataFormat populateStreamDef() {

        XStreamDataFormat xstreamDefinition = new XStreamDataFormat();

        Map<String, String> aliases = new HashMap<String, String>();

        aliases.put("employee", Employee.class.getName());

        xstreamDefinition.setAliases(aliases);

        return xstreamDefinition;
    }


}
