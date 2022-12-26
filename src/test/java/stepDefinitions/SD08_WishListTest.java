package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.WishlistPage;

public class SD08_WishListTest {

    HomePage homePage = new HomePage();
    WishlistPage wishlistPage = new WishlistPage();

    @When("user click on \"add to wishlist\" button of any product")
    public void addToWishListTest(){
        homePage.addToWishList();
    }

    @Then("a successful message is shown to user")
    public void aSuccessfulMessageIsShownToUser() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.isMessageDisplayed());
        String exptectedColorMessage = "#4bb07a";
        softAssert.assertEquals(homePage.getBackgroundColor(),exptectedColorMessage);
        softAssert.assertAll();
    }

    @And("go to wishlist page")
    public void goToWishlistPage() {
        homePage.goToWishListPage();
    }

    @Then("the product is been added in wishlist page with quantity=1")
    public void theProductIsBeenAddedInWishlistPageWithQuantity() {
        int quantity =wishlistPage.getQuantity();
        int baseCount=0;
        Assert.assertTrue(quantity>baseCount,"U R right");
    }
}
