package tests.day11;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FilesExist  {

    @Test
    public void test(){

        System.out.println(System.getProperty("user.home"));
        //"C:\Masaüstü\picture.jpg"

        //masaüstündeki bir dosya yolunun tüm bilgisayarlarda sorunsuz çalışması için
        //dosya yolunu ikiye ayıracağız
        //1.Herkesin bilgisayarında farklı olan kısım
        //bu kısmı bilgisayardan System.getProperty("user.home")kodu ile alabiliriz
        //2.herkes icin aynı olan kısım
        //bu kısım 1. maddede ki yolun devamı şeklinde olur


        //örnek masaüstündeki picture dosyası için yol kaydedelim

        String dosyaYoluDinamik=System.getProperty("user.home")+ "\\Masaüstü\\picture.jpg";

        String dosyaYoluManuel="C:\\Users\\Serdar\\Masaüstü\\picture.jpg";

        System.out.println("dosya yolumuz :"+dosyaYoluDinamik);

        System.out.println(Files.exists(Paths.get(dosyaYoluDinamik)));

        Assert.assertTrue(Files.exists(Paths.get(dosyaYoluManuel)));


        System.out.println(System.getProperty("user.dir"));
        //içinde olduğumuz dosyanın yolunu verir


    }
}
