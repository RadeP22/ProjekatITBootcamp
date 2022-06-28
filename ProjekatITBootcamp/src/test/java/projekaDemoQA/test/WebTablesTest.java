package projekaDemoQA.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
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
import projekaDemoQA.pages.WebTables;

import java.time.Duration;
import java.util.List;

public class WebTablesTest extends BasePage {


    @BeforeMethod
    public void setUp(){
        driver.navigate().to(wt.url);
    }

    @AfterMethod
    public void tearDown(){
       driver.close();
    }


    @Test
    public void testAdd(){
        wt.clickAddButton();
        Assert.assertTrue(wt.getFirstName().isDisplayed());
        System.out.println(wt.getHeaderRow().get(0).getText());
        Assert.assertTrue(wt.getTableRows().size() == 5);
    }

    private boolean checkRowText(int i, String check){
        return wt.getTableRows().get(i).getText().contains(check);
    }

    @Test
    public void testSearchVega(){
        wt.searchVega();
        Assert.assertTrue(checkRowText(0,"Vega"));
        Assert.assertFalse(checkRowText(1, "Cantrell"));
        Assert.assertFalse(checkRowText(2, "Gentry"));
    }


    @Test
    public void testColumnSort(){
        wt.getHeaderRow().get(0).click();
        Assert.assertTrue(checkRowText(0,"Alden"));
        wt.getHeaderRow().get(1).click();
        Assert.assertTrue(checkRowText(0,"Cantrell"));
        wt.getHeaderRow().get(2).click();
        Assert.assertTrue(checkRowText(0,"29"));
        wt.getHeaderRow().get(3).click();
        Assert.assertTrue(checkRowText(0,"alden@example.com"));
        wt.getHeaderRow().get(4).click();
        Assert.assertTrue(checkRowText(0,"2000"));
        wt.getHeaderRow().get(5).click();
        Assert.assertTrue(checkRowText(0,"Compliance"));
    }

    @Test
    public void testEdit(){
        wt.editRecord();
        Assert.assertTrue(checkRowText(0,"Frida"));
    }

    @Test
    public void testDelete() throws InterruptedException {
        wt.deleteRecord();
        Assert.assertFalse(checkRowText(0,"Vega"));
    }

    @Test
    public void testRowPerPage(){
        wt.getRowPerPage().get(0).click();
        Assert.assertTrue(true);
    }

    @Test
    public void testRegistration(){
        wt.registration();
        Assert.assertTrue(true);
    }




}
