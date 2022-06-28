package projekaDemoQA.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.SafariDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import projekaDemoQA.base.BasePage;
import projekaDemoQA.pages.*;

import java.net.URL;
import java.time.Duration;

public class BookStoreTest extends BasePage {



    @BeforeMethod
    public void setUp(){
        driver.navigate().to(bookSt.url);

    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void testAddNewBook() throws InterruptedException {
        bookSt.addNewBook();
        Assert.assertTrue(profile.getTableRows().get(0).getText().contains("Git Pocket Guide"));
    }

    @Test
    public void testDeleteBook() throws InterruptedException {
        bookSt.deleteBook();
        Assert.assertFalse(profile.getTableRows().get(0).getText().contains("Git Pocket Guide"));
    }

    @Test
    public void testFilter(){
        bookSt.filterBooks("java");
        Assert.assertTrue(profile.getTableRows().get(0).getText().contains("Learning JavaScript Design Patterns"));
    }

    @Test
    public void testDelete() throws InterruptedException {
       bookSt.deleteAll();
    }

}
