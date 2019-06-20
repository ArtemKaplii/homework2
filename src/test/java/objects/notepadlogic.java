package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class notepadlogic {

private static final By Email = By.id("loginEmail");
private static final By Password = By.xpath("//*[@placeholder='Enter Password']");
private static final By Login = By.xpath("//button[text()='Login']");
private static final By SettingsButton = By.xpath("//span[contains(.,'Settings')]");
private static final By changePasswordField = By.cssSelector("#password");
private static final By confirmChangePasswordField = By.cssSelector("#password_confirm");
private static final By updatePasswordButton = By.name("submit");


private WebDriver driver;
private WebDriverWait wait;

public notepadlogic (WebDriver driver)
{
    this.driver = driver;
    this.wait = new WebDriverWait(this.driver, 5);
}

public notepadlogic open ()
{
    driver.get("https://anotepad.com/create_account/");
    return this;
}

public notepadlogic correctAuthorizationDataInput (String validUsername,String validPassword)
    {
        driver.findElement(Email).sendKeys(validUsername);
        driver.findElement(Password).sendKeys(validPassword);
        return this;
    }

    public notepadlogic Checkin ()
    {
        driver.findElement(Login).click();
        return this;
    }

    public notepadlogic settingsPagePresence ()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(SettingsButton));
        return this;
    }

    public notepadlogic loadSettingsPage ()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(SettingsButton));
        driver.findElement(By.xpath("//span[contains(.,'Settings')]")).click();
        return this;
    }

    public notepadlogic IncorrectAuthorizationDataInput (String wronglogin, String wrongpass)
    {
        driver.findElement(Email).sendKeys(wronglogin);
        driver.findElement(Password).sendKeys(wrongpass);
        return this;
    }

    public notepadlogic changeUserPassword (String newPass)
    {
        driver.findElement(changePasswordField).sendKeys(newPass);
        driver.findElement(confirmChangePasswordField).sendKeys(newPass);
        driver.findElement(updatePasswordButton).click();
        return this;
    }

    public notepadlogic loginFailAlert ()
    {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".alert alert-danger"),"Email and password do not match"));
        return this;
    }

    public notepadlogic passwordResetStatementAppear ()
    {
        driver.findElement(By.cssSelector(".alert-success")).getText();
        return this;
    }

}