package stepdefinitions;

import Pages.IMDB;
import io.cucumber.java.en.*;
import org.junit.Assert;
import utils.ConfigReader;
import utils.Driver;

public class IMDBStepDefs {

    IMDB imdb;

    @Given("user is on imdb home page")
    public void user_is_on_imdb_home_page() {
        Driver.getDriver().get(ConfigReader.getProperties("imdb_url"));
    }
    @Given("verifies imdb logo")
    public void verifies_imdb_logo() {
        imdb = new IMDB();
        boolean logoDisplayed = imdb.homeLogo.isDisplayed();
        Assert.assertTrue(logoDisplayed);
    }
    @When("user clicks right arrow button once")
    public void user_clicks_right_arrow_button_once() {
        imdb.rightNavCursor.click();
    }
    @Then("user clicks left arrow button twice")
    public void user_clicks_left_arrow_button_twice() {
        imdb.leftNavCursor.click();
        imdb.leftNavCursor.click();
    }
    @Then("user clicks the trailer")
    public void user_clicks_the_trailer() {
        imdb.trailer.click();
    }
}
