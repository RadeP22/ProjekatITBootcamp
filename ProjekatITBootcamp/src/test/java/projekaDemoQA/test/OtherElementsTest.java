package projekaDemoQA.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import projekaDemoQA.base.BasePage;
import projekaDemoQA.pages.Links;
import projekaDemoQA.pages.OtherElements;

import java.time.Duration;

public class OtherElementsTest extends BasePage {



    @BeforeMethod
    public void setUp(){

    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void testValidLink(){
        driver.navigate().to(othEl.brkLinksURL);
        js.executeScript("window.scrollTo(0, 500)");
        othEl.clickValidLink();


        String actual = driver.getCurrentUrl();
        String expected = "https://demoqa.com/";

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testBrokenLink(){
        driver.navigate().to(othEl.brkLinksURL);
        js.executeScript("window.scrollTo(0, 500)");
        othEl.clickBrokenLink();

        String actual = driver.getCurrentUrl();
        String expected = "http://the-internet.herokuapp.com/status_codes/500";

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testInputPic(){
        driver.navigate().to(othEl.downloadURL);
        othEl.uploadFile();
        Assert.assertTrue(othEl.getFileInput().getAttribute("value").contains("2022-06-08 at 18.15.59.png"));
    }
}
