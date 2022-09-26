package prepare_testng;

import Pages.BlueCarRental;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ConfigReader;
import utils.Driver;

public class Prepare05TestNG {
    BlueCarRental carRental;

    @DataProvider
    public Object[][] dataProvider01(){
        Object[][] user_credentials = {
            {"customer@bluerentalcars.com","12345"},
            {"customer1@bluerentalcars.com","12346"},
            {"customer2@bluerentalcars.com","12347"},
            {"customer3@bluerentalcars.com","12348"}
        };
        return user_credentials;
    }

    @Test(dataProvider = "dataProvider01")
    public void blueCar(String username, String password) throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperties("bluecar_url"));
        carRental = new BlueCarRental();
        carRental.loginButton.click();
        Thread.sleep(3000);
        carRental.email.sendKeys(username);
        carRental.password.sendKeys(password);
        Thread.sleep(3000);
        carRental.finalLogin.click();
    }
}
