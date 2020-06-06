package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import objectReposity.HomepageReposity;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)
public class RegisterLogin {
    WebDriver df;

    @Given("The user is on the website and wants to register")
    public void theUserIsOnTheWebsiteAndWantsToRegister() {
        System.out.println("Primer paso");
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\usuario\\Documents\\Curso_Selenium\\Recursos\\geckodriver.exe");
        df = new FirefoxDriver();
        df.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        df.get("http://live.demoguru99.com/");
        System.out.println("fin Primer paso");
    }

    @When("Enter the login section of the website")
    public void enterTheLoginSectionOfTheWebsite() {
        HomepageReposity Register = new HomepageReposity(df);
        Register.Account().click();
        System.out.println("Segundo paso");
    }

    @And("select register new user")
    public void selectRegisterNewUser() {
        HomepageReposity Register = new HomepageReposity(df);
        Register.Register().click();
        System.out.println("Tercer paso");
    }

    @And("Fill in the necessary fields for a successful registration")
    public void fillInTheNecessaryFieldsForASuccessfulRegistration() {
        System.out.println("Cuarto paso");
    }

    @Then("DASHBOARD is shown")
    public void dashboardIsShown() {
        System.out.println("Quinto paso");
    }

    @And("validate that the page title is correct")
    public void validateThatThePageTitleIsCorrect() {
        System.out.println("Sexto paso");
        df.close();
    }


}
