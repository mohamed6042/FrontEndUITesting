package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import pages.MyProfilePage;

public class SD02_LoginTest {

        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        MyProfilePage myProfilePage = new MyProfilePage();

        @Given("user go to login page")
        public void userGoToLoginPage() {
            homePage.goToLoginPage();
        }

        @When("user login with valid email {string} and password {string}")
        public void userLoginWithValidEmailAndPassword(String arg0, String arg1) {
            loginPage.enterEmail(arg0);
            loginPage.enterPassword(arg1);
    }

        @And("user press on login button")
        public void userPressOnLoginButton() {
            loginPage.clickLogin();
        }

        @Then("user login to the system successfully")
        public void userLoginToTheSystemSuccessfully() {
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(myProfilePage.confirmMyProfile());
            softAssert.assertEquals(myProfilePage.getActualUrl(), myProfilePage.expectedUrl);
            softAssert.assertAll();
        }

        @When("user login with invalid email {string} and {string}")
        public void userLoginWithInvalidEmailAnd(String email, String password) {
            loginPage.enterEmail(email);
            loginPage.enterPassword(password);
        }

        @Then("user could not login to the system and error message is shown")
        public void userCouldNotLoginToTheSystemAndErrorMessageIsShown() {
            SoftAssert softAssert = new SoftAssert();
            String act = loginPage.getActualErrorMessage();
            String ex = loginPage.expectedErrorMessage;
            softAssert.assertTrue(act.contains(ex));
            softAssert.assertEquals(Color.fromString(loginPage.errorMessageColor()).asHex(), loginPage.expectedMessageColor);
            softAssert.assertAll();
        }

}
