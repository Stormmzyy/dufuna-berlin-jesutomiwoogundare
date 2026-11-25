package com.dufuna.berlin.jesutomiwoogundare.practice;

import com.dufuna.berlin.jesutomiwoogundare.model.LekkiProperty;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class CollectionsPractice {

    public static void main(String[] args) {
        LekkiProperty p1 = createProperty(1L, "Duplex", "Ada Obi");
        LekkiProperty p2 = createProperty(2L, "Bungalow", "Tunde Bello");
        LekkiProperty p3 = createProperty(3L, "Apartment", "Ada Obi");

        listPractice(p1, p2, p3);
        hashSetPractice(p1, p2, p3);
        treeSetPractice(p1, p2, p3);
        mapPractice(p1, p2, p3);
        queuePractice(p1, p2, p3);
        stringPractice();
        objectPractice(p1);
        exceptionAndSystemPractice();
    }

    // List: ordered, allows duplicates, access by index
    private static void listPractice(LekkiProperty p1, LekkiProperty p2, LekkiProperty p3) {
        System.out.println("=== ArrayList ===");
        List<LekkiProperty> properties = new ArrayList<>();
        properties.add(p1);
        properties.add(p2);
        properties.add(p3);
        properties.add(p1); // duplicates are allowed in a List

        for (LekkiProperty p : properties) {
            System.out.println(p.getPropertyId() + " - " + p.getType());
        }
        System.out.println("Size: " + properties.size());
        System.out.println("Item at index 1: " + properties.get(1).getType());
        System.out.println();
    }

    // HashSet: no duplicates, uses equals() and hashCode()
    private static void hashSetPractice(LekkiProperty p1, LekkiProperty p2, LekkiProperty p3) {
        System.out.println("=== HashSet ===");
        Set<LekkiProperty> uniqueProperties = new HashSet<>();
        uniqueProperties.add(p1);
        uniqueProperties.add(p2);
        uniqueProperties.add(p3);

        LekkiProperty copyOfP1 = createProperty(1L, "Duplex", "Ada Obi");
        boolean added = uniqueProperties.add(copyOfP1);
        System.out.println("Was the copy of p1 added? " + added);
        System.out.println("Size: " + uniqueProperties.size());

        Set<String> owners = new HashSet<>();
        owners.add(p1.getOwner());
        owners.add(p2.getOwner());
        owners.add(p3.getOwner());
        System.out.println("Unique owners: " + owners);
        System.out.println();
    }

    // TreeSet: no duplicates, kept sorted
    private static void treeSetPractice(LekkiProperty p1, LekkiProperty p2, LekkiProperty p3) {
        System.out.println("=== TreeSet ===");
        Set<String> types = new TreeSet<>();
        types.add(p1.getType());
        types.add(p2.getType());
        types.add(p3.getType());
        types.add("Duplex"); // duplicate, ignored
        System.out.println("Sorted property types: " + types);
        System.out.println();
    }

    // HashMap: key to value pairs, unique keys
    private static void mapPractice(LekkiProperty p1, LekkiProperty p2, LekkiProperty p3) {
        System.out.println("=== HashMap ===");
        Map<Long, LekkiProperty> propertiesById = new HashMap<>();
        propertiesById.put(p1.getPropertyId(), p1);
        propertiesById.put(p2.getPropertyId(), p2);
        propertiesById.put(p3.getPropertyId(), p3);

        LekkiProperty found = propertiesById.get(2L);
        System.out.println("Property with ID 2: " + found.getType() + " owned by " + found.getOwner());
        System.out.println("Contains ID 5? " + propertiesById.containsKey(5L));

        for (Map.Entry<Long, LekkiProperty> entry : propertiesById.entrySet()) {
            System.out.println("ID " + entry.getKey() + " -> " + entry.getValue().getType());
        }
        System.out.println();
    }

    // Queue: first in, first out
    private static void queuePractice(LekkiProperty p1, LekkiProperty p2, LekkiProperty p3) {
        System.out.println("=== Queue ===");
        Queue<LekkiProperty> approvalQueue = new ArrayDeque<>();
        approvalQueue.offer(p1);
        approvalQueue.offer(p2);
        approvalQueue.offer(p3);

        System.out.println("Next in line: " + approvalQueue.peek().getType());
        while (!approvalQueue.isEmpty()) {
            LekkiProperty next = approvalQueue.poll();
            System.out.println("Approving property " + next.getPropertyId() + " (" + next.getType() + ")");
        }
        System.out.println();
    }

    // String: common methods
    private static void stringPractice() {
        System.out.println("=== String ===");
        String address = "12 Admiralty Way, Lekki Phase 1, Lagos";
        System.out.println("Upper case: " + address.toUpperCase());
        System.out.println("Length: " + address.length());
        System.out.println("Contains 'Lekki'? " + address.contains("Lekki"));
        System.out.println("Replace: " + address.replace("Lagos", "Lagos State"));

        String[] parts = address.split(", ");
        for (String part : parts) {
            System.out.println("Part: " + part.trim());
        }
        System.out.println();
    }

    // Object: every class inherits these methods
    private static void objectPractice(LekkiProperty p1) {
        System.out.println("=== Object ===");
        LekkiProperty copy = createProperty(1L, "Duplex", "Ada Obi");
        System.out.println("Class name: " + p1.getClass().getSimpleName());
        System.out.println("p1 == copy? " + (p1 == copy));          // different objects
        System.out.println("p1.equals(copy)? " + p1.equals(copy));  // same values
        System.out.println("Same hashCode? " + (p1.hashCode() == copy.hashCode()));
        System.out.println();
    }

    // Exception and System
    private static void exceptionAndSystemPractice() {
        System.out.println("=== Exception and System ===");
        long start = System.currentTimeMillis();

        try {
            int bedrooms = Integer.parseInt("four");
            System.out.println("Bedrooms: " + bedrooms);
        } catch (NumberFormatException e) {
            System.err.println("Could not read the number of bedrooms: " + e.getMessage());
        }

        long end = System.currentTimeMillis();
        System.out.println("Java version: " + System.getProperty("java.version"));
        System.out.println("Time taken: " + (end - start) + " ms");
    }

    private static LekkiProperty createProperty(long id, String type, String owner) {
        LekkiProperty property = new LekkiProperty();
        property.setPropertyId(id);
        property.setType(type);
        property.setOwner(owner);
        return property;
    }
}