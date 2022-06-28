package projekaDemoQA.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class WebTables {

    public final String url = "https://demoqa.com/webtables";
    public WebDriverManager wdm;
    public WebDriver driver;
    public Actions act;

    public WebTables(WebDriverManager wdm, WebDriver driver, Actions act) {
        this.wdm = wdm;
        this.driver = driver;
        this.act = act;
    }





    By addButton = By.id("addNewRecordButton");
    By searchBox = By.id("searchBox");
    By addOn = By.id("basic-addon2");
    By headerRow = By.className("rt-resizable-header-content");
    By tableRows = By.className("-odd");
    By edit = By.id("edit-record-1");
    By delete = By.id("delete-record-1");
    By pageOptions= By.className("-pageSizeOptions");
    By rowsPPage = By.tagName("select");
    By firstName = By.id("firstName");
    By lastName = By.id("lastName");
    By email = By.id("userEmail");
    By age = By.id("age");
    By salary = By.id("salary");
    By department = By.id("department");
    By submit = By.id("submit");


    public WebElement getAddButton(){
        return driver.findElement(addButton);
    }

    public WebElement getSearchBox(){
        return driver.findElement(searchBox);
    }

    //VEROVATNO NIJE POTREBNO
    public WebElement getAddOn(){
        return driver.findElement(addOn);
    }

    public List<WebElement> getHeaderRow(){
        return driver.findElements(headerRow);
    }

    public List<WebElement> getTableRows(){
        List<WebElement> rows = driver.findElements(tableRows);
        return rows;
    }

    public WebElement getEdit(){
        return driver.findElement(edit);
    }

    public WebElement getDelete(){
        return driver.findElement(delete);
    }

    //OVO CE MOZDA TREBATI!!
    public List<WebElement> getSecondRow(){
        List<WebElement> rows = getTableRows();
        return rows.get(0).findElements(By.cssSelector("div[role = \"gridcell\"]"));
    }

    public List<WebElement> getRowPerPage(){
        WebElement parentDiv = driver.findElement(pageOptions);
        Select rowPPage = new Select(parentDiv.findElement(rowsPPage));
        return rowPPage.getOptions();
    }

    public WebElement getFirstName(){
        return driver.findElement(firstName);
    }
    public WebElement getLastName(){
        return driver.findElement(lastName);
    }
    public WebElement getEmail(){
        return driver.findElement(email);
    }
    public WebElement getAge(){
        return driver.findElement(age);
    }
    public WebElement getSalary(){
        return driver.findElement(salary);
    }
    public WebElement getDepartment(){
        return driver.findElement(department);
    }
    public WebElement getSubmit(){
        return driver.findElement(submit);
    }

    //VEROVATNO NIJE POTREBNO
    public void clickAddButton(){
        getAddButton().click();
    }

    public void searchVega(){
        getSearchBox().sendKeys("Vega");
    }

    //VIDETI ZASTO NE RADI ACTIONS KAKO ZELIM
    public void editRecord(){
       getEdit().click();
       act.moveToElement(getFirstName()).doubleClick().build().perform();
       getFirstName().sendKeys("Frida");
       getSubmit().click();
    }

    public void deleteRecord(){
        getDelete().click();
    }

    public void registration(){
        getAddButton().click();
        getFirstName().sendKeys("Frida");
        getLastName().sendKeys("Kahlo");
        getEmail().sendKeys("frida@kahlo.com");
        getAge().sendKeys("23");
        getSalary().sendKeys("1000");
        getDepartment().sendKeys("Social");
        getSubmit().click();
    }

}
