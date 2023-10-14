package com.hin.spatial.postgis.model;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Point;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "atm")
public class Atm {
    @Id
    private String address;
    private double latitude;
    private double longitude;
    private boolean allDay;
    public boolean wheelchairCapability;
    public boolean wheelchairActivity;
    public boolean blindCapability;
    public boolean blindActivity;
    public boolean nfcForBankCardsCapability;
    public boolean nfcForBankCardActivity;
    public boolean qrReadCapability;
    public boolean qrReadActivity;
    public boolean supportUsdCapability;
    public boolean supportUsdActivity;
    public boolean supportsChargeRubCapability;
    public boolean supportChargeRubActivity;
    public boolean supportsEurCapability;
    public boolean supportEurActivity;
    public boolean supportsRubCapability;
    public boolean supportRubActivity;
}
