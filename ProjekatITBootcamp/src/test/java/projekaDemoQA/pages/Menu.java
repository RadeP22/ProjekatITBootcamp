package projekaDemoQA.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Menu {

    public final String url = "https://demoqa.com/menu";
    public WebDriverManager wdm;
    public WebDriver driver;
    public WebDriverWait wdw;
    JavascriptExecutor js;


    public Menu(WebDriverManager wdm, WebDriver driver, WebDriverWait wdw, JavascriptExecutor js) {
        this.wdm = wdm;
        this.driver = driver;
        this.wdw = wdw;
        this.js = js;
    }

    By mainItem2 = By.linkText("Main Item 2");

    public WebElement getItem(){
        return driver.findElement(mainItem2);
    }

    public List<WebElement> getSubMenu(){
        Select slc = new Select(getItem());
        return slc.getOptions();
    }

    public void clickItem(){
        getItem().click();
    }

}
