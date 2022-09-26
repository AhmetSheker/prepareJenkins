package prepare_junit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Prepare02JUnit {
    /* TASK
        Create a class : LocatorsIntro
        Create test method locators
        user goes to http://a.testaddressbook.com/sign_in
        Locate the elements of email textbox, password textbox, and signin button
        Enter below username and password then click sign in button
        Username : testtechproed@gmail.com
        Password : Test1234!
        Then verify that the expected user id testtechproed@gmail.com (USE getText() method to
        get the text from the page)
        Verify the Addresses and Sign Out texts are displayed
        Find the number of total link on the page
        Sign out from the page
     */

    @Test
    public void locators01(){
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://a.testaddressbook.com/sign_in");
        WebElement email = driver.findElement(By.id("session_email"));
        email.sendKeys("testtechproed@gmail.com");
        WebElement password = driver.findElement(By.id("session_password"));
        password.sendKeys("Test1234!");
        WebElement submit = driver.findElement(By.name("commit"));
        submit.click();
        WebElement username = driver.findElement(By.className("navbar-text"));
        String expectedUserName = "testtechproed@gmail.com";
        String actualUserName = username.getText();
        Assert.assertEquals(expectedUserName, actualUserName);
        WebElement addressesLink = driver.findElement(By.linkText("Addresses"));
        boolean addressIsDisplayed = addressesLink.isDisplayed();
        Assert.assertTrue(addressIsDisplayed);
        WebElement signoutLink = driver.findElement(By.linkText("Sign out"));
        boolean signoutIsDisplayed = signoutLink.isDisplayed();
        Assert.assertTrue(signoutIsDisplayed);
        List<WebElement> linkList = driver.findElements(By.tagName("a"));
        int numberOfLinks = linkList.size();
        signoutLink.click();
        driver.quit();
    }
}
