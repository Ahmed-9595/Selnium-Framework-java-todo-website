package TestCases;

import Pages.Login;
import Pages.Todopage;
import Bases.TestsBase;
import Utils.ConfigUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestsBase {
    Login login;
    @Test
    public void Login() throws InterruptedException{
        login = new Login(getDriver());
        Todopage todopage =login
                .load()
                .ValidLogin(ConfigUtils.getInstance().getEmail(),ConfigUtils.getInstance().getPassword());
        Assert.assertTrue(todopage.IsWelcomeMessageeDisplay());
    }
}