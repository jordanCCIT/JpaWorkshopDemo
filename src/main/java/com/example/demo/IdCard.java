package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Random;

@Entity
public class IdCard {
    @Id@GeneratedValue
    private Long id;
    private String idNum;
    private String jobTitle;
    @OneToOne(mappedBy = "idCard")
    private Person person;

    public IdCard(String jobTitle) {
        this.jobTitle = jobTitle;
        this.idNum=generateId();
    }

    public IdCard() {
    }

    public String generateId(){
        Random x = new Random();
        return "S"+x.nextInt(50)+"E";
    }

    public Long getId() {
        return id;
    }

    public String getIdNum() {
        return idNum;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public Person getPerson() {
        return person;
    }
}
