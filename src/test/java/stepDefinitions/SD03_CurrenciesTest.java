package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import pages.HomePage;

public class SD03_CurrenciesTest {

    HomePage homePage = new HomePage();

    @When("select  euro from currency dropdown")
    public void changeToEuro() {
        homePage.selectCurrnecy("Euro");
    }

    @Then("prices of the products will be with €")
    public void confirmThatProductsWithEuro(){
        SoftAssert softAssert = new SoftAssert();
        for (String ea : homePage.getProductsDetails()){
            softAssert.assertTrue(ea.contains("€"));
        }
        softAssert.assertAll();
    }
}
