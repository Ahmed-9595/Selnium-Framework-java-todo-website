package TestCases;

import Pages.Login;
import Pages.Todopage;
import Bases.TestsBase;
import Utils.ConfigUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
@Feature("Auth Feature")
public class LoginTest extends TestsBase {
    Login login;
    @Story("Login with Email and Password")
    @Description("It will login by filling the email and the password and navigate to the todo page")
    @Test(description = "Test the login functionality using email and password")
    public void Login() throws InterruptedException{
        login = new Login(getDriver());
        Todopage todopage =login
                .load()
                .ValidLogin(ConfigUtils.getInstance().getEmail(),ConfigUtils.getInstance().getPassword());
        Assert.assertTrue(todopage.IsWelcomeMessageeDisplay());
    }
}