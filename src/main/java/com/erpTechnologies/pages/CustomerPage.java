package com.erpTechnologies.pages;

import com.erpTechnologies.models.Customer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerPage extends BasePage {


    private static final String ACTIVE_MODAL =
            "div.modal.show[role='dialog'][aria-modal='true']";

    private final By addCustomerButton =
            By.cssSelector("button.primary-action[data-label='Add Customer']");

    private final By customerPageHeader =
            By.xpath("//div[@data-id='Customer']//div[contains(@class,'active-sidebar')]//a[@href='/desk/customer']");

    private final By customerNameInput =
            By.cssSelector(ACTIVE_MODAL + " input[data-fieldname='customer_name'][data-doctype= 'Customer']");

    private By customerTypeSelect(String customerType) {
        return By.xpath(
                ACTIVE_MODAL +
                        " select[data-fieldname='customer_type'][data-doctype='" + customerType + "']"
        );
    }

    private final By firstNameInput =
            By.cssSelector(ACTIVE_MODAL + " input[data-fieldname='map_to_first_name'][data-doctype='Customer']");

    private final By lastNameInput =
            By.cssSelector(ACTIVE_MODAL + " input[data-fieldname='map_to_last_name'][data-doctype='Customer']");

    private final By emailInput =
            By.cssSelector(ACTIVE_MODAL + " input[data-fieldname='email_address'][data-doctype='Customer']");

    private final By mobileNumberInput =
            By.cssSelector(ACTIVE_MODAL + " input[data-fieldname='mobile_number'][data-doctype='Customer']");

    private final By addressLine1Input =
            By.cssSelector(ACTIVE_MODAL + " input[data-fieldname='address_line1'][data-doctype='Customer']");

    private final By addressLine2Input =
            By.cssSelector(ACTIVE_MODAL + " input[data-fieldname='address_line2'][data-doctype='Customer']");

    private final By zipCodeInput =
            By.cssSelector(ACTIVE_MODAL + " input[data-fieldname='pincode'][data-doctype='Customer']");


    private final By cityInput =
            By.cssSelector(ACTIVE_MODAL + " input[data-fieldname='city'][data-doctype='Customer']");

    private final By stateInput =
            By.cssSelector(ACTIVE_MODAL + " input[data-fieldname='state'][data-doctype='Customer']");

    private final By countryInput =
            By.cssSelector(ACTIVE_MODAL + " input[data-fieldname='country_address']");

    private By countryOption(String countryName) {

        return By.xpath(
                "//div[contains(concat(' ', normalize-space(@class), ' '), ' modal ') " +
                        "and contains(concat(' ', normalize-space(@class), ' '), ' show ')]" +
                        "//div[@data-fieldname='country_address']" +
                        "//ul[@role='listbox']" +
                        "//div[@role='option'][.//p[@title=\"" + countryName + "\"]]"
        );
    }
    private final By saveButton =
            By.cssSelector(ACTIVE_MODAL + " .modal-footer button.btn-modal-primary");

    private final By customerSaveMessage =
            By.cssSelector("#alert-container .alert-message");

    private final By editFullFormButton =
            By.cssSelector(ACTIVE_MODAL + " .modal-footer button.btn-secondary");

    public CustomerPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCustomerPageLoaded() {
        return isDisplayed(customerPageHeader, "Customer");
    }

    public boolean isCustomerSaved(String customerName) {

        String actualMessage = getText(
                customerSaveMessage,
                "Customer Saved Successfully"
        );

        String expectedMessage = customerName + " saved";

        return actualMessage.trim()
                .equalsIgnoreCase(expectedMessage);
    }

    public void clickAddCustomer(){
        click(addCustomerButton, "Add Customer");
    }

    public CustomerPage enterCustomerName(String customerName) {

        type(customerNameInput, customerName, "Customer Name");

        return this;
    }

    public CustomerPage selectCustomerType(String customerType) {
        selectByVisibleText(
                customerTypeSelect(customerType),
                customerType,
                "Customer Type"
        );
        return this;
    }

    public CustomerPage enterFirstName(String firstName) {

        type(firstNameInput, firstName, "First Name");

        return this;
    }

    public CustomerPage enterLastName(String lastName) {

        type(lastNameInput, lastName, "Last Name");

        return this;
    }

    public CustomerPage enterEmail(String email) {

        type(emailInput, email, "Email");

        return this;
    }

    public CustomerPage enterMobileNumber(String mobileNumber) {

        type(mobileNumberInput, mobileNumber, "Mobile Number");

        return this;
    }

    public CustomerPage enterAddressLine1(String addressLine1) {

        type(addressLine1Input, addressLine1, "Address Line 1");

        return this;
    }

    public CustomerPage enterAddressLine2(String addressLine2) {

        type(addressLine2Input, addressLine2, "Address Line 2");

        return this;
    }

    public CustomerPage enterCity(String city) {

        type(cityInput, city, "City");

        return this;
    }

    public CustomerPage enterState(String state) {

        type(stateInput, state, "State");

        return this;
    }

    public CustomerPage enterZipCode(String zipCode) {

        type(zipCodeInput, zipCode, "Zip Code");

        return this;
    }

    public CustomerPage selectCountry(String country) {

        selectCustomDropdown(
                countryInput,
                countryOption(country),
                country,
                "Country"
        );

        return this;
    }


    public CustomerPage clickSave() {

        click(saveButton, "Save Button");

        return this;
    }

    public CustomerPage fillCustomerDetails(Customer customer) {

        enterCustomerName(customer.getCustomerName());
//        selectCustomerType(customer.getCustomerType());
        enterFirstName(customer.getFirstName());
        enterLastName(customer.getLastName());
        enterEmail(customer.getEmail());
        enterMobileNumber(customer.getMobileNumber());
        enterAddressLine1(customer.getAddressLine1());
        enterAddressLine2(customer.getAddressLine2());
        enterCity(customer.getCity());
        enterState(customer.getState());
        enterZipCode(customer.getZipCode());
        selectCountry(customer.getCountry());

        return this;
    }







}
