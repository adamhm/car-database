package com.playground.cardatabase.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Owner {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ownerid;
    
    private String firstName;
    private String lastName;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private List<Car> cars;
    
    public Owner() {
    }
    
    public Owner(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
