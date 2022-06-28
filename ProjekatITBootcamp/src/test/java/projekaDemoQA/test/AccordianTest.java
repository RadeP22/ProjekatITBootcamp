package projekaDemoQA.test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import projekaDemoQA.base.BasePage;

public class AccordianTest extends BasePage {

    @BeforeMethod
    public void setUp(){
        driver.navigate().to(acord.url);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void testHeader1(){
        acord.clickHeader(0);
        wdw.until(ExpectedConditions.invisibilityOf(acord.getContent1()));
        Assert.assertFalse(acord.getContent1().isDisplayed());
    }

    @Test
    public void testHeader2(){
        js.executeScript("window.scrollTo(0,500)");
        acord.clickHeader(1);
        Assert.assertTrue(acord.getContent2().isDisplayed());
    }

    @Test
    public void testHeader3(){
        js.executeScript("window.scrollTo(0,500)");
        acord.clickHeader(2);
        Assert.assertTrue(acord.getContent3().isDisplayed());
    }

}
