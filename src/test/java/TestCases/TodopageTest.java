package TestCases;

import APIs.RegisterApi;
import APIs.TaskApi;
import Pages.Login;
import Pages.Newtodopage;
import Pages.Todopage;
import Bases.TestsBase;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
@Feature("Todo Feature")

public class TodopageTest extends TestsBase {
    Login login;
    @Story("Add Todo")
    @Test (description = "Should be able to add a new todo correctly")
    public void AddToDoItem() throws InterruptedException{
        RegisterApi registerApi=new RegisterApi();
        registerApi.register();
        Newtodopage newtodopage=new Newtodopage(getDriver());
        newtodopage.load();
        injectCookiesToBrowser(registerApi.getCookie());
         String Expected =newtodopage.load()
                 .AddNewTodoItem("Learn Selenium")
                 .TodoItemText();
        Assert.assertEquals("Learn Selenium",Expected);

    }
    @Story("Delete Todo")
    @Test (description = "Should be able to delete a todo correctly")
    public void DeleteToDoItem() throws InterruptedException{
    RegisterApi registerApi=new RegisterApi();
    registerApi.register();
    TaskApi taskApi=new TaskApi();
    taskApi.addTask(registerApi.getAccessToken());
    Todopage todopage=new Todopage(getDriver());
    todopage.load();
    injectCookiesToBrowser(registerApi.getCookie());
    boolean Actual=todopage
            .load()
            .DelteNewItem()
            .NotAvaIsDisplay();

    Assert.assertTrue(Actual);


}

}
