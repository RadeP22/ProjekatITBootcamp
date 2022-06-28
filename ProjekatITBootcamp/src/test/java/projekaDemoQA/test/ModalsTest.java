package projekaDemoQA.test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import projekaDemoQA.base.BasePage;

public class ModalsTest extends BasePage {

    @BeforeMethod
    public void setUp(){
        driver.navigate().to(modals.url);
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }

    @Test
    public void testSmallModal(){
        modals.clickSmallModal();
        Assert.assertTrue(modals.getModal().isDisplayed());
    }

    @Test
    public void testLargeModal(){
        modals.clickLargeModal();
        Assert.assertTrue(modals.getModal().isDisplayed());
    }

}
