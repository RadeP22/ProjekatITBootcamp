package projekaDemoQA.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Droppable {

    public final String url = "https://demoqa.com/droppable";
    public WebDriverManager wdm;
    public WebDriver driver;
    public WebDriverWait wdw;
    Actions act;


    public Droppable(WebDriverManager wdm, WebDriver driver, WebDriverWait wdw, Actions act) {
        this.wdm = wdm;
        this.driver = driver;
        this.wdw = wdw;
        this.act = act;
    }

    By draggable = By.id("draggable");
    By dropable = By.id("droppable");
    By accept = By.id("droppableExample-tab-accept");
    By preventPropogation = By.id("droppableExample-tab-preventPropogation");
    By revertDraggable = By.id("droppableExample-tab-revertable");

    public WebElement getDraggable(){
        return driver.findElement(draggable);
    }

    public WebElement getDropable(){
        return driver.findElement(dropable);
    }

    public WebElement getAccept(){
        return driver.findElement(accept);
    }

    public WebElement getPreventPropogation(){
        return driver.findElement(revertDraggable);
    }

    public WebElement getRevertDraggable(){
        return driver.findElement(preventPropogation);
    }

    public void drop(){
        act.dragAndDrop(getDraggable(),getDropable());
    }

    public void reverseDrop() throws InterruptedException {
        getRevertDraggable().click();
        Thread.sleep(2000);
        act.dragAndDrop(getDraggable(),getDropable());
    }

}
