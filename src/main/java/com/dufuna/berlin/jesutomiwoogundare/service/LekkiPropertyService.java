package com.dufuna.berlin.jesutomiwoogundare.service;

import com.dufuna.berlin.jesutomiwoogundare.model.LekkiProperty;

public interface LekkiPropertyService {

    void saveProperty(LekkiProperty property);

    LekkiProperty getProperty(long propertyId);
}