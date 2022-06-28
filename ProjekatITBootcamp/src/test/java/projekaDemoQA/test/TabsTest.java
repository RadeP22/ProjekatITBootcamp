package projekaDemoQA.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import projekaDemoQA.base.BasePage;

public class TabsTest extends BasePage {

    @BeforeMethod
    public void setUp(){
        driver.navigate().to(tabs.url);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void testWhatTab(){
        tabs.clickWhatTab();
        Assert.assertTrue(tabs.getParagraps().get(0).isDisplayed());
    }

    @Test
    public void testOriginTab(){
        tabs.clickOriginTab();
        Assert.assertTrue(tabs.getParagraps().get(1).isDisplayed());
    }

    @Test
    public void testUseTab(){
        tabs.clickUseTab();
        Assert.assertTrue(tabs.getParagraps().get(2).isDisplayed());
    }

}
