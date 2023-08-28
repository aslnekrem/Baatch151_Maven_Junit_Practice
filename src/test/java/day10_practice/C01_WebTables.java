package day10_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C01_WebTables extends TestBase {

    // girisYap methodu olusturun
    // https://www.hotelmycamp.com adresine gidin
    // Log in butonuna tıklayın
    // Username: manager
    // Password: Manager1!

    // sutun sayısını yazdırın
    // tum body'i yazdirin
    // body'de bulunan satır sayısını yazdırın
    // body'de bulunan satırları yazdırın
    // 4.satırdaki elementleri yazdırın


    @Test
    public void test01() {

        // girisYap methodu olusturun
        // https://www.hotelmycamp.com adresine gidin
        // Log in butonuna tıklayın
        // Username: manager
        // Password: Manager1!
        girisYap();





        // sutun sayısını yazdırın
        List<WebElement> sutunBasliklariListesi = driver.findElements(By.xpath("//thead//tr[1]//th"));
        //Tabloda satırda ki verileri almak için tr kullanılır. tr[1] birinci satırdaki veriler.
        System.out.println("Sutun SAYISI: "+sutunBasliklariListesi.size());
        /*
        html kodlarini ctrl+f ile acip //thead yazdik baslik sayisini gördük
         //thead//tr yazinca satir basliklarini görürüz
         //thead//tr[1] basligin 1.sütununu verir
         //thead//tr[1]//th basligin 1.satirindaki elementleri verir
         */


        // tum body'i yazdirin
        WebElement tumBody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBody.getText());




        // body'de bulunan satır sayısını yazdırın
        //tr  --> Satir
        List<WebElement> satirlarListesi = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Satir  Sayisi = " + satirlarListesi.size());

        // body'de bulunan satırları yazdırın
        satirlarListesi.forEach(t-> System.out.println(t.getText()));



        // 4.satırdaki elementleri yazdırın
        //html kodlarini acip ctrl+f ile actigimiz locate yazdigimiz yere //tbody body kismini belirler
        ////tbody//tr[4] bodyy nin 4. satirini isaretler.
        // //tbody//tr[4]//td[] kutucuga hangi sayiyi yazarsak o indexteki elementi verir.
        // //tbody//tr[4]//td yazarsak tüm elementleri verir.

        List<WebElement> dorduncuSatirElementleri = driver.findElements(By.xpath("//tbody//tr[4]"));
        // birden fazla oldugu icin findElement's' yapariz

        for (WebElement each:dorduncuSatirElementleri) {
            System.out.println(each.getText());
        }

        //LAMBDA ILE
        dorduncuSatirElementleri.stream().forEach(t-> System.out.println("Dorduncu satirdaki Elementler = " +t.getText()));



    }

    public void girisYap() {

        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.xpath("//button[@id='details-button']")).click(); // GELİSMİS
        driver.findElement(By.xpath("//a[@id='proceed-link']")).click(); // GÜVENLİ DEGİL


        driver.findElement(By.xpath("//a[text()='Log in']")).click(); // LOG IN

        Actions actions = new Actions(driver);

        WebElement userName = driver.findElement(By.xpath("//input[@id='UserName']"));

        actions.
                click(userName).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                perform();



    }
}
