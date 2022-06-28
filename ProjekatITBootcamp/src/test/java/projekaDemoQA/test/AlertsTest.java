package projekaDemoQA.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import projekaDemoQA.base.BasePage;
import projekaDemoQA.pages.*;

import java.time.Duration;

public class AlertsTest extends BasePage {


    @BeforeMethod
    public void setUp(){
        driver.navigate().to(alerts.url);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void testAlertBtn(){
        alerts.clickAlertBtn();
        wdw.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    @Test
    public void testTimerBtn(){
        alerts.clickTimerBtn();
        wdw.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    @Test
    public void testConfirmBtn(){
        alerts.clickConfirmBtn();
        wdw.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    @Test
    public void testPromtBtn(){
        alerts.clickPromtBtn();
        wdw.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

}
