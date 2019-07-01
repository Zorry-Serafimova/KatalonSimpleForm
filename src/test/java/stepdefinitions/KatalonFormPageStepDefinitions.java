package stepdefinitions;

import Base.BaseUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import page_objects.KatalonFormPageObjects;

public class KatalonFormPageStepDefinitions {
    private BaseUtils base;

    public KatalonFormPageStepDefinitions(BaseUtils base) {
        this.base = base;
    }

    @Given("^User navigates to Katalon page$")
    public void userNavigatesToKatalonPage() {
        base.driver.get(base.baseURL);
    }

    @When("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userEntersAnd(String firstname, String lastname){
        base.userInput.inputFirstNameLastName(firstname, lastname);
    }

    @Then("^Form is submitted and success Message is shown$")
    public void formIsSubmittedAndSuccessMessageIsShown() {
        String successMessage = base.driver.findElement(By.id("submit-msg")).getText();
        Assert.assertEquals(successMessage, "Successfully submitted!");
    }

    @And("^all fields clear$")
    public void allFieldsClear() {
        base.userInput.clearFields();
    }


    @And("^User selects Gender$")
    public void userSelectsGender() {
        base.userInput.selectGender();
    }

    @And("^User enters \"([^\"]*)\"$")
    public void userEntersDateOfBirth(String dateofbirth){
        base.userInput.enterDob(dateofbirth);
    }

    @And("^User enters \"([^\"]*)\" in address field$")
    public void userEntersInAddressField(String address) {
        base.userInput.setAddress(address);
    }

    @And("^User enters \"([^\"]*)\" in email field and \"([^\"]*)\" in password field$")
    public void userEntersInEmailFieldAndInPasswordField(String email, String password)  {
        base.userInput.setEmailPassword(email, password);
    }

    @And("^User enters \"([^\"]*)\" in company field and \"([^\"]*)\" in comment field$")
    public void userEntersInCompanyFieldAndInCommentField(String companyName, String comment)  {
        base.userInput.setCompanyAndComment(companyName, comment);
    }

    @And("^User selects role and job expectation$")
    public void userSelectsRoleAndJobExpectation() {
        base.userInput.setRoleAndJobExpectation();
    }

    @And("^User selects ways of development$")
    public void userSelectsWaysOfDevelopment() {
        base.userInput.clickRandomWaysOfDevelopment();
    }

    @And("^User clicks submit button$")
    public void userClicksSubmitButton() {
        base.userInput.submitForm();
    }

    @Given("^User fills out form$")
    public void userFillsOutForm() {
        base.userInput = new KatalonFormPageObjects(base.driver);
    }
}
