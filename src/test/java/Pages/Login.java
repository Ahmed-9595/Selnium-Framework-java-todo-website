package Pages;

import Bases.PageBase;
import Utils.ConfigUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends PageBase {

    public Login(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@data-testid=\"email\"]")
    private WebElement Mail;
    @FindBy(xpath = "//input[@data-testid=\"password\"]")
    private WebElement Pass;
    @FindBy(xpath = "//button[@data-testid=\"submit\"]")
    private WebElement Submit;


    public Login load(){
        driver.get(ConfigUtils.getInstance().getbaseUrl());
        return this;
    }
    public Todopage ValidLogin(String Email, String Password) throws InterruptedException{
        Mail.sendKeys(Email);
        Pass.sendKeys(Password);
        Submit.click();
        Thread.sleep(2000);
        return new Todopage(driver) ;

    }





}
