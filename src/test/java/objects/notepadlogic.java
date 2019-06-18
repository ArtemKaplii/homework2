package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class notepadlogic {

private static final By Email = By.id("loginEmail");
private static final By Password = By.xpath("//*[@id='password'][last()]");
private static final By Login = By.xpath("//*[@id='submit']");
//private static final By CreateFolder = By.id("");

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

public notepadlogic Email (String username)
{
    driver.findElement(Email).sendKeys(username);
    return this;
}

    public notepadlogic Password (String key)
    {
        driver.findElement(Password).sendKeys(key);
        return this;
    }
    public notepadlogic Checkin ()
    {
        driver.findElement(Login).click();
        return this;
    }

}