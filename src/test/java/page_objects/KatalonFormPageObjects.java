package page_objects;

import Base.BaseUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class KatalonFormPageObjects extends BaseUtils {
    @FindBy(id = "first-name")
    private WebElement firstName;
    @FindBy(id = "last-name")
    private WebElement lastName;
    @FindBy(xpath = "//label[contains(text(),'Female')]")
    private WebElement genderInput;
    /*@FindBy(xpath = "//input[@type='radio']")
    private List<WebElement> genderSelect;*/
    @FindBy(id = "dob")
    private WebElement dateOfBirth;
    @FindBy(id = "address")
    private WebElement addressEntry;
    @FindBy(id = "email")
    private WebElement emailAddressInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "company")
    private WebElement companyInput;
    @FindBy(id = "role")
    private WebElement roleDropdown;
    @FindBy(id = "expectation")
    private WebElement jobExpectationMulti;
    @FindBys({@FindBy(xpath = "//div[@class='col-sm-10 development-ways']"),
            @FindBy(xpath = "//input[@type='checkbox']")})
    private List<WebElement> waysOfDevelopment;
    @FindBy(id = "comment")
    private WebElement commentInput;
    @FindBy(id = "submit")
    private WebElement submitButton;


    public KatalonFormPageObjects(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void inputFirstNameLastName(String firstname, String lastname) {
        this.firstName.clear();
        this.firstName.sendKeys(firstname);

        this.lastName.clear();
        this.lastName.sendKeys(lastname);
    }

    public void selectGender() {
        this.genderInput.click();
    }

    public void enterDob(String dateOfBirth) {
        this.dateOfBirth.clear();
        this.dateOfBirth.sendKeys(dateOfBirth);
    }

    public void setAddress(String address) {
        this.addressEntry.clear();
        this.addressEntry.sendKeys(address);
    }

    public void setEmailPassword(String email, String password) {
        this.emailAddressInput.clear();
        this.emailAddressInput.sendKeys(email);
        this.passwordInput.clear();
        this.passwordInput.sendKeys(password);
    }

    public void setCompanyAndComment(String company, String comment) {
        this.companyInput.clear();
        this.companyInput.sendKeys(company);
        this.commentInput.clear();
        this.commentInput.sendKeys(comment);
    }

    public void setRoleAndJobExpectation() {
        Select role = new Select( this.roleDropdown);
        Select jobExpect = new Select( this.jobExpectationMulti);
        role.selectByVisibleText("QA");
        jobExpect.selectByVisibleText("Good teamwork");
        jobExpect.selectByVisibleText("High salary");
        jobExpect.selectByVisibleText("Challenging");
    }

    public void clickRandomWaysOfDevelopment() {
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            int rand = random.nextInt( this.waysOfDevelopment.size());
            if (! this.waysOfDevelopment.get(rand).isSelected()) {
                this.waysOfDevelopment.get(rand).click();
            } else {
                i--;
            }
        }
    }

    public void submitForm() {
        submitButton.submit();
    }

    public void clearFields() {
        this.firstName.clear();
        this.lastName.clear();
        this.dateOfBirth.clear();
        this.addressEntry.clear();
        this.emailAddressInput.clear();
        this.passwordInput.clear();
        this.commentInput.clear();
        this.companyInput.clear();
        for (WebElement element :  this.waysOfDevelopment) {
            if (element.isSelected())
                element.click();
        }
    }
}
