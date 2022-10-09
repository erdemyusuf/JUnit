package day11_faker_fileExists;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeAfter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C05_FileExists extends TestBaseBeforeAfter {
    @Test
    public void test1() throws InterruptedException {

        //https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //test.txt dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='text.txt']")).click();

        //Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosya="C:\\Users\\Administrator\\Downloads\\text.txt";
        Assert.assertTrue(Files.exists(Paths.get(dosya)));

        // indirildigini konsolda gosterin
        System.out.println("Files.exists(Paths.get(dosya)) = " + Files.exists(Paths.get(dosya)));
    }
}