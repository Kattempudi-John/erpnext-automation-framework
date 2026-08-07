package com.erpTechnologies.models;

public class Customer {

    private final String customerName;
    private final String customerType;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String mobileNumber;
    private final String addressLine1;
    private final String addressLine2;
    private final String city;
    private final String state;
    private final String zipCode;
    private final String country;


    private Customer(String customerName, String customerType, String firstName, String lastName, String email, String mobileNumber, String addressLine1, String addressLine2, String city, String state, String zipCode, String country) {
        this.customerName = customerName;
        this.customerType = customerType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerType() {
        return customerType;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCountry(){
        return country;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Builder toBuilder(){
        return new Builder(this);
    }

    public static class Builder {
        private String customerName;
        private String customerType;
        private String firstName;
        private String lastName;
        private String email;
        private String mobileNumber;
        private String addressLine1;
        private String addressLine2;
        private String city;
        private String state;
        private String zipCode;
        private String country;

        private Builder(){

        }

        private Builder(Customer customer){
            this.customerName= customer.customerName ;
            this.customerType = customer.customerType;
            this.firstName = customer.firstName;
            this.lastName = customer.lastName;
            this.email = customer.email;
            this.mobileNumber = customer.mobileNumber;
            this.addressLine1 = customer.addressLine1;
            this.addressLine2 = customer.addressLine2;
            this.city = customer.city;
            this.state = customer.state;
            this.country = customer.country;
            this.zipCode = customer.zipCode;
        }
        public Builder customerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public Builder customerType(String customerType){
            this.customerType = customerType;
            return this;
        }

        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }
        public Builder email(String email){
            this.email = email;
            return this;
        }
        public Builder mobileNumber(String mobileNumber){
            this.mobileNumber = mobileNumber;
            return this;
        }
        public Builder addressLine1(String addressLine1){
            this.addressLine1 = addressLine1;
            return this;
        }
        public Builder addressLine2(String addressLine2){
            this.addressLine2 = addressLine2;
            return this;
        }
        public Builder city(String city){
            this.city = city;
            return this;
        }
        public Builder state(String state){
            this.state = state;
            return this;
        }

        public Builder zipCode(String zipCode){
            this.zipCode = zipCode;
            return this;
        }

        public Builder country(String country){
            this.country = country;
            return this;
        }

        public Customer build() {
            return new Customer(
                    customerName,
                    customerType,
                    firstName,
                    lastName,
                    email,
                    mobileNumber,
                    addressLine1,
                    addressLine2,
                    city,
                    state,
                    zipCode,
                    country
            );
        }

    }

}

