package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class BlueCarRental {
    public BlueCarRental(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//ul//li//a[@role='button']")
    public WebElement loginButton;

    @FindBy(name = "email")
    public WebElement email;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement finalLogin;
}
