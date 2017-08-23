package org.prem.mylearning.CamelExamples.domain;

import java.time.LocalDate;

/**
 * Created by prem on 23/08/2017.
 */
public class Employee {

    private String firstName;
    private String lastName;
    //private LocalDate dateOfBirth;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

 /*   public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }*/
}
