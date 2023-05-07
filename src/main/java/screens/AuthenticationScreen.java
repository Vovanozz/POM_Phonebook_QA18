package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.Auth;
import org.openqa.selenium.support.FindBy;

public class AuthenticationScreen extends BaseScreen{

    public AuthenticationScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

@FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputEmail']")
    MobileElement editTextEmail;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputPassword']")
    MobileElement editTextPassword;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/regBtn']")
    MobileElement registrationButton;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/loginBtn']")
    MobileElement loginButton;
    @FindBy(xpath = "//*[@resource-id='android:id/button1']")
    MobileElement clickOkButtonFromErrorMessage;


public AuthenticationScreen fillEmail(String email){
    waitElement(editTextEmail,5);
    type(editTextEmail,email);
    return this;
}
public AuthenticationScreen fillPassword(String password){
    type(editTextPassword,password);
    return this;
}
public ContactListScreen submitLogin(){
    loginButton.click();
    return new ContactListScreen(driver);

}public ContactListScreen submitRegistration(){
    registrationButton.click();
    return new ContactListScreen(driver);

}public ContactListScreen clickOkErrorMessage(){
    clickOkButtonFromErrorMessage.click();
    return new ContactListScreen(driver);
}

public ContactListScreen login(Auth auth){
    waitElement(editTextEmail,5);
    type(editTextEmail,auth.getEmail());
    type(editTextPassword,auth.getPassword());
    loginButton.click();
    return new ContactListScreen(driver);

}public ContactListScreen registration(Auth auth){
    waitElement(editTextEmail,5);
    type(editTextEmail,auth.getEmail());
    type(editTextPassword,auth.getPassword());
    registrationButton.click();
    return new ContactListScreen(driver);

}


}
