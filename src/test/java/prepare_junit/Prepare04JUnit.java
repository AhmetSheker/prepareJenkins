package prepare_junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;

public class Prepare04JUnit {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void radioButton(){
        WebElement signupButton = driver.findElement(By.linkText("Yeni Hesap Oluştur"));
        signupButton.click();
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Denemebir");
        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Denemeiki");
        WebElement email = driver.findElement(By.name("reg_email__"));
        email.sendKeys("denemebirki@gmail.com");
        WebElement password = driver.findElement(By.name("reg_passwd__"));
        password.sendKeys("denemebirki");
        WebElement day = driver.findElement(By.id("day"));
        Select select1 = new Select(day);
        select1.selectByVisibleText("7");
        WebElement month = driver.findElement(By.id("month"));
        Select select2 = new Select(month);
        select2.selectByVisibleText("Eyl");
        WebElement year = driver.findElement(By.id("year"));
        Select select3 = new Select(year);
        select3.selectByVisibleText("2004");
        WebElement male = driver.findElement(By.xpath("(//label[@class='_58mt'])[2]"));
        if(!male.isSelected()){
            male.click();
        }
        WebElement emailConf = driver.findElement(By.name("reg_email_confirmation__"));
        emailConf.sendKeys("denemebirki@gmail.com");
        WebElement submit = driver.findElement(By.name("websubmit"));
        submit.click();
    }
}
