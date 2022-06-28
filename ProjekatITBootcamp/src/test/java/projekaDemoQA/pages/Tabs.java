package projekaDemoQA.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Tabs {

    public final String url = "https://demoqa.com/tabs";
    public WebDriverManager wdm;
    public WebDriver driver;
    public WebDriverWait wdw;
    JavascriptExecutor js;


    public Tabs(WebDriverManager wdm, WebDriver driver, WebDriverWait wdw, JavascriptExecutor js) {
        this.wdm = wdm;
        this.driver = driver;
        this.wdw = wdw;
        this.js = js;
    }

    By whatTab = By.id("demo-tab-what");
    By originTab = By.id("demo-tab-origin");
    By useTab = By.id("demo-tab-use");
    By moreTab = By.id("demo-tab-more");
    By paragraphs = By.className("mt-3");

    public WebElement getWhatTab(){
        return driver.findElement(whatTab);
    }

    public WebElement getOriginTab(){
        return driver.findElement(originTab);
    }

    public WebElement getUseTab(){
        return driver.findElement(useTab);
    }

    public WebElement getMoreTab(){
        return driver.findElement(moreTab);
    }

    public List<WebElement> getParagraps(){
        return driver.findElements(paragraphs);
    }

    public void clickWhatTab(){
        getWhatTab().click();
    }

    public void clickOriginTab(){
        getOriginTab().click();
    }

    public void clickUseTab(){
        getUseTab().click();
    }

    public void clickMoreTab(){
        getMoreTab().click();
    }

}
