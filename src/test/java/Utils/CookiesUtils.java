package Utils;

import io.restassured.http.Cookie;

import java.util.ArrayList;
import java.util.List;

public class CookiesUtils {

    public static List<org.openqa.selenium.Cookie> restAssuredCookiesToSelenium(List<Cookie>restAssured){
        List<org.openqa.selenium.Cookie>seleniumCookies=new ArrayList<>();
        for ( Cookie cookie:restAssured){
            org.openqa.selenium.Cookie seleniumCookie= new org.openqa.selenium.Cookie(cookie.getName(),cookie.getValue());
            seleniumCookies.add(seleniumCookie);
        }
        return seleniumCookies;

    }

}
