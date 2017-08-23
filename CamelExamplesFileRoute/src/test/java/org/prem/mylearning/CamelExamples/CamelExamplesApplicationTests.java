package org.prem.mylearning.CamelExamples;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.NotifyBuilder;
import org.apache.camel.test.spring.CamelSpringBootRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

@RunWith(CamelSpringBootRunner.class)
@SpringBootTest
public class CamelExamplesApplicationTests {

	@Autowired
	private CamelContext camelContext;

	@Test
	public void contextLoads() {
		NotifyBuilder notify = new NotifyBuilder(camelContext).whenDone(1).create();
		assertTrue(notify.matches(10, TimeUnit.SECONDS));
	}

}
