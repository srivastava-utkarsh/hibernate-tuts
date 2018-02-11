package com.tuts.main;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_details")
public class UserDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String name;
    
    private String email;
    
    @ElementCollection
    private Set<Address> listOfAddresses = new HashSet<>();

    public UserDetails() {
    }

    public UserDetails(String name, String email, Set<Address> address) {
        this.name = name;
        this.email = email;
        this.listOfAddresses = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Address> getAddress() {
        return listOfAddresses;
    }

    public void setAddress(Set<Address> address) {
        this.listOfAddresses = address;
    }

    @Override
    public String toString() {
        return "UserDetails[ id : "+id+" ,, email : "+email+" ,, address :"+listOfAddresses+" ]";
    }
    
    
}
