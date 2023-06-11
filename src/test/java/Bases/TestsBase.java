package Bases;

import Factory.FactoryPage;
import Utils.CookiesUtils;
import io.restassured.http.Cookie;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestsBase {
    protected ThreadLocal <WebDriver> driver= new ThreadLocal<>() ;
    public void setDriver(WebDriver driver){
        this.driver.set(driver);
    }
    public WebDriver getDriver(){
        return this.driver.get();
    }
    @BeforeMethod
    public void setup(){
        WebDriver driver=new FactoryPage().Intialization();
        setDriver(driver);

    }
@AfterMethod
    public void TearDown(ITestResult result){

        String testCaseResult= result.getMethod().getMethodName();
        File fileDest = new File("Screenshots"+ File.separator+"snapshots"+File.separator+testCaseResult+".png");
        TakeScreenshots(fileDest);

        getDriver().quit();
}

public void injectCookiesToBrowser(List<Cookie>resTAssuredCookie){
        List<org.openqa.selenium.Cookie>seleniumCookies= CookiesUtils.restAssuredCookiesToSelenium(resTAssuredCookie)   ;
        for (org.openqa.selenium.Cookie cookie:seleniumCookies){
            getDriver().manage().addCookie(cookie);
    }
}
public void TakeScreenshots(File fileDest){
        File file = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
    try {
        FileUtils.copyFile(file,fileDest);

    } catch (IOException e) {
        throw new RuntimeException(e);
    }


}


}
