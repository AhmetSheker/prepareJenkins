package prepare_junit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Prepare01JUnit {
    /*
        Create a new clas under : BasicNavigations
        Create main method
        Set Path
        Create Chrome Driver
        Maximize the window
        Open google home page https://www.google.com/
        On the same class, navigate to amazon home page https://www.amazon.com/
        Navigate back to google
        Navigate forward the amazon
        Refresh the page
        Close/quit browser
         */
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
        WebDriver driver  = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        String expectedUrl1 = "https://www.google.com/";
        String actualUrl1 = driver.getCurrentUrl();
        if(actualUrl1.equals(expectedUrl1)){
            System.out.println("Passed first implementation\n" + "Expected: " + expectedUrl1 + "\n" + "Actual: " + actualUrl1);
        } else{
            System.out.println("Failed first implementation\n" + "Expected: " + expectedUrl1 + "\n" + "Actual: " + actualUrl1);
        }
        driver.navigate().to("https://www.amazon.com/");
        String expectedUrl2 = "https://www.amazon.com/";
        String actualUrl2 = driver.getCurrentUrl();
        if(actualUrl2.equals(expectedUrl2)){
            System.out.println("Passed second implementation\n" + "Expected: " + expectedUrl2 + "\n" + "Actual: " + actualUrl2);
        } else{
            System.out.println("Failed second implementation\n" + "Expected: " + expectedUrl2 + "\n" + "Actual: " + actualUrl2);
        }
        driver.navigate().back();
        String actualUrl3 = driver.getCurrentUrl();
        if(actualUrl3.equals(expectedUrl1)){
            System.out.println("Passed third implementation\n" + "Expected: " + expectedUrl1 + "\n" + "Actual: " + actualUrl3);
        } else{
            System.out.println("Failed third implementation\n" + "Expected: " + expectedUrl1 + "\n" + "Actual: " + actualUrl3);
        }
        driver.navigate().forward();
        String actualUrl4 = driver.getCurrentUrl();
        if(actualUrl4.equals(expectedUrl2)){
            System.out.println("Passed fourth implementation\n" + "Expected: " + expectedUrl2 + "\n" + "Actual: " + actualUrl4);
        } else{
            System.out.println("Failed fourth implementation\n" + "Expected: " + expectedUrl2 + "\n" + "Actual: " + actualUrl4);
        }
        driver.navigate().refresh();
        String actualUrl5 = driver.getCurrentUrl();
        if(actualUrl5.equals(expectedUrl2)){
            System.out.println("Passed fifth implementation\n" + "Expected: " + expectedUrl2 + "\n" + "Actual: " + actualUrl5);
        } else{
            System.out.println("Failed fifth implementation\n" + "Expected: " + expectedUrl2 + "\n" + "Actual: " + actualUrl5);
        }
        driver.get("https://www.techproeducation.com/");
        driver.get("https://www.facebook.com/");
        driver.quit();
    }
}
