package com.erpTechnologies.dataproviders;

import com.erpTechnologies.models.CustomerValidationScenario;
import com.erpTechnologies.testdata.CustomerTestData;
import org.testng.annotations.DataProvider;

public class CustomerDataProvider {

    private CustomerDataProvider() {
    }

    @DataProvider(name = "validCustomers")
    public static Object[][] validCustomers() {

        return new Object[][]{
                {CustomerTestData.uniqueCompanyCustomer()},
                {CustomerTestData.uniqueIndividualCustomer()}
        };
    }

    @DataProvider(name = "customerValidationScenarios")
    public static Object[][] customerValidationScenarios() {

        return new Object[][]{
                {
                        new CustomerValidationScenario(
                                CustomerTestData.customerWithoutName(),
                                "Customer Name"
                        )
                },
                {
                        new CustomerValidationScenario(
                                CustomerTestData.customerWithoutEmail(),
                                "Email"
                        )
                }
        };
    }


}
