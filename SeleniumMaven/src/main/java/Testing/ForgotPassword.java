package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ForgotPassword extends BaseClass{


    @Test
    public void WrongPassword() throws InterruptedException {

        driver.get("https://www.sololearn.com/users/login");
        Thread.sleep(4000);
        WebElement Ok = driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonAccept"));
        Ok.click();

        WebElement ForgotPassword = driver.findElement(By.className("sl-login-login-form__forgot-pass"));
        ForgotPassword.click();

        String ExpectedForgotPasswordURL = "https://www.sololearn.com/User/ForgotPassword/";
        String ActualForgotPasswordURL = driver.getCurrentUrl();
        Assert.assertEquals(ExpectedForgotPasswordURL, ActualForgotPasswordURL);

        WebElement ForgotPasswordEmail = driver.findElement(By.id("Email"));
        WebElement RecoverButton = driver.findElement(By.cssSelector("[class = 'formActions'] [class = 'materialButton primary elevated']"));

        ForgotPasswordEmail.sendKeys("ani.balyan@sololearn.com");
        Thread.sleep(3000);
        RecoverButton.click();
        String ActualMessageEmailSent = driver.findElement(By.cssSelector("div.block p")).getText();
        String ExpectedMessageEmailSent = "We just sent you an email containing further instructions.";
        Assert.assertEquals(ActualMessageEmailSent, ExpectedMessageEmailSent );



    }
}