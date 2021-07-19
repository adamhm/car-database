package com.playground.cardatabase.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Owner {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ownerid;
    
    private String firstName;
    private String lastName;
    
    public Owner() {
    }
    
    public Owner(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
