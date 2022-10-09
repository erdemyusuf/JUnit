package day09_iframe_windowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_WindowHandle {
    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @After
    public void teardown(){
        driver.quit();
    }
    @Test
    public void  test1(){

     //   Amazon anasayfa adresine gidin.
        driver.get("https://amazon.com");

     //   Sayfa’nin window handle degerini String bir degiskene atayin
        String  amazonHandle=driver.getWindowHandle();

     //   Sayfa title’nin “Amazon” icerdigini test edin
        String exTitle="Amazon";
        String actTitle=driver.getTitle();
        Assert.assertTrue(actTitle.contains(exTitle));

     //   Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://techproeducation.com");

     //   Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
        String exTitle1="TECHPROEDUCATION";
        String actTitle1=driver.getTitle();
        Assert.assertFalse(actTitle1.contains(exTitle1));

     //   Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://walmart.com");

     //   Sayfa title’nin “Walmart” icerdigini test edin
      Assert.assertTrue(driver.getTitle().contains("Walmart"));

     //   Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonHandle);
        Assert.assertTrue(driver.getTitle().contains(actTitle));  //web element ataması yapmadan direkt assert ettik

    }
}
