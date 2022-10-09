package day11_faker_fileExists;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class odev2 extends TestBaseBeforeAfter {

    /*

    https://html.com/tags/iframe/ sayfasina gidelim
   video’yu gorecek kadar asagi inin
    videoyu izlemek icin Play tusuna basin
    videoyu calistirdiginizi test edin

     */

    @Test
    public void test() {
      // https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        // video’yu gorecek kadar asagi inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .perform();

        // videoyu izlemek icin Play tusuna basin
        WebElement iframe=driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//*[@aria-label='Oynat']")).click();

      // videoyu calistirdiginizi test edin
        WebElement youtubeLink=driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button']"));
          Assert.assertTrue(youtubeLink.isDisplayed());

    }
}
