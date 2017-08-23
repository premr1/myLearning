package org.prem.mylearning.CamelExamples.bean;

/**
 * Created by prem on 23/08/2017.
 */
public class myBean {


    public String map(String str){

        return str.replaceAll(":",",");
    }
}
