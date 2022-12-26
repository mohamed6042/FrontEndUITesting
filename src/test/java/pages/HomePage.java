package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinitions.Hooks;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HomePage {

    private By register = By.linkText("Register");
    private By loginButton = By.linkText("Log in");
    private By selectCurrencyDropdown = By.id("customerCurrency");
    private By price = By.className("prices");
    private By searchBox = By.id("small-searchterms");
    private By searchButton = By.xpath("//button[contains(text(),'Search')]");
    private By productWithSKU = By.xpath("//ul[@id='ui-id-1']/li");
    int min = 1,max = 3;
    private By faceBookIcon = By.className("facebook");
    private By twitterIcon = By.className("twitter");
    private By rssIcon = By.className("rss");
    private By youtubeIcon = By.className("youtube");
    public int subCategoryNumber =(int) ((Math.random() * (max+1-min)) + min);

    int mainCategoryNumber = (int) ((Math.random() * (max+1-min)) + min);
    private By pageTitle = By.xpath("//div[@class='page-title']/h1");
    private By sliderButton1 = By.xpath("//div[@class='nivo-controlNav']/a[1]");
    private By sliderButton2 = By.xpath("//div[@class='nivo-controlNav']/a[2]");
    private By slider = By.id("nivo-slider");
    private By addToWishListButton = By.xpath("(//button[@title='Add to wishlist'])[3]");//the Third wishlist button
    private By wishListConfirmMessage = By.xpath("//div[@class='bar-notification success']");
    private By goToWishListPage = By.xpath("//span[contains(text(),'Wishlist')]");

    private void click(String linkText){
        Hooks.driver.findElement(By.linkText(linkText)).click();
    }

    public void goToRegisterPage(){
        click("Register");
    }

    public void goToLoginPage(){
        click("Log in");
    }

    public void selectCurrnecy(String currnecy){
        Select dropDownCurrency = new Select(Hooks.driver.findElement(selectCurrencyDropdown));
        dropDownCurrency.selectByVisibleText(currnecy);
    }

    public List<String> getProductsDetails(){
        List<WebElement>products = Hooks.driver.findElements(price);
        List<String> info =new ArrayList<>();
        for(WebElement details : products){
            info.add(details.getText());
        }
        return info;
    }

    public void search(String productName){
        Hooks.driver.findElement(searchBox).sendKeys(productName);
    }

    public void pressSearchButton(){
        Hooks.driver.findElement(searchButton).click();
    }

    public void selectProduct(){
        Hooks.driver.findElement(productWithSKU).click();
    }

    public void selectRandomMainCategory() {
        Actions actions = new Actions(Hooks.driver);
        By mainCategory = By.xpath("//ul[@class='top-menu notmobile']/li["+ mainCategoryNumber +"]");
        WebElement randomMainCategory = Hooks.driver.findElement(mainCategory);
        actions.moveToElement(randomMainCategory).perform();
    }

    public void selectRandomSubCategory(){
        By subCategory = By.xpath("//ul[@class='top-menu notmobile']/li["+ mainCategoryNumber +"]/ul/li["+subCategoryNumber+"]");
        Hooks.driver.findElement(subCategory).click();
    }

    public String getSubCategoryText(){
       return Hooks.driver.findElements(By.xpath("//ul[@class='top-menu notmobile']/li["+ mainCategoryNumber +"]/ul/li"))
               .get(subCategoryNumber-1).getText();
    }

    public String getPageTitle(){
        return Hooks.driver.findElement(pageTitle).getText().toLowerCase().trim();
    }

    public void nokiaHomeSlider(){
        Hooks.driver.findElement(sliderButton1).click();
        Hooks.driver.findElement(slider).click();
    }

    public void iphoneHomeSlider(){
        Hooks.driver.findElement(sliderButton2).click();
        Hooks.driver.findElement(slider).click();
    }

    private void clickSocialLink(By icon){
        Hooks.driver.findElement(icon).click();
    }

    public void clickFacebook(){
        clickSocialLink(faceBookIcon);
    }

    public void clickTwitter(){
        clickSocialLink(twitterIcon);
    }

    public void clickRss(){
        clickSocialLink(rssIcon);
    }

    public void clickYoutube(){
        clickSocialLink(youtubeIcon);
    }

    public void switchToNewTap(){
       var windows = Hooks.driver.getWindowHandles();
       if(Hooks.driver.getWindowHandles().size()>1) {
           Iterator<String> iterator = windows.iterator();
           String tab1 = iterator.next();
           String tab2 = iterator.next();
           Hooks.driver.switchTo().window(tab2);
       }
    }

    public void addToWishList(){
        Hooks.driver.findElement(addToWishListButton).click();
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(Hooks.driver.findElement(By.id("bar-notification"))));
    }

    public String getBackgroundColor(){
        String backGroundColor = Hooks.driver.findElement(wishListConfirmMessage).getCssValue("background-color");
        return Color.fromString(backGroundColor).asHex();
    }

    public Boolean isMessageDisplayed(){
        return Hooks.driver.findElement(wishListConfirmMessage).isDisplayed();
    }

    public void goToWishListPage(){
        WebDriverWait wait = new WebDriverWait(Hooks.driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(Hooks.driver.findElement(wishListConfirmMessage)));
        Hooks.driver.findElement(goToWishListPage).click();
    }

}
