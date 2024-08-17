package step_def;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.GoogleSearchPage;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.time.Duration;


public class GoogleSearchStepDef {

    GoogleSearchPage searchPage = new GoogleSearchPage();

    @Given("a web browser is on the Google home page")
    public void a_web_browser_is_on_the_google_home_page() {

        //Driver.getDriver().get(ConfigurationReader.getProperty("googleUrl"));
        Driver.getDriver().get("https://www.google.com/");

    }

    @When("the user enters {string} into the search bar")
    public void theUserEntersIntoTheSearchBar(String searchTerm) {
        searchPage.searchBox.sendKeys(searchTerm);
    }

    @And("the user clicks the {string} button")
    public void theUserClicksTheButton(String searchBtn) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(searchPage.searchBox));
        searchPage.searchBtn.click();
    }

    @Then("title should contains the searched term")
    public void titleShouldContainsTheSearchedTerm() {
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains("selenium"));
    }
}
