package com.dufuna.berlin.jesutomiwoogundare.service;

import com.dufuna.berlin.jesutomiwoogundare.model.LekkiProperty;

public class MockLekkiPropertyService implements LekkiPropertyService {

    private LekkiProperty property;

    @Override
    public void saveProperty(LekkiProperty property) {
        System.out.println("MockLekkiPropertyService.saveProperty called");
        this.property = property;
    }

    @Override
    public LekkiProperty getProperty(long propertyId) {
        System.out.println("MockLekkiPropertyService.getProperty called");
        return property;
    }
}