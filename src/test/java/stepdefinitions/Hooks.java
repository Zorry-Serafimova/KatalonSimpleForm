package stepdefinitions;

import Base.BaseUtils;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks extends BaseUtils {
    private BaseUtils base;

    public Hooks(BaseUtils base) {
        this.base = base;
    }

    @Before
    public void setup() {
        base.driver = new ChromeDriver();
        base.baseURL = "http://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html";
    }

    @After
    public void clear() {
        base.driver.quit();
    }
}
