package Pages;

import Config.EndPoint;
import Bases.PageBase;
import Utils.ConfigUtils;
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
    public Todopage load(){
        driver.get(ConfigUtils.getInstance().getbaseUrl() + EndPoint.TODO_PAGE_TASK_ENDPOINT);
        return this;

    }
    public boolean IsWelcomeMessageeDisplay(){
        return Welcome.isDisplayed();
    }
    public Newtodopage AddButton() throws InterruptedException{
        AddButton.click();
        Thread.sleep(2000);
        return new Newtodopage(driver);

    }
    public boolean NotAvaIsDisplay(){
        return NOAvailableToDO.isDisplayed();

    }
    public String TodoItemText(){

        return ToDoItem.getText();
    }
    public Todopage DelteNewItem(){
        DeleteItem.click();
        return new Todopage(driver);
    }

}
