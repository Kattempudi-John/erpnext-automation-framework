package com.erpTechnologies.tests.customer;

import com.erpTechnologies.models.Customer;
import com.erpTechnologies.pages.CustomerPage;
import com.erpTechnologies.pages.HomePage;
import com.erpTechnologies.testdata.CustomerTestData;
import com.erpTechnologies.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CustomerCreationTest extends BaseTest {

    @DataProvider(name = "customerData")
    public Object[][] customerData(){
        return new Object[][]{
                {CustomerTestData.uniqueCompanyCustomer()},
                {CustomerTestData.uniqueIndividualCustomer()}
        };
    }
    @Test(dataProvider = "customerData")
    public void shouldCreateValidCustomer(Customer customer){

        HomePage homePage =
                authenticationWorkflow.loginAsAdmin();

        CustomerPage customerPage =
                homePage.openCustomerPage();

//        Assert.assertTrue(customerPage.isCustomerPageLoaded());

        customerPage.clickAddCustomer();

        customerPage
                .fillCustomerDetails(customer)
                .clickSave();

        Assert.assertTrue(
                customerPage.isCustomerSaved(customer.getCustomerName()),
                "Customer was not saved successfully: "
                        + customer.getCustomerName()
        );

        System.out.println("Customer City: " + customer.getCity());
        System.out.println("Customer Address: " + customer.getAddressLine1());
        System.out.println("Customer State: " + customer.getState());
        System.out.println("Customer Country: " + customer.getCountry());
        System.out.println("Customer Type: " + customer.getCustomerType());
    }
}
