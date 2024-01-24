package Test_Package;

import Pages_Package.Create_Edit_Del_Class;
import Pages_Package.LoginPageClass;
import Pages_Package.Time_Material_Class;
import Utilities_Package.CommonClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class TestClass extends CommonClass
{
    @BeforeTest
    public void Set_Up_TM()
    {
        driver = new ChromeDriver();


        driver.get("http://horse.industryconnect.io/Account/Login?ReturnUrl=%2f");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);




        LoginPageClass loginPage_Obj = new LoginPageClass();
        loginPage_Obj.Login_HomePage_Verification(driver);

        Time_Material_Class timeAndMaterial_Obj = new Time_Material_Class();
        timeAndMaterial_Obj.Click_TM_and_Create(driver);

    }

    //test-01
    @Test(priority = 1)

    public void Create_TM_Record() throws InterruptedException {
        Create_Edit_Del_Class createEditDelete_Obj = new Create_Edit_Del_Class();
        createEditDelete_Obj.Create_Time_And_Material(driver);
    }

    //Test-02

    @Test(priority = 2)


    public void Edit_Time_Record()
    {
        Create_Edit_Del_Class createEditDelete_Obj = new Create_Edit_Del_Class();
        createEditDelete_Obj.Edit_Time_And_Material(driver);
    }

    //Test-03


    @Test(priority = 3)
    public void Delete_Time_Record()
    {
        Create_Edit_Del_Class createEditDelete_Obj = new Create_Edit_Del_Class();
        createEditDelete_Obj.Delete_Time_And_Material(driver);
    }

    @AfterTest
    public void CloseTest()
    {
        driver.close();


    }
}



