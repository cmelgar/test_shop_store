package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomeScreenPage {

    WebDriver driver;

    @FindBy(how = How.CLASS_NAME, using = "dy-lb-close")
    private WebElement popup;

    @FindBy(how = How.XPATH, using = "//*[@id=\"navbar\"]/div/div[2]/div[1]/a")
    private WebElement title;

    public HomeScreenPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getTitle() {
        return title;
    }

    public String getTitleText() {
        return getTitle().getDomProperty("title");
    }

    public WebElement getPopup() {
        return popup;
    }

    public void managePopUp() {

        Boolean elementPresent = ExpectedConditions.invisibilityOf(getPopup()).apply(driver).booleanValue();
        if (!elementPresent) {
            closePopup();
        }
    }

    private void closePopup() {
        getPopup().click();
    }
}
