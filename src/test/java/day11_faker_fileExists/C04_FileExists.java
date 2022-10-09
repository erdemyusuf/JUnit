package day11_faker_fileExists;

import org.junit.Assert;
import org.junit.Test;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileExists {
    @Test
    public void test1() {

        System.out.println(System.getProperty("user.dir"));//C:\Users\Administrator\Desktop\selenium\JUnit
        //Şuanki içinde bulunduğum yolu gösterir

        System.out.println(System.getProperty("user.home"));//C:\Users\Administrator
        //Geçerli kullanıcının ana dizinini verir
/*
        String farkliBolum = System.getProperty("user.home");
        //"C:\\Users\\Administrator\\Desktop\\selenium\\file exists calismasi.txt" --> masa üstündeki dosyanın yolu
        String ortakBolum = Administrator\\Desktop\\selenium\\file exists calismasi.txt"
        String masaUstuDosyaYolu = farkliBolum+ortakBolum; // Masaüstündeki dosya yolunu gösterir
        System.out.println(masaUstuDosyaYolu); //"C:\\Users\\Administrator\\Desktop\\selenium\\file exists calismasi.txt"
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
 */
        String dosyaYolu = "C:\\Users\\Administrator\\Desktop\\selenium\\file exists calismasi.txt";
        //System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        /*
        Bir web sitesinden indirdiğimiz yada windows içinde oluşturduğumuz dosyanın indiğini yada orda olduğunu
        test edebilmem için o dosyanın üzerine shift tuşuna basılı olarak sağ klik yapıp dosyanın yolunu kopyalayıp
        bir string değişkene atarız ve dosyayı doğrulamak için
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu))); bu methodu kullanırız
         */
    }
}

