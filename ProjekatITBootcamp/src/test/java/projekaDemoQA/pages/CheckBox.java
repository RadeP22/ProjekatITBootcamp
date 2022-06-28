package projekaDemoQA.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBox {

    public final String url = "https://demoqa.com/checkbox";
    public WebDriverManager wdm;
    public WebDriver driver;

    public CheckBox(WebDriverManager wdm, WebDriver driver) {
        this.wdm = wdm;
        this.driver = driver;
    }

    By toggle = By.className("rct-collapse-btn");
    By checkbox = By.className("rct-checkbox");
    By selected = By.className("text-success");
    By expand = By.className("rct-icon-expand-all");
    By collapse = By.className("rct-icon-collapse-all");

    public WebElement getToggle(){
        return driver.findElement(toggle);
    }

    public WebElement getCheckbox(){
        return driver.findElement(checkbox);
    }
    public List<WebElement> getTitles(){
        return driver.findElements(By.className("rct-title"));
    }

    public List<WebElement> getSelected(){
        return driver.findElements(selected);
    }

    public WebElement getExpand(){
        return driver.findElement(expand);
    }

    public WebElement getCollapse(){
        return driver.findElement(collapse);
    }

    public void clickToggle(){
        getToggle().click();
    }

    public void clickCheckBox(){
        getCheckbox().click();
    }

    public void clickExpand(){
        getExpand().click();
    }

    public void clickCollapse(){
        getCollapse().click();
    }

}
