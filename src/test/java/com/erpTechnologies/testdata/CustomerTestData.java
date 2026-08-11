package com.erpTechnologies.testdata;

import com.erpTechnologies.models.Customer;
import com.erpTechnologies.utilities.DataGenerator;

public final class CustomerTestData {

    private CustomerTestData(){

    }

    public static Customer uniqueCompanyCustomer() {

        return Customer.builder()
                .customerName(DataGenerator.uniqueCustomerName())
                .customerType("Company")
                .firstName(DataGenerator.firstName())
                .lastName(DataGenerator.lastName())
                .email(DataGenerator.email())
                .mobileNumber(DataGenerator.mobileNumber())
                .addressLine1(DataGenerator.addressLine())
                .addressLine2(DataGenerator.addressLine2())
                .city(DataGenerator.city())
                .state(DataGenerator.state())
                .country(DataGenerator.country())
                .zipCode(DataGenerator.zipcode())
                .build();
    }

    public static Customer uniqueIndividualCustomer(){
        return uniqueCompanyCustomer()
                .toBuilder()
                .customerType("Individual")
                .build();
    }

//    public static Customer customerWithoutEmail() {
//
//        return uniqueCustomer()
//                .toBuilder()
//                .email("")
//                .build();
//    }

//    valid customer
//    invalid customer
//    customer with unique email
//    customer with unique mobile
//    customer with a specific country
//    customer with a specific type
//    customer for negative testing
//    customer for regression
//    customer for different environments
}
