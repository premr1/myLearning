package org.prem.mylearning.CamelExamples;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by prem on 22/08/2017.
 */
@Component("myBean")
public class SampleBean {

    @Value("${greeting}")
    private String say;

    public String saySomething(){
        return say;
    }
}
