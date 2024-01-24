package Pages_Package;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageClass
{

    public void Login_HomePage_Verification( WebDriver driver)
    {

        //Entering name, password and click on login
        WebElement username = driver.findElement(By.id("UserName"));
        username.sendKeys("Hari");


        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("123123");


        WebElement click_submit = driver.findElement(By.xpath("//input[@type='submit']"));
        click_submit.click();

        //Verify logged in or nor

        WebElement verificationText = driver.findElement(By.xpath("//*[@id='logoutForm']/ul/li/a"));
        String Text_Verify = verificationText.getText();
        Assert.assertEquals(Text_Verify , "Hello hari!", "TurnUp Potal Logged in Successfully");

    }

}

