package projekaDemoQA.test;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import projekaDemoQA.base.BasePage;

import java.util.List;

public class MenuTest extends BasePage {

    @BeforeMethod
    public void setUp(){
        driver.navigate().to(menu.url);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void testItem(){
        menu.clickItem();
        List<WebElement> list = menu.getSubMenu();
        for(WebElement w : list)
            System.out.println(w.getText());
    }

}
