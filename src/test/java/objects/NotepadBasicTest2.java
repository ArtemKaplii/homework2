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

    @Before
    public void openBrowser()
    {
        driver = new ChromeDriver();
        np = new notepadlogic(driver);
    }

    @Test
    public void notepadtest () {
        np.open();
        np.Email("artemiuss120@gmail.com");
        np.Password("Artem_1987");
        np.Checkin();
    }

    @After
    public void closeBrowser()
        {
            driver.quit();
        }
    }