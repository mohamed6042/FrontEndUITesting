package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import pages.HomePage;

public class SD06_HomeSliderTest {

    HomePage homePage = new HomePage();

    @When("user click on the first slider")
    public void clickOnFirstProduct(){
        homePage.nokiaHomeSlider();
    }

    @Then("user is be navigated to the first product successfully")
    public void userIsBeNavigatedToTheFirstProductSuccessfully() {
        String expectedURL= "https://demo.nopcommerce.com/nokia-lumia-1020";
        String actualURL = Hooks.driver.getCurrentUrl();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualURL,expectedURL);
        softAssert.assertAll();
    }

    @When("user click on the second slider")
    public void userClickOnTheSecondSlider() {
        homePage.iphoneHomeSlider();
    }

    @Then("user is be navigated to the second product successfully")
    public void userIsBeNavigatedToTheSecondProductSuccessfully() {
        String expectedURL = "https://demo.nopcommerce.com/iphone-6";
        String actualURL = Hooks.driver.getCurrentUrl();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualURL, expectedURL);
        softAssert.assertAll();
    }
}
