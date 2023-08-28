package day06_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;



public class C02_ActionsDragAndDrop extends TestBase {
    @Test
    public void test01() {
        // https://demoqa.com/droppable adresine gidiniz
        // 'Drag me' butonunu tutup 'Drop here' kutusunun ustune birakiniz
        // 'Drop here' yazisi yerine 'Dropped!' oldugunu test ediniz


        // https://demoqa.com/droppable adresine gidiniz
        driver.get("https://demoqa.com/droppable");

        // 'Drag me' butonunu tutup 'Drop here' kutusunun ustune birakiniz

        //1. Way
        WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag,drop).perform();

        String output = driver.findElement(By.xpath("//p[text()='Dropped!']")).getText();
        Assert.assertEquals("Dropped!",output);

        //2. Way
        /*
        WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(drag).
                moveToElement(drop).
                release().
                perform();
        */

















    }
}
