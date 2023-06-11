package Pages;

import Config.EndPoint;
import Bases.PageBase;
import Utils.ConfigUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Newtodopage extends PageBase {
    public Newtodopage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@data-testid=\"new-todo\"]")
    private WebElement NewTodo ;
    @FindBy(xpath = "//button[@data-testid=\"submit-newTask\"]")
    private WebElement SubmitNewTask ;

    public Newtodopage load(){
        driver.get(ConfigUtils.getInstance().getbaseUrl() + EndPoint.NEW_TODO_PAGE_TASK_ENDPOINT);
        return this;
    }


    public Todopage AddNewTodoItem(String Item) throws InterruptedException{
        NewTodo.sendKeys(Item);
        SubmitNewTask.click();
        Thread.sleep(2000);
        return new Todopage(driver);
    }



}
