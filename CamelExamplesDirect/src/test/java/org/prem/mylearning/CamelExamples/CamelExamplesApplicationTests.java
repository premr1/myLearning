package org.prem.mylearning.CamelExamples;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.apache.camel.test.spring.CamelSpringBootRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@RunWith(CamelSpringBootRunner.class)
@SpringBootTest
public class CamelExamplesApplicationTests extends CamelTestSupport{


    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new SampleCamelRouter();
    }

    @Test
    public void sampleRouteTest() throws InterruptedException {

        template.sendBody("direct:sampleInput","Helo");
        File file = new File("sampleOutput");
        assertTrue(file.isDirectory());
    }
}

