package projekaDemoQA.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Buttons {

    public final String RadioURL = "https://demoqa.com/radio-button";
    public final String ButtonsURL = "https://demoqa.com/buttons";
    public final String DinamicURL = "https://demoqa.com/dynamic-properties";
    public WebDriverManager wdm;
    public WebDriver driver;
    public WebDriverWait wdw;
    public JavascriptExecutor js;
    public Actions act;
    private WebElement dynBtn;

    public Buttons(WebDriverManager wdm, WebDriver driver, WebDriverWait wdw, Actions act, JavascriptExecutor js) {
        this.wdm = wdm;
        this.driver = driver;
        this.wdw = wdw;
        this.act = act;
        this.js = js;
    }

    By radioBtn = By.className("custom-control-label");
    By message = By.className("text-success");
    By dblClickBtn = By.id("doubleClickBtn");
    By rghClickBtn = By.id("rightClickBtn");
    By clickBtn = By.className("W8NyV");
    By dblClickMessage = By.id("doubleClickMessage");
    By DynClickMessage = By.id("dynamicClickMessage");
    By enableBtn = By.id("enableAfter");
    By changeBtn = By.id("colorChange");
    By afterBtn = By.id("visibleAfter");

    public List<WebElement> getRadioButtons() {
        return driver.findElements(radioBtn);
    }
    public WebElement getMessage() {
        return driver.findElement(message);
    }

    public WebElement getDoubleClickBtn() {
        return driver.findElement(dblClickBtn);
    }

    public WebElement getRightClickBtn() {
        return driver.findElement(rghClickBtn);
    }

    public WebElement getClickBtn() {
        List<WebElement> buttons = driver.findElements(By.className("btn-primary"));
        for(WebElement w : buttons) {
            if (w.getText().equals("Click Me"))
                dynBtn = w;
        }
        return dynBtn;
    }

    public WebElement getdblClickMessage() {
        return driver.findElement(dblClickMessage);
    }

    public WebElement getDynClickMessage() {
        return driver.findElement(DynClickMessage);
    }

    public WebElement getEnableButton(){
        return driver.findElement(enableBtn);
    }

    public WebElement getChangeButton(){
        return driver.findElement(changeBtn);
    }

    public WebElement getAfterButton(){
        return driver.findElement(afterBtn);
    }


    public void firstRadio(){
        getRadioButtons().get(0).click();
    }

    public void secondRadio(){
        getRadioButtons().get(1).click();
    }

    public void thirdRadio(){
        getRadioButtons().get(2).click();
    }

    public void doubleClick(){
       act.doubleClick(getDoubleClickBtn()).build().perform();
    }

    public void rightClick(){
        act.contextClick(getRightClickBtn()).build().perform();
    }

    public void dynamicClick(){
        getClickBtn().click();
    }

    public void clickEnabledBtn(){
        wdw.until(ExpectedConditions.elementToBeClickable(getEnableButton()));
        getEnableButton().click();
    }

    public void clickChangeBtn(){
        getChangeButton().click();
    }

    public void clickAfterBtn(){
        js.executeScript("window.scrollTo(0, 500)");
        wdw.until(ExpectedConditions.presenceOfElementLocated(afterBtn));
        getAfterButton().click();
    }

}
