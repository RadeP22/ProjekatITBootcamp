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
import projekaDemoQA.pages.Buttons;
import projekaDemoQA.pages.CheckBox;

import java.time.Duration;

public class ButtonsTest extends BasePage {


    @BeforeMethod
    public void setUp(){
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void testFirstButton(){
        driver.navigate().to(btn.RadioURL);
        btn.firstRadio();
        Assert.assertTrue(btn.getMessage().getText().contains("Yes"));
    }

    @Test
    public void testSecondButton(){
        driver.navigate().to(btn.RadioURL);
        btn.secondRadio();
        Assert.assertTrue(btn.getMessage().getText().contains("Impressive"));
    }

    @Test
    public void testThirdButton(){
        driver.navigate().to(btn.RadioURL);
        btn.thirdRadio();
        Assert.assertTrue(true);
    }

    @Test
    public void testDoubleclick(){
        driver.navigate().to(btn.ButtonsURL);
        btn.doubleClick();
        Assert.assertTrue(btn.getdblClickMessage().isDisplayed());
    }

    @Test
    public void testRightclick(){
        driver.navigate().to(btn.ButtonsURL);
        btn.rightClick();
        Assert.assertTrue(true);
    }

    @Test
    public void testDynamicClick(){
        driver.navigate().to(btn.ButtonsURL);
        btn.dynamicClick();
        Assert.assertTrue(btn.getDynClickMessage().isDisplayed());
    }

    @Test
    public void testEnabledBtn(){
        driver.navigate().to(btn.DinamicURL);
        btn.clickEnabledBtn();
        Assert.assertTrue(true);
    }

    @Test
    public void testChangeBtn(){
        driver.navigate().to(btn.DinamicURL);
        btn.clickChangeBtn();
        Assert.assertTrue(true);
    }

    @Test
    public void testAfterBtn(){
        driver.navigate().to(btn.DinamicURL);
        btn.clickAfterBtn();
        Assert.assertTrue(true);
    }

}
