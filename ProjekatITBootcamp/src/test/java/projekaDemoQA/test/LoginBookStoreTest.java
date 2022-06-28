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
import projekaDemoQA.pages.CheckBox;
import projekaDemoQA.pages.LoginBookStore;

import java.time.Duration;

public class LoginBookStoreTest extends BasePage {



    @BeforeMethod
    public void setUp(){
        driver.navigate().to(lbs.url);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void testLogin(){
        lbs.login();

        wdw.until(ExpectedConditions.presenceOfElementLocated(By.id("userName-value")));
        WebElement username = driver.findElement(By.id("userName-value"));
        String actual = username.getText();
        String expected = "RadeP";

        Assert.assertEquals(actual, expected);
    }

}
