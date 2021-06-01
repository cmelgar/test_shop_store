package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomeScreenPage {

    @FindBy(how = How.CLASS_NAME, using = "dy-lb-close")
    private WebElement popup;

    @FindBy(how = How.XPATH, using = "//*[@id=\"navbar\"]/div/div[2]/div[1]/a")
    private WebElement title;

    public WebElement getTitle() {
        return title;
    }

    public String getTitleText() {
        return getTitle().getDomProperty("title");
    }

    public WebElement getPopup() {
        return popup;
    }

    public void closePopup() {
        getPopup().click();
    }
}
