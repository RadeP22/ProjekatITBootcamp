package projekaDemoQA.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import projekaDemoQA.base.BasePage;
import projekaDemoQA.pages.*;

import java.time.Duration;

public class BrowserWindowTest extends BasePage {


    @BeforeMethod
    public void setUp(){
        driver.navigate().to(brWin.url);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void testTabBtn(){
        brWin.clickTabBtn();
        Assert.assertTrue(true);
    }

    @Test
    public void testWindowBtn(){
        brWin.clickWindowBtn();
        Assert.assertTrue(true);
    }

    @Test
    public void testMsgWindowBtn(){
        brWin.clickMsgWindowBtn();
        Assert.assertTrue(true);
    }

}
