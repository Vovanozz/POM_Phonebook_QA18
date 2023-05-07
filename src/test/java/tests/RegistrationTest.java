package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.BaseScreen;
import screens.ContactListScreen;
import screens.SplashScreen;

public class RegistrationTest extends AppiumConfig {

    @Test
    public void registrationSuccessTest(){
        int i= (int) ((System.currentTimeMillis()/1000)%3600);
        boolean res= new SplashScreen(driver)
                .gotoAuthentificationScreen()
                .registration(Auth.builder()
                        .email("vovan"+i+"@gmail.com")
                        .password("Vovan12345$")
                        .build())
                .isContactListActivityPresent();
        Assert.assertTrue(res);



    }
    @Test
    public void regNegativeTestEmail(){
            int i= (int) ((System.currentTimeMillis()/1000)%3600);
            boolean res= new SplashScreen(driver)
                    .gotoAuthentificationScreen()
                    .registration(Auth.builder()
                            .email("vovan"+i+"gmail.com")
                            .password("Vovan12345$")
                            .build())
                    .registrationErrorFromEmailIsPresent();
            Assert.assertTrue(res);
    } @Test
    public void regNegativeTestPassword(){
            int i= (int) ((System.currentTimeMillis()/1000)%3600);
            boolean res= new SplashScreen(driver)
                    .gotoAuthentificationScreen()
                    .registration(Auth.builder()
                            .email("vovan"+i+"@gmail.com")
                            .password("vovan12345")
                            .build())
                            .registrationErrorFromPasswordIsPresent();
                     Assert.assertTrue(res);

    }
//    @AfterMethod
//    public void postCondition(){
//        new ContactListScreen(driver).logout();
//        new SplashScreen(driver);
//    }
}
