package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;

public class SD05_HoverCategoriesTest {

    HomePage homePage = new HomePage();
    String subCatogory;

    @When("user can hover on mainCategory and select subCategory")
    public void test(){
        homePage.selectRandomMainCategory();
        subCatogory = homePage.getSubCategoryText().toLowerCase().trim();
        homePage.selectRandomSubCategory();
    }

    @And("subCategory name should be in page title")
    public void subcategoryNameShouldBeInPageTitle() {
        Assert.assertEquals(subCatogory,homePage.getPageTitle());
    }

}
