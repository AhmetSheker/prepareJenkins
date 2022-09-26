package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class IMDB {
    public IMDB(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@id='home_img_holder']")
    public WebElement homeLogo;

    @FindBy(xpath = "//*[@id=\"__next\"]/main/div/div[3]/div[1]/div/div/div[1]/div/div[2]/div")
    public WebElement leftNavCursor;

    @FindBy(xpath = "//*[@id='__next']/main/div/div[3]/div[1]/div/div/div[1]/div/div[3]/div")
    public WebElement rightNavCursor;

    @FindBy(xpath = "/html/body/div[2]/main/div/div[3]/div[1]/div/div/div[1]/div/div[1]/div[2]/figure/div/div[2]/div[2]/div[2]")
    public WebElement trailer;
}
