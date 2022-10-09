package day09_iframe_windowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_WindowHandle {
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
    //   driver.close();
   }

   @Test
    public void test1(){
//1- Amazon Sayfasina girelim
       driver.get("https://amazon.com");
        String amazonWindowHandle=driver.getWindowHandle();

//2- Url'nin amazon içerdiğini test edelim
       String exURL="amazon";
       String actURL=driver.getCurrentUrl();
       Assert.assertTrue(actURL.contains(exURL));

//3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
       driver.switchTo().newWindow(WindowType.WINDOW);
       driver.get("https://www.bestbuy.com");
       String bestbuyWindowHandle=driver.getWindowHandle();

//4- title'in BestBuy içerdiğini test edelim
       String exTitle="Best Buy";
       String actTitle=driver.getTitle();
       Assert.assertTrue(actTitle.contains(exTitle));

//5- İlk sayfaya dönüp sayfada java aratalım
       driver.switchTo().window(amazonWindowHandle);
       WebElement searcBox=driver.findElement(By.id("twotabsearchtextbox"));
       searcBox.sendKeys("java"+ Keys.ENTER);

//6- Arama sonuclarının java içerdiğini test edelim
      WebElement aramaSonucu=driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
     String aranan="java";
     String actual=aramaSonucu.getText();
     Assert.assertTrue(actual.contains(aranan));

//7- Yeniden bestbuy sayfasına gidelim
      driver.switchTo().window(bestbuyWindowHandle);

//8- Logonun görünürlüğünü test edelim
       WebElement logo=driver.findElement(By.xpath("(//*[@class='logo'])[1]"));
       Assert.assertTrue(logo.isDisplayed());

//9- Sayfaları Kapatalım

     driver.quit();
   }
}
