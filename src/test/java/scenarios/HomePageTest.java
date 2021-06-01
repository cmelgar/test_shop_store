package scenarios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import pageobjects.HomeScreenPage;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class HomePageTest {

    WebDriver driver;

    @Before
    public void startTest() {
        Map<String, Object> prefs = new HashMap<String, Object>();

        prefs.put("profile.default_content_setting_values.notifications", 2);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
    }

    @Test
    public void openWebTest() {

        String url = "https://linio.com.pe";

        driver.get(url);

        driver.switchTo().parentFrame();

        HomeScreenPage homeScreenPage = PageFactory.initElements(driver, HomeScreenPage.class);

        homeScreenPage.closePopup();

        Assert.assertEquals("Linio", homeScreenPage.getTitleText());

    }

    @After
    public void tearDown() {
        driver.close();
    }
}
