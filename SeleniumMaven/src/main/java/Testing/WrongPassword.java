package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Random;


public class WrongPassword extends BaseClass{


    @Test
       public void WrongPassword() throws InterruptedException {

        driver.get("https://www.sololearn.com/users/login");
        Thread.sleep(4000);
        WebElement Ok = driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonAccept"));
        Ok.click();

        WebElement username = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement login=driver.findElement(By.className("sl-login-login-form__action"));

        Random randomUsername = new Random();
        int randomNumbers = randomUsername.nextInt();

        username.sendKeys("test" + randomNumbers + "@sololearn.com");
        password.sendKeys("1234567");
        login.click();

        String ExpectedErrorMessage = "Invalid username or password.";
        Thread.sleep(4000);
        String ActualErrorMessage = driver.findElement(By.cssSelector("[class='sl-login-error']")).getText();
        Thread.sleep(4000);

        Assert.assertEquals(ExpectedErrorMessage, ActualErrorMessage);

    }

}
