package com.dufuna.berlin.jesutomiwoogundare.model;

import java.time.LocalDate;
import java.util.Objects;

public class LekkiProperty {

    private long propertyId;
    private String address;
    private String type;
    private int noOfBedrooms;
    private int noOfSittingRooms;
    private int noOfKitchens;
    private int noOfBathrooms;
    private int noOfToilets;
    private String owner;
    private String description;
    private LocalDate validFrom;
    private LocalDate validTo;

    public LekkiProperty() {
    }

    public long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(long propertyId) {
        this.propertyId = propertyId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNoOfBedrooms() {
        return noOfBedrooms;
    }

    public void setNoOfBedrooms(int noOfBedrooms) {
        this.noOfBedrooms = noOfBedrooms;
    }

    public int getNoOfSittingRooms() {
        return noOfSittingRooms;
    }

    public void setNoOfSittingRooms(int noOfSittingRooms) {
        this.noOfSittingRooms = noOfSittingRooms;
    }

    public int getNoOfKitchens() {
        return noOfKitchens;
    }

    public void setNoOfKitchens(int noOfKitchens) {
        this.noOfKitchens = noOfKitchens;
    }

    public int getNoOfBathrooms() {
        return noOfBathrooms;
    }

    public void setNoOfBathrooms(int noOfBathrooms) {
        this.noOfBathrooms = noOfBathrooms;
    }

    public int getNoOfToilets() {
        return noOfToilets;
    }

    public void setNoOfToilets(int noOfToilets) {
        this.noOfToilets = noOfToilets;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDate getValidTo() {
        return validTo;
    }

    public void setValidTo(LocalDate validTo) {
        this.validTo = validTo;
    }

    @Override
    public String toString() {
        return "LekkiProperty{" +
                "propertyId=" + propertyId +
                ", address='" + address + '\'' +
                ", type='" + type + '\'' +
                ", noOfBedrooms=" + noOfBedrooms +
                ", noOfSittingRooms=" + noOfSittingRooms +
                ", noOfKitchens=" + noOfKitchens +
                ", noOfBathrooms=" + noOfBathrooms +
                ", noOfToilets=" + noOfToilets +
                ", owner='" + owner + '\'' +
                ", description='" + description + '\'' +
                ", validFrom=" + validFrom +
                ", validTo=" + validTo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LekkiProperty that = (LekkiProperty) o;
        return propertyId == that.propertyId && noOfBedrooms == that.noOfBedrooms && noOfSittingRooms == that.noOfSittingRooms && noOfKitchens == that.noOfKitchens && noOfBathrooms == that.noOfBathrooms && noOfToilets == that.noOfToilets && Objects.equals(address, that.address) && Objects.equals(type, that.type) && Objects.equals(owner, that.owner) && Objects.equals(description, that.description) && Objects.equals(validFrom, that.validFrom) && Objects.equals(validTo, that.validTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(propertyId, address, type, noOfBedrooms, noOfSittingRooms, noOfKitchens, noOfBathrooms, noOfToilets, owner, description, validFrom, validTo);
    }
}

