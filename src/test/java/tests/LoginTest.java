package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.ContactListScreen;
import screens.SplashScreen;

public class LoginTest extends AppiumConfig {

    @Test
    public void loginSuccess(){

        boolean res =new SplashScreen(driver)
                .gotoAuthentificationScreen()
                .fillEmail("vova@gmail.com")
                .fillPassword("Vova1234$")
                .submitLogin()
                .isContactListActivityPresent();
        Assert.assertTrue(res);
    }
    @Test
    public void loginSuccessModel(){
        boolean res=new SplashScreen(driver)
                .gotoAuthentificationScreen()
                .login(Auth.builder()
                        .email("vova@gmail.com")
                        .password("Vova1234$")
                        .build())
                .isContactListActivityPresent();
        Assert.assertTrue(res);
    }
    @AfterMethod
    public void postCondition(){
        new ContactListScreen(driver).logout();
        new SplashScreen(driver);
    }
}
