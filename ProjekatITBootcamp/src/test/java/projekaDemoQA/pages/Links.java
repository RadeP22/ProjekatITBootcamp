package projekaDemoQA.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Links {

    public final String url = "https://demoqa.com/links";

    public WebDriverManager wdm;
    public WebDriver driver;

    By simpleLink = By.id("simpleLink");
    By dynamicLink = By.id("dynamicLink");
    By createdLink = By.id("created");
    By noContent = By.id("no-content");
    By movedLink = By.id("moved");
    By badRequest = By.id("bad-request");
    By unouthorised = By.id("unauthorized");
    By forbiden = By.id("forbidden");
    By invalidUrl = By.id("invalid-url");
    public By response = By.id("linkResponse");


    public Links(WebDriverManager wdm, WebDriver driver) {
        this.wdm = wdm;
        this.driver = driver;
    }

    public WebElement getSimpleLink(){
        return driver.findElement(simpleLink);
    }

    public WebElement getDinamicLink(){
        return driver.findElement(dynamicLink);
    }

    public WebElement getCreatedLink(){
        return driver.findElement(createdLink);
    }

    public WebElement getNoContentLink(){
        return driver.findElement(noContent);
    }

    public WebElement getMovedLink(){
        return driver.findElement(movedLink);
    }

    public WebElement getBadRequestLink(){
        return driver.findElement(badRequest);
    }

    public WebElement getUnauthorisedLink(){
        return driver.findElement(unouthorised);
    }

    public WebElement getForbidenLink(){
        return driver.findElement(forbiden);
    }

    public WebElement getNotFoundLink(){
        return driver.findElement(invalidUrl);
    }

    public WebElement getResponse(){
        return driver.findElement(response);
    }

    public void clickLink(WebElement link){
        link.click();
    }



}
