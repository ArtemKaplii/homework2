package objects;

import objects.notepadlogic;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NotepadBasicTest2 {
    WebDriver driver;
    notepadlogic np;
    public static final String loginFailAlert = "Email and password do not match";
    //public static final By SettingsButtonVerifyed = By.xpath("//span[contains(.,'Settings')]");
    public static final boolean pass = true;
    public static final String changePasswordAlert = "Password successfully reset";

    @Before
    public void openBrowser()
    {
        driver = new ChromeDriver();
        np = new notepadlogic(driver);
    }

    @Test
    public void positiveAutherizationTest () {
        np.open();
        np.correctAuthorizationDataInput("artemiuss120@gmail.com","Artem_1987");
        np.Checkin();
        np.settingsPagePresence();
        Assert.assertEquals(pass,np.settingsPagePresence());

    }

    @Test
    public void negativeAuthorizationTest () {
        np.open();
        np.IncorrectAuthorizationDataInput("artmail.ru", "123456");
        np.Checkin();
        np.loginFailAlert();
        Assert.assertEquals(loginFailAlert,np.loginFailAlert());
    }

    @Test
    public void changePasswordAbilityTesting () {
        np.correctAuthorizationDataInput("artemiuss120@gmail.com","Artem_1987");
        np.loadSettingsPage();
        np.changeUserPassword("Artem_1986");
        Assert.assertEquals(changePasswordAlert,np.passwordResetStatementAppear());
    }

    @After
    public void closeBrowser()
        {
            driver.quit();
        }
    }