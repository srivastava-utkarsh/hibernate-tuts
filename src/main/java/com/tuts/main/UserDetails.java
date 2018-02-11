package com.tuts.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "user_details")
public class UserDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String name;
    
    private String email;
    
    @ElementCollection
    @JoinTable(name = "user_address" , joinColumns = @JoinColumn(name = "user_detail_id"))
    @GenericGenerator(name = "hilo-gen" , strategy = "hilo")
    @CollectionId(columns = {@Column(name = "address_id")} , generator = "hilo-gen" , type = @Type(type = "long"))
    private Collection<Address> listOfAddresses = new ArrayList<>();

    public UserDetails() {
    }

    public UserDetails(String name, String email, Collection<Address> address) {
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

    public Collection<Address> getAddress() {
        return listOfAddresses;
    }

    public void setAddress(Collection<Address> address) {
        this.listOfAddresses = address;
    }

    @Override
    public String toString() {
        return "UserDetails[ id : "+id+" ,, email : "+email+" ,, address :"+listOfAddresses+" ]";
    }
    
    
}
