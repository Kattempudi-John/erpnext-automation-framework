package com.erpTechnologies.models;

public class CustomerValidationScenario {

    private final Customer customer;
    private final String expectedField;

    public CustomerValidationScenario(
            Customer customer,
            String expectedField
    ) {
        this.customer = customer;
        this.expectedField = expectedField;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getExpectedField() {
        return expectedField;
    }
}
