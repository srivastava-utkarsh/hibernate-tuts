package com.tuts.main;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("bike")
public class TwoWheeler extends Vehicle{
    private String steeringHandle;

    public TwoWheeler() {
    }

    public TwoWheeler(String steeringHandle, String name) {
        super(name);
        this.steeringHandle = steeringHandle;
    }

    public String getSteeringHandle() {
        return steeringHandle;
    }

    public void setSteeringHandle(String steeringHandle) {
        this.steeringHandle = steeringHandle;
    }
    
}
