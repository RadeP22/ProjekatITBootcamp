package projekaDemoQA.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import projekaDemoQA.pages.TextBox;

import java.time.Duration;

public class LinksTest extends BasePage {


    @BeforeMethod
    public void setUp(){
        driver.navigate().to(links.url);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void testSimpleLink(){
        links.clickLink(links.getSimpleLink());

        String actual = driver.getCurrentUrl();
        String expected = "https://demoqa.com/links";

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testDinamicLink(){
        links.clickLink(links.getDinamicLink());

        String actual = driver.getCurrentUrl();
        String expected = "https://demoqa.com/links";

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCreatedLink(){
        links.clickLink(links.getCreatedLink());
        js.executeScript("window.scrollTo(0, 500)");
        wdw.until(ExpectedConditions.presenceOfElementLocated(links.response));

        String actual = links.getResponse().getText();
        String expected = "Link has responded with staus 201 and status text Created";

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testNoContentLink(){
        links.clickLink(links.getNoContentLink());
        js.executeScript("window.scrollTo(0, 500)");
        wdw.until(ExpectedConditions.presenceOfElementLocated(links.response));

        String actual = links.getResponse().getText();
        String expected = "Link has responded with staus 204 and status text No Content";

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testMovedLink(){
        links.clickLink(links.getMovedLink());
        js.executeScript("window.scrollTo(0, 500)");
        wdw.until(ExpectedConditions.presenceOfElementLocated(links.response));

        String actual = links.getResponse().getText();
        String expected = "Link has responded with staus 301 and status text Moved Permanently";

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testBadRequestLink(){
        js.executeScript("window.scrollTo(0, 500)");
        links.clickLink(links.getBadRequestLink());

        wdw.until(ExpectedConditions.presenceOfElementLocated(links.response));

        String actual = links.getResponse().getText();
        String expected = "Link has responded with staus 400 and status text Bad Request";

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testUnoutharisedLink(){
        js.executeScript("window.scrollTo(0,500)");

        links.clickLink(links.getUnauthorisedLink());
        wdw.until(ExpectedConditions.presenceOfElementLocated(links.response));

        String actual = links.getResponse().getText();
        String expected = "Link has responded with staus 401 and status text Unauthorized";

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testForbidenLink(){
        js.executeScript("window.scrollTo(0, 500)");

        links.clickLink(links.getForbidenLink());
        wdw.until(ExpectedConditions.presenceOfElementLocated(links.response));

        String actual = links.getResponse().getText();
        String expected = "Link has responded with staus 403 and status text Forbidden";

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testNotFoundLink(){
        js.executeScript("window.scrollTo(0, 500)");
        links.clickLink(links.getNotFoundLink());
        wdw.until(ExpectedConditions.presenceOfElementLocated(links.response));

        String actual = links.getResponse().getText();
        String expected = "Link has responded with staus 404 and status text Not Found";

        Assert.assertEquals(actual, expected);
    }



}
