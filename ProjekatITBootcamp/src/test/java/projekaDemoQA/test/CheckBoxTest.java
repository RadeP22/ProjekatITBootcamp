package projekaDemoQA.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import projekaDemoQA.base.BasePage;
import projekaDemoQA.pages.CheckBox;
import projekaDemoQA.pages.TextBox;

import java.time.Duration;
import java.util.List;

public class CheckBoxTest extends BasePage {


    @BeforeMethod
    public void setUp(){
        driver.navigate().to(cb.url);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void testCheckBox(){
        cb.clickCheckBox();
        Assert.assertTrue(true);
    }

    @Test
    public void testToggle() throws InterruptedException {
        cb.clickToggle();
        Assert.assertTrue(true);
    }

    @Test
    public void testExpand(){
        cb.clickExpand();
        Assert.assertTrue(true);
    }

    @Test
    public void testCollapse(){
        cb.clickCollapse();
        Assert.assertTrue(true);
    }

}
