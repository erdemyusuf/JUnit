package automation_excercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Day01 {


    //Test Case 1: Register User
//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
//        3. Verify that home page is visible successfully
//        4. Click on 'Signup / Login' button
//        5. Verify 'New User Signup!' is visible
//        6. Enter name and email address
//        7. Click 'Signup' button
//        8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
//        9. Fill details: Title, Name, Email, Password, Date of birth
//        10. Select checkbox 'Sign up for our newsletter!'
//        11. Select checkbox 'Receive special offers from our partners!'
//        12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
//        13. Click 'Create Account button'
//        14. Verify that 'ACCOUNT CREATED!' is visible
//        15. Click 'Continue' button
//        16. Verify that 'Logged in as username' is visible
//        17. Click 'Delete Account' button
//        18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button




        static WebDriver driver;

        @BeforeClass
        public static void setup() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        }

        @Test
        public void automationExe01() throws InterruptedException{
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertTrue("Page is visible",driver.getCurrentUrl().contains("https://automationexercise.com/"));

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();

        //5. Verify 'New User Signup!' is visible
        WebElement newUserSignUp=driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        Assert.assertTrue("New User SignUp Is Visible",newUserSignUp.isDisplayed());

        //6. Enter name and email address
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("sawonef");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("sawonef509@pelung.com");

        //7. Click 'Signup' button
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement accountInfoText=driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        Assert.assertTrue("Enter account info Visible",accountInfoText.isDisplayed());

        //9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.xpath("//input[@data-qa='name']")).clear();
        driver.findElement(By.xpath("//input[@data-qa='name']")).sendKeys("sawonef");
        //driver.findElement(By.xpath("//input[@data-qa='email']")).clear(); Cannot Be Manipulated
        //driver.findElement(By.xpath("//input[@data-qa='email']")).sendKeys("sawonef209@pelung.com");
        driver.findElement(By.xpath("//input[@data-qa='password']")).sendKeys("12345678");
        WebElement birthdayDays=driver.findElement(By.xpath("//select[@id='days']"));
        Select birthdayOption=new Select(birthdayDays);
        birthdayOption.selectByValue("27");
        WebElement birthdayMonths=driver.findElement(By.id("months"));
        Select birthMonthOption=new Select(birthdayMonths);
        birthMonthOption.selectByVisibleText("March");
        WebElement birthdayYears=driver.findElement(By.xpath("//select[@name='years']"));
        Select birthYearOption=new Select(birthdayYears);
        birthYearOption.selectByVisibleText("2000");
        Thread.sleep(2000);

        //10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.id("newsletter")).click();

        //11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.id("optin")).click();
        Thread.sleep(2000);

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile
        driver.findElement(By.id("first_name")).sendKeys("sawonef");
        driver.findElement(By.id("last_name")).sendKeys("kendal");
        driver.findElement(By.id("company")).sendKeys("Sample");
        driver.findElement(By.id("address1")).sendKeys("Night street");
        driver.findElement(By.id("address2")).sendKeys("Mare house");
        WebElement countryOptions=driver.findElement(By.xpath("//select[@data-qa='country']"));
        Select countrySelect=new Select(countryOptions);
        countrySelect.selectByValue("United States");
        driver.findElement(By.xpath("//input[@data-qa='state']")).sendKeys("Arizona");
        driver.findElement(By.xpath("//input[@data-qa='city']")).sendKeys("Tucson");
        driver.findElement(By.xpath("//input[@data-qa='zipcode']")).sendKeys("06200");
        driver.findElement(By.xpath("//input[@data-qa='mobile_number']")).sendKeys("15205252");

        //13. Click 'Create Account button'
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();

        //14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement accountCreatedText=driver.findElement(By.xpath("//b[.='Account Created!']"));
        Assert.assertTrue("Account Created Visible",accountCreatedText.getText().toLowerCase().contains("account created"));

        //15. Click 'Continue' button
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

        //16. Verify that 'Logged in as username' is visible
        WebElement loginAsUserName=driver.findElement(By.xpath("//b[.='sawonef']"));
        Assert.assertTrue("Login As Username",loginAsUserName.getText().equals("sawonef"));

        //17. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[text()=' Delete Account']")).click();

        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        driver.findElement(By.xpath("//*[text()='Delete']")).click(); //Delete is not allowed

        }
        }