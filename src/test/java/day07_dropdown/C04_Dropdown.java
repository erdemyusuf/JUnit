package day07_dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_Dropdown {
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown() {
        //driver.close();
    }
    @Test
    public void test1(){

        //https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
        //Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement ddm = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select select = new Select(ddm);
        select.selectByIndex(1);
        //Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        //Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        //Tüm dropdown değerleri(value) yazdırın
        //Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
        //False yazdırın.
    }
}