package Pages_Package;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Create_Edit_Del_Class {
    public void Create_Time_And_Material(WebDriver driver ) throws InterruptedException {
        WebElement click_create = driver.findElement(By.xpath("//a[@href='/TimeMaterial/Create']"));
        click_create.click();


        WebElement typeCode = driver.findElement(By.xpath("//span[contains(text(),'Material')]"));
        typeCode.click();
        Thread.sleep(1000 );


        WebElement drop_down_button = driver.findElement(By.xpath("//*[@id=\"TypeCode_listbox\"]/li[2]"));
        drop_down_button.click();



        WebElement codeTextBox = driver.findElement(By.id("Code"));
        codeTextBox.sendKeys("Koshi Jacob 123");


        WebElement descriptionTextBox = driver.findElement(By.id("Description"));
        descriptionTextBox.sendKeys("Automation Demo in Time and Materials");


        WebElement pricePerUnit = driver.findElement(By.xpath("//input[@class='k-formatted-value k-input']"));
        pricePerUnit.sendKeys("20");



        WebElement saveButton = driver.findElement(By.id("SaveButton"));
        saveButton.submit();
        System.out.println("Time and Materials created and submitted");


        //click on lastpage icon and check the given code


        WebElement selectLastPage = driver.findElement(By.xpath("//span[contains(text(),'last page')]"));
        selectLastPage.click();

        WebElement savedData = driver.findElement(By.xpath("//tbody/tr[last()]/td[1]"));
        String data = savedData.getText();
        Assert.assertEquals(data , "Koshi Jacob 123");

    }

    public void Edit_Time_And_Material(WebDriver driver)
    {
        //Edit the given data

        WebElement clickOnEditButton = driver.findElement(By.xpath("//tbody/tr[6]/td[5]/a[1]"));
        clickOnEditButton.click();


        WebElement editCodeType = driver.findElement(By.xpath("//span[contains(text(),'Time')]"));
        editCodeType.click();


        WebElement selectDropDown = driver.findElement(By.xpath("//span[contains(text(),'select')]"));
        selectDropDown.click();


        WebElement editCode = driver.findElement(By.id("Code"));
        editCode.clear();
        editCode.sendKeys("Koshiya Jacob");


        WebElement editDescription = driver.findElement(By.id("Description"));
        editDescription.clear();
        editDescription.sendKeys("Edited Automation Code");


        WebElement editPrice = driver.findElement(By.xpath("//span/input[contains(@class,'formatted-value')]"));
        editPrice.sendKeys("40");

        WebElement save_button = driver.findElement(By.id("SaveButton"));
        save_button.click();

    }

    public void Delete_Time_And_Material(WebDriver driver)
    {
        WebElement lastPageIcon = driver.findElement(By.linkText("Go to the last page"));
        lastPageIcon.click();

        //click on Delete button

        WebElement clickDelete = driver.findElement(By.xpath("//tbody/tr[last()]/td[5]/a[2]"));
        clickDelete.click();


        //To retrive alert message:

//        Boolean alertMessage = true;
//
//        try
//        {
//            Alert alert = driver.switchTo().alert();
//            String alertBox = alert.getText();
//            System.out.println("Alert box text: " + alertBox);
//
//            alertMessage = true;
//            alert.accept();
//            System.out.println("Alert was accepted : " + alertMessage);
//
//            Thread.sleep(1000);
//        }
//
//        catch (Exception ex)
//        {
//            System.out.println(ex);
//        }

        Alert alert = driver.switchTo().alert();
        String alertBox = alert.getText();
        System.out.println("Alert box text" + alertBox);
        alert.accept();

        //Taking Screenshot and save

//        try
//        {
//            Screenshot ss = ((ITakesScreenshot)driver).GetScreenshot();
//            ss.SaveAsFile(@"D:\Screenshot\SeleniumTestingScreenshot.jpg");
//            Console.WriteLine("Screenshot saved");
//        }
//        catch (Exception e)
//        {
//            Console.WriteLine(e.Message);
//            throw;
//        }
        //Logout

        WebElement helloHari = driver.findElement(By.xpath("//*[@id=\"logoutForm\"]/ul/li/a"));
        helloHari.click();

        WebElement dropDownField = driver.findElement(By.xpath("//a[contains(text(),'Log off')]"));
        dropDownField.click();

        //Retrieve the Current page url:

        String url = driver.getCurrentUrl();
        System.out.println(url);

        //string url = driver.Url;
        //Console.WriteLine(url);



    }
}

