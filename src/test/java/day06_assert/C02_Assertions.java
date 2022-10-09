package day06_assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assertions {

    /*
Amazon sayfasina git
3 farkli test method'u olustur
- url'in "amazon" icergini test et
- title'in "facebook" icermedigini test et
- sol ust kosede amazon logosunun gorundugunu test et
 */

     static WebDriver driver;  //beforeclass yaptıgımız icin static kullandik

    @BeforeClass
    public static void setup(){  //beforeclass afterclass notasyonunda metotlar static yapilir

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://amazon.com");  // işlemleri amazon icinde yapacagımız icin beforeclass da get yaptık
                                  //Ayrıca before notasyonunda farklı sayfalar acılır.BeforeClass da ise islemler aynı sayfada yapılır

    }

    @AfterClass
    public static void teardown(){

       // driver.close();
    }

    @Test
    public void test1(){
        //- url'in "amazon" icergini test et
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="amazon";
        Assert.assertTrue(actualUrl.contains(expectedUrl));
       // Assert.assertEquals(expectedUrl,actualUrl);--------->failed oldu / farkı var diye hata verdi
    }

    @Test
    public void test2(){
        //title'in "facebook" icermedigini test et
       String actualTitle=driver.getTitle();
       String expectedTitle="facebook";
       Assert.assertFalse(actualTitle.contains(expectedTitle));


    }

    @Test
    public void test3(){
        //sol ust kosede amazon logosunun gorundugunu test et
        WebElement logo=driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());

    }

    @Test
    public void test4(){
        //url nin www.facebook.com oldugunu test edin
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="www.facebook.com";
        Assert.assertNotEquals(actualUrl,expectedUrl);

    }

}

