package com.hin.spatial.postgis.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "office")
public class Office {

    public Office() {

    }

    @Id
    public String salePointName;
    public String address;
    public String status;
    public String rko;
    public String officeType;
    public String salePointFormat;
    public String suoAvailability;
    public String hasRamp;
    public double latitude;
    public double longitude;
    public String metroStation;
    public int distance;
    public boolean kep;
    public boolean myBranch;

}
