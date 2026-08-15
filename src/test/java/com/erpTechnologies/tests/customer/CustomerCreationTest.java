package com.erpTechnologies.tests.customer;

import com.erpTechnologies.dataproviders.CustomerDataProvider;
import com.erpTechnologies.models.Customer;
import com.erpTechnologies.pages.CustomerPage;
import com.erpTechnologies.pages.HomePage;
import com.erpTechnologies.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerCreationTest extends BaseTest {


    @Test(
            dataProvider = "validCustomers",
            dataProviderClass = CustomerDataProvider.class
    )
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
