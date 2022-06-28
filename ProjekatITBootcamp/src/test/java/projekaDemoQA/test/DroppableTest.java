package projekaDemoQA.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import projekaDemoQA.base.BasePage;

public class DroppableTest extends BasePage {

    @BeforeMethod
    public void setUp(){
        driver.navigate().to(drop.url);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void testDrop(){
        drop.drop();
    }

    @Test
    public void testReverseDrop() throws InterruptedException {
        drop.reverseDrop();
    }

}
