package com.erpTechnologies.tests.customer;

import com.erpTechnologies.dataproviders.CustomerDataProvider;
import com.erpTechnologies.models.CustomerValidationScenario;
import com.erpTechnologies.pages.CustomerPage;
import com.erpTechnologies.pages.HomePage;
import com.erpTechnologies.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerCreatingNegativeTest extends BaseTest {

    @Test(
            dataProvider = "customerValidationScenarios",
            dataProviderClass = CustomerDataProvider.class
    )
    public void shouldShowCustomerValidation(
            CustomerValidationScenario scenario
    ) {

        HomePage homePage =
                authenticationWorkflow.loginAsAdmin();

        CustomerPage customerPage =
                homePage.openCustomerPage();

        customerPage.clickAddCustomer();

        customerPage
                .fillCustomerDetails(scenario.getCustomer())
                .clickSave();

        Assert.assertTrue(
                customerPage.isMissingFieldDisplayed(
                        scenario.getExpectedField()
                ),
                scenario.getExpectedField()
                        + " validation message was not displayed"
        );
    }
}
