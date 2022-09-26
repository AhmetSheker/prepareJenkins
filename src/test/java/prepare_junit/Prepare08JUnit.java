package prepare_junit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ConfigReader;

import java.time.Duration;
import java.util.Set;

public class Prepare08JUnit {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void windowHandle() throws InterruptedException {


        driver.get(ConfigReader.getProperties("imdb_url"));
        String imdbWindowHandle = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB).get(ConfigReader.getProperties("homarch_url"));
        String homarchWindowHandle = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB).get(ConfigReader.getProperties("amazon_url"));
        String amazonWindowHandle = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.WINDOW).get(ConfigReader.getProperties("google_url"));
        String googleWindowHandle = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB).get(ConfigReader.getProperties("bluecar_url"));
        String bluecarWindowHandle = driver.getWindowHandle();

        Thread.sleep(2500);
        driver.switchTo().window(imdbWindowHandle);
        Thread.sleep(2500);
        driver.switchTo().window(homarchWindowHandle);
        Thread.sleep(2500);
        driver.switchTo().window(amazonWindowHandle);
        Thread.sleep(2500);
        driver.switchTo().window(googleWindowHandle);
        Thread.sleep(2500);
        driver.switchTo().window(bluecarWindowHandle);

        Thread.sleep(2500);
        driver.quit();
    }

    @Test
    public void windowHandle2() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement clickHere = driver.findElement(By.partialLinkText("Click Here"));
        String firstHandle = driver.getWindowHandle();
        clickHere.click();
        Thread.sleep(2500);
        driver.switchTo().window(firstHandle);
        Thread.sleep(2500);
        Set<String> handleList = driver.getWindowHandles();
        for(String w : handleList){
            if(!w.equals(firstHandle)){
                driver.switchTo().window(w);
            }
        }
        String secondHandle = driver.getWindowHandle();
        driver.switchTo().window(secondHandle);
        Thread.sleep(2500);
        driver.quit();
    }
}
