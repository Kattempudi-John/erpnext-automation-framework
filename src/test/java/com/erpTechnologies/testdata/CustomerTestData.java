package com.erpTechnologies.testdata;

import com.erpTechnologies.models.Customer;

public final class CustomerTestData {

    private CustomerTestData(){

    }

    public static Customer validCustomer() {

        return Customer.builder()
                .customerName("John Doe")
                .customerType("Individual")
                .firstName("John")
                .lastName("Doe")
                .email("john.doe@example.com")
                .mobileNumber("+919876543210")
                .addressLine1("123 MG Road")
                .addressLine2("Indiranagar")
                .city("Bengaluru")
                .state("Karnataka")
                .country("India")
                .zipCode("560038")
                .build();
    }

    public static Customer customerWithoutEmail() {

        return validCustomer()
                .toBuilder()
                .email("")
                .build();
    }
}
