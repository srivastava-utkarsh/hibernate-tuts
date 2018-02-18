package com.tuts.main;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("car")
public class FourWheeler extends Vehicle{
    private String steeringWheel;

    public FourWheeler() {
    }

    public FourWheeler(String steeringWheel, String name) {
        super(name);
        this.steeringWheel = steeringWheel;
    }

    public String getSteeringWheel() {
        return steeringWheel;
    }

    public void setSteeringWheel(String steeringWheel) {
        this.steeringWheel = steeringWheel;
    }
    
}
