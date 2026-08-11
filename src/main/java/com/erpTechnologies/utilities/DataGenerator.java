package com.erpTechnologies.utilities;

import net.datafaker.Faker;
import java.util.UUID;

public final class DataGenerator {

    private static final Faker faker = new Faker();

    private DataGenerator() {

    }

    private static String uniqueSuffix() {
        return UUID.randomUUID()
                .toString()
                .substring(0, 7);
    }

    public static String firstName() {
        return faker.name().firstName();
    }

    public static String lastName() {
        return faker.name().lastName();
    }

    public static String addressLine() {
        return faker.address().streetAddressNumber();
    }

    public static String addressLine2() {
        return faker.address().fullAddress();
    }

    public static String email() {
        String firstName = faker.name()
                .firstName()
                .toLowerCase();
        return firstName + "_" + uniqueSuffix() + "@test.com";
    }

    public static String mobileNumber() {
        long number =
                9000000000L + faker.number()
                        .numberBetween(0L, 999999999L);

        return String.valueOf(number);
    }

    public static String uniqueCustomerName() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();

        return firstName + lastName + uniqueSuffix();
    }

    public static String city() {
        return "Bengaluru";
    }

    public static String state() {
        return "Karnataka";
    }

    public static String country() {
        return "India";
    }

    public static String zipcode() {
        return "560038";
    }

}


//    public static String uniqueCustomerName(){
//        int number = ThreadLocalRandom.current()
//                .nextInt(1000, 10000);
//
//        return "Customer" + number;
//    }
//
//    public static String uniqueEmail(){
//        int number = ThreadLocalRandom.current()
//                .nextInt(1000, 10000);
//
//        return "customer" + number + "@test.com";
//    }
//
//    public static String uniqueMobileNumber(){
//        long number = ThreadLocalRandom.current()
//                .nextLong(1000000000L, 10000000000L);
//
//        return String.valueOf(number);
//    }}
