package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class ContactListScreen extends BaseScreen{
    public ContactListScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
@FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/action_bar']/android.widget.TextView")
MobileElement activityViewText;
    @FindBy(xpath = "//*[@content-desc='More options']")
MobileElement moreOptions;
    @FindBy(xpath ="//*[@resource-id='com.sheygam.contactapp:id/add_contact_btn']")
MobileElement addContactButton;
    @FindBy(xpath ="//*[@resource-id='com.sheygam.contactapp:id/title']")
MobileElement logoutButton;
    @FindBy(xpath ="//*[@resource-id='android:id/message']")
MobileElement alertEmailMessage;
    @FindBy(xpath ="//*[@resource-id='android:id/message']")
MobileElement alertPasswordMessage;


    public boolean isContactListActivityPresent(){
        return shouldHave(activityViewText,"Contact list",5);
    }
    public boolean registrationErrorFromEmailIsPresent(){
        return shouldHave(alertEmailMessage,"{username=must be a well-formed email address}",5);

    }public boolean registrationErrorFromPasswordIsPresent(){
        return shouldHave(alertPasswordMessage,"{password= At least 8 characters; " +
                "Must contain at least 1 uppercase letter, 1 lowercase letter," +
                " and 1 number; Can contain special characters [@$#^&*!]}",5);
    }
public AuthenticationScreen logout(){
   moreOptions.click();
   logoutButton.click();
   return new AuthenticationScreen(driver);
}
}

