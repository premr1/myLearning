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
        //this option uses log from camel
        /*from("file:data/input")
                .to("file:data/output")
                .log("Downloaded file @{body} complete Header is ${headers}");*/

        //with no option.camel will back it up in .camel directory
        //this uses log component directly
        from("file:data/input")
                .to("file:data/output")
                .to("log:?level=INFO&showBody=true&showHeaders=true");

    }
    //output of log
    //Exchange[ExchangePattern: InOnly, Headers: {breadcrumbId=ID-MacBook-Pro-lan-51117-1503460439168-0-1, CamelFileAbsolute=false, CamelFileAbsolutePath=/Users/prem/Downloads/Prepration/myLearning/CamelExamplesFileRoute/data/input/second.txt, CamelFileLastModified=1503459277000, CamelFileLength=0, CamelFileName=second.txt, CamelFileNameConsumed=second.txt, CamelFileNameOnly=second.txt, CamelFileNameProduced=data/output/second.txt, CamelFileParent=data/input, CamelFilePath=data/input/second.txt, CamelFileRelativePath=second.txt}, BodyType: org.apache.camel.component.file.GenericFile, Body: [Body is file based: GenericFile[second.txt]]]
    //Exchange[ExchangePattern: InOnly, Headers: {breadcrumbId=ID-MacBook-Pro-lan-51117-1503460439168-0-3, CamelFileAbsolute=false, CamelFileAbsolutePath=/Users/prem/Downloads/Prepration/myLearning/CamelExamplesFileRoute/data/input/try.txt, CamelFileLastModified=1503460037000, CamelFileLength=10, CamelFileName=try.txt, CamelFileNameConsumed=try.txt, CamelFileNameOnly=try.txt, CamelFileNameProduced=data/output/try.txt, CamelFileParent=data/input, CamelFilePath=data/input/try.txt, CamelFileRelativePath=try.txt}, BodyType: org.apache.camel.component.file.GenericFile, Body: [Body is file based: GenericFile[try.txt]]]



}
