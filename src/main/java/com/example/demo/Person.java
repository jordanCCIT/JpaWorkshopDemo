package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Person {
    @Id@GeneratedValue
    private Long id;
    private String name;
    private int age;
    @OneToOne
    private IdCard idCard;

    public Person(String name, int age, IdCard idCard) {
        this.name = name;
        this.age = age;
        this.idCard = idCard;
    }

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public IdCard getIdCard() {
        return idCard;
    }
}
