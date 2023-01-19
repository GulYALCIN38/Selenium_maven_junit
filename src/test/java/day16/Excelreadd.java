package day16;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Excelreadd {
    //Excel Okuma
    //Excelden veriyi okumak icin hangi sırayla gitmem gerekir
    //workbook > sheet > row > cell
    //Bir exceldeki top satir sayısı nasıl bulunur?
    //getLastROwNumber
    //Yada
    //getPhysicalNumberOfRows- toplam kullanılan satir sayısı
    //Excel Yazdırma
    //Microsoft dosyalari ile iletişime gecmek icin apache poi dependency’s kullanılır
    //Su anki projende exceli nasil kullandin?
    //Test caselerimde çeşitli datalar kullanıyorum. Ornegin kullanıcı adi, kullanıcı şifresi gibi dataları excelde tutuyoruz. Bu datalari test caselerde kullanmak icin excelden çekiyorum ve test caselerimde kullanıyorum.
    //Datalari excelde tutmanı faydası, dataların derli toplu bir yerde olması, data güvenliği, data kayıplarına engel olmak.


    @Test
    public void test01() throws IOException {
        //workbook//(excel dosyasi)>workseet9sheet)>row(satir)>cell(veri hucresi)
        String path="./src/test/java/Resources/Capitals.xlsx";
        // dosyayi ac
        FileInputStream fileInputStream=new FileInputStream(path);

        // excel dosyasini ac/workbook ac
        Workbook workbook= WorkbookFactory.create(fileInputStream);


        //sayfayi ac/ sheet1
       // Sheet Sheet1= workbook.getSheetAt(0);//0 ilk sayfayi acar
        Sheet sheet1= workbook.getSheet("Sheet1");//0 ilk sayfayi acar
        

        //ilk satira git
        Row row1=sheet1.getRow(0);//index 0 ile ilk satira gittik
        
        
        
        

        // ilk satirdaki ilk veriyo yazdir
        Cell cell1=row1.getCell(0);
        System.out.println("cell1 = " + cell1);
        
        // 1. satir 2. sutun
        Cell cell12=sheet1.getRow(0).getCell(1);
        System.out.println("cell12 = " + cell12);

       //3. satir 1. sutun da france yazdigini dogrulayin
        Cell cell31=sheet1.getRow(2).getCell(0);
        System.out.println(cell31.toString());
        System.out.println("cell31 = " + cell31);
        Assert.assertEquals("France",cell31.toString());
        
        // Exeldeki toplam satir sayisi
        int toplamsatir=sheet1.getLastRowNum()+1;//index sifirdan basladigi icin bir eksik verir
        System.out.println("toplamsatir = " + toplamsatir);

        //kullanilan toplam satir sayisisi
        int kullanilantoplamsatirsayisi=sheet1.getPhysicalNumberOfRows();
        System.out.println("kullanilantoplamsatirsayisi = " + kullanilantoplamsatirsayisi);//1 den baslar

        // COUNTRY , CAPITAKS  KEY VE VALUE LERI MAP E ALIPPRIN ETCEM map olarak

        // variable olusturalim  country ve capital verilerini kotacagiz

        Map<String,String> ulkebaskent=new HashMap<>();

        for (int i = 1; i < kullanilantoplamsatirsayisi; i++) {
            String country=sheet1.getRow(i).getCell(0).toString();
            String capitals=sheet1.getRow(i).getCell(1).toString();
            ulkebaskent.put(country,capitals);




            }
        System.out.println("ulkebaskent = " + ulkebaskent);

        }







        
    }

