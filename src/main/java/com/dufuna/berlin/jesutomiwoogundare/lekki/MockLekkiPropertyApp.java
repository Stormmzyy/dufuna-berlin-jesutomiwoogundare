package com.dufuna.berlin.jesutomiwoogundare.lekki;

import com.dufuna.berlin.jesutomiwoogundare.model.LekkiProperty;
import com.dufuna.berlin.jesutomiwoogundare.service.LekkiPropertyService;
import com.dufuna.berlin.jesutomiwoogundare.service.MockLekkiPropertyService;

import java.time.LocalDate;

public class MockLekkiPropertyApp {

    public static void main(String[] args) {
        LekkiProperty property = new LekkiProperty();
        property.setPropertyId(1L);
        property.setAddress("12 Admiralty Way, Lekki Phase 1, Lagos");
        property.setType("Duplex");
        property.setNoOfBedrooms(4);
        property.setNoOfSittingRooms(2);
        property.setNoOfKitchens(1);
        property.setNoOfBathrooms(4);
        property.setNoOfToilets(5);
        property.setOwner("Jesutomiwo Ogundare");
        property.setDescription("Fully detached duplex with a boys' quarters");
        property.setValidFrom(LocalDate.of(2026, 1, 1));
        property.setValidTo(LocalDate.of(2027, 12, 31));

        LekkiPropertyService service = new MockLekkiPropertyService();

        service.saveProperty(property);

        LekkiProperty retrieved = service.getProperty(1L);
        System.out.println(retrieved);
    }
}