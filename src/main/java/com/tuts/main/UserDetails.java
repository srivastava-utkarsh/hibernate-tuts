package com.tuts.main;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
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
    
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "street" , column = @Column(name = "home_street")),
        @AttributeOverride(name = "city" , column = @Column(name = "home_city"))
    })
    private Address homeAddress;
    
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "street" , column = @Column(name = "office_street")),
        @AttributeOverride(name = "city" , column = @Column(name = "office_city"))
    })
    private Address officeAddress;

    public UserDetails() {
    }

    public UserDetails(String name, String email, Address homeAddress, Address officeAddress) {
        this.name = name;
        this.email = email;
        this.homeAddress = homeAddress;
        this.officeAddress = officeAddress;
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

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(Address officeAddress) {
        this.officeAddress = officeAddress;
    }
    
    @Override
    public String toString() {
        return "UserDetails[ id : "+id+" ,, email : "+email+" ,, homeAddress :"+ homeAddress+" ,, officeAddress : "+officeAddress+" ]";
    }
    
    
}
