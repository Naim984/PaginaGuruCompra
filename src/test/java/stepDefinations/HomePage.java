package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import objectReposity.HomepageReposity;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

@RunWith(Cucumber.class)
public class HomePage {
   WebDriver dr;


    @Given("^I navigate to the home page and verify your title$")
    public void i_navigate_to_the_home_page_and_verify_your_title() throws Throwable {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\usuario\\Documents\\Curso_Selenium\\Recursos\\geckodriver.exe");
        dr = new FirefoxDriver();
        dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        dr.get("http://live.demoguru99.com/");
        dr.getTitle();
        String aTitle = " ";
        String eTitle = "Home page";
        aTitle = dr.getTitle ();
        System.out.println ("El titulo de la pagina es:"+ aTitle);
        if (eTitle.equals (aTitle))
        {
            System.out.println ("Titulo correcto");
        }
        else {
            System.out.println ("Titulo incorrecto");
        }
    }

    @When("Enter the mobile page")
    public void enterTheMobilePage() throws InterruptedException {
        System.out.println("Segundo paso");
        Thread.sleep(2000);
        HomepageReposity Enter = new HomepageReposity(dr);
        Enter.Mobile().click();
        String maTitle = " ";
        String meTitle = "Mobile";
        maTitle = dr.getTitle ();
        System.out.println ("El titulo de la pagina es:"+ maTitle);
        try {
            assertEquals(meTitle, maTitle);
            System.out.println ("Prueba aprobada");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println ("Prueba fallida");
        }

    }

    @Then("^The available mobile offers are shown$")
    public void the_available_mobile_offers_are_shown() throws Throwable {

           }

    @And("^enter the offers section to see the available mobiles$")
    public void enter_the_offers_section_to_see_the_available_mobiles() throws Throwable {
        HomepageReposity SeccionMobile = new HomepageReposity(dr);
        SeccionMobile.Search().click();
        new Select(dr.findElement(By.cssSelector("select[title=\"Sort By\"]"))).selectByVisibleText("Name");
        System.out.println ("Se puede ver los mobiles ordenados por Name");
        dr.close();
    }


}



