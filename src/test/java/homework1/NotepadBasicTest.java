package homework1;

import com.sun.javafx.applet.ExperimentalExtensions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotepadBasicTest {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void openBrowser()
    {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 5);
    }

    @Test
    public void notepadtest () {
        driver.get("https://anotepad.com/");
        driver.findElement(By.id("edit_title")).sendKeys("My First Note");
        driver.findElement(By.id("btnSaveNote")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".alert-warning"),"You have saved your note as a "));
        driver.findElement(By.cssSelector(".delete")).click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert();
        alert.accept();
        Assert.assertEquals("No note here.", driver.findElement(By.cssSelector(".saved_notes")).getText());
    }

    @After
    public void closeBrowser()
        {

            driver.quit();

        }
    }