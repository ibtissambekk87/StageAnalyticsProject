package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSearchPage {

    @FindBy(xpath = "//textarea[@name=\"q\"]  ")
    public WebElement searchBox;

    @FindBy(xpath = "//textarea[@name='q']")
   public WebElement searchBtn;


}
