package com.erpTechnologies.tests.customer;

import com.erpTechnologies.models.Customer;
import com.erpTechnologies.pages.CustomerPage;
import com.erpTechnologies.pages.HomePage;
import com.erpTechnologies.testdata.CustomerTestData;
import com.erpTechnologies.tests.BaseTest;
import org.testng.annotations.Test;

public class CustomerCreationTest extends BaseTest {

    @Test
    public void shouldCreateValidCustomer(){

        Customer customer = CustomerTestData.validCustomer();

        HomePage homePage =
                authenticationWorkflow.loginAsAdmin();

        CustomerPage customerPage =
                homePage.openCustomerPage();

        customerPage.clickAddCustomer();

        customerPage
                .fillCustomerDetails(customer)
                .clickSave();
    }
}
