package Pages;

import Config.EndPoint;
import Bases.PageBase;
import Utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Todopage extends PageBase {

    public Todopage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//h2[@data-testid=\"welcome\"]")
    private WebElement Welcome ;
    @FindBy(css = "[data-testid=\"add\"]")
    private WebElement AddButton ;
    @FindBy(xpath = "//h4[@data-testid=\"no-todos\"]")
    private WebElement NOAvailableToDO ;
    @FindBy(xpath = "//div[@data-testid=\"todo-item\"]")
    private WebElement ToDoItem ;
    @FindBy(xpath = "//button[@data-testid=\"delete\"]")
    private WebElement DeleteItem;
    @Step
    public Todopage load(){
        driver.get(ConfigUtils.getInstance().getbaseUrl() + EndPoint.TODO_PAGE_TASK_ENDPOINT);
        return this;

    }
    @Step
    public boolean IsWelcomeMessageeDisplay(){
        return Welcome.isDisplayed();
    }
    @Step
    public Newtodopage AddButton() throws InterruptedException{
        AddButton.click();
        Thread.sleep(2000);
        return new Newtodopage(driver);

    }
    @Step
    public boolean NotAvaIsDisplay(){
        return NOAvailableToDO.isDisplayed();

    }
    @Step
    public String TodoItemText(){

        return ToDoItem.getText();
    }
    @Step
    public Todopage DelteNewItem(){
        DeleteItem.click();
        return new Todopage(driver);
    }

}
