package projekaDemoQA.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Accordian {

    public final String url = "https://demoqa.com/accordian";
    public WebDriverManager wdm;
    public WebDriver driver;
    public WebDriverWait wdw;
    JavascriptExecutor js;


    public Accordian(WebDriverManager wdm, WebDriver driver, WebDriverWait wdw, JavascriptExecutor js) {
        this.wdm = wdm;
        this.driver = driver;
        this.wdw = wdw;
        this.js = js;
    }

    By cardHeaders = By.className("card-header");
    By content1 = By.id("section1Content");
    By content2 = By.id("section2Content");
    By content3 = By.id("section3Content");

    public List<WebElement> getCardheaders(){
        return driver.findElements(cardHeaders);
    }

    public WebElement getContent1(){
        return driver.findElement(content1);

    }

    public WebElement getContent2(){
        return driver.findElement(content2);
    }

    public WebElement getContent3(){
        return driver.findElement(content3);
    }

    public void clickHeader(int number){
        getCardheaders().get(number).click();
    }

}
