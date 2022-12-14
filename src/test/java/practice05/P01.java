package practice05;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseBeforeAfter;

public class P01 extends TestBaseBeforeAfter {

    @Test
    public void test01() {

        // go to url : https://www.techlistic.com/p/selenium-practice-form.html
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

        //fill the firstname
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Joseph", Keys.ENTER);

        //fill the lastname
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Virtue",Keys.ENTER);

        //check the gender
        driver.findElement(By.xpath("//*[@id='sex-0']")).click();

        //check the experience
        driver.findElement(By.id("exp-6")).click();

        //fill the date
        driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("28.09.2022",Keys.ENTER);

        //choose your profession -> Automation Tester
        driver.findElement(By.xpath("//*[@value='Automation Tester']")).click();

        //choose your tool -> Selenium Webdriver
        driver.findElement(By.xpath("//input[@id='tool-2']")).click();

        //choose your continent -> Antartica
        WebElement ddm=driver.findElement(By.xpath("//*[@id='continents']"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Antartica");

        //choose your command  -> Browser Commands
        driver.findElement(By.xpath("//select[@id='selenium_commands']/option[1]")).click();// parent child ile option a gectik

        //click submit button
        driver.findElement(By.xpath("//*[@class='btn btn-info']")).click();


    }
}
