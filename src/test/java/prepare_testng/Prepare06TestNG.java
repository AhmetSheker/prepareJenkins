package prepare_testng;

import Pages.IMDB;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import utils.ConfigReader;
import utils.Driver;

import java.net.MalformedURLException;
import java.net.URL;

public class Prepare06TestNG {
    WebDriver driver;
    IMDB imdb;
    @Test
    public void seleniumGrid() throws MalformedURLException {
        driver = new RemoteWebDriver(new URL("http://192.168.1.102:4444/ui#"), new ChromeOptions());
        Driver.getDriver().get(ConfigReader.getProperties("imdb_url"));
        imdb = new IMDB();
        imdb.rightNavCursor.click();
        imdb.leftNavCursor.click();
        imdb.leftNavCursor.click();
        imdb.trailer.click();
    }
}
