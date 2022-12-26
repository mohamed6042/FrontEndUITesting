package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.SearchPage;

import java.util.Random;

public class SD04_SearchTest {
    HomePage homePage = new HomePage();
    SearchPage searchPage = new SearchPage();
    String expectedUrl = "https://demo.nopcommerce.com/search?q=";

    @When("^user enter \"([^\"]*)\" in searchBox$")
    public void searchByProductName(String product) {
        homePage.search(product);
    }

    @And("press search button")
    public void pressEnter(){
        homePage.pressSearchButton();
    }



    @Then("^user should find the \"([^\"]*)\" in search result$")//first way to pass parameters
    public void userShouldFindTheInSearchResult(String product) {
        SoftAssert softAssert = new SoftAssert();
        String actualUrl = Hooks.driver.getCurrentUrl();
        softAssert.assertTrue(actualUrl.contains(expectedUrl));
        int count = searchPage.getProductTitles().size();
        for(int i=0;i<count;i++){
            String productTitle = searchPage.getProductTitles().get(i).getText();
            softAssert.assertTrue(productTitle.toLowerCase().contains(product));
        }
        softAssert.assertAll();
    }

    @Then("user should find the {string} in search details")
    public void userShouldFindTheInSearchDetails(String sku) {
        searchPage.clickOnProductInSearchPage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(searchPage.getActualSKU().contains(sku));
        softAssert.assertAll();
    }

}
