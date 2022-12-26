package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;

public class SD07_FollowUsTest {

    HomePage homePage = new HomePage();

    @When("user click on facebook icon at the bottom of home page")
    public void clickOnFacebook(){
        homePage.clickFacebook();
    }

    @When("user click on twitter icon at the bottom of home page")
    public void clickOnTwitter() {
        homePage.clickTwitter();
    }

    @When("user click on rss icon at the bottom of home page")
    public void clickOnRss() {
        homePage.clickRss();
    }

    @When("user click on youtube icon at the bottom of home page")
    public void clickOnYoutube() {
        homePage.clickYoutube();
    }

    @Then("{string} is opened in new tab")
    public void confirmNewTab(String expectedUrl) {
        homePage.switchToNewTap();
        String actualNewURL = Hooks.driver.getCurrentUrl();
        Assert.assertEquals(actualNewURL,expectedUrl);
    }
}
