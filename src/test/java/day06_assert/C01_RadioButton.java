package day06_assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_RadioButton {

    /*
1-Bir class oluşturun : RadioButtonTest
2-Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
3-https://www.facebook.com adresine gidin
4-Cookies'i kabul edin
5-"Create an Account" button'una basin
6-"radio buttons" elementlerini locate edin
7-Secili degilse cinsiyet butonundan size uygun olani secin
 */

    WebDriver driver;
    @Before
            public void setup(){

        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void teardown(){

    //    driver.close();
    }

    @Test
    public void test1() throws InterruptedException {
  // https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
  // Cookies'i kabul edin
  //  "Create an Account" button'una basin
        driver.findElement(By.xpath("//*[@rel='async']")).click();
  // "radio buttons" elementlerini locate edin
        WebElement femaleButton=driver.findElement(By.xpath("(//*[@class='_58mt'])[1]"));
        WebElement maleButton=driver.findElement(By.xpath("(//*[@class='_58mt'])[2]"));
        WebElement customButton=driver.findElement(By.xpath("(//*[@class='_58mt'])[3]"));


  //  Secili degilse cinsiyet butonundan size uygun olani secin

        if(!maleButton.isSelected()){
            maleButton.click();
        }

        Thread.sleep(3000);
        femaleButton.click();
        Thread.sleep(3000);
        customButton.click();
    }

}
