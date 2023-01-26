package day7ErolHc.extentreport;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class EcritezExcel {
    //Data isimli excel dosyasına yeni kullanıcı adı ve password ekliyelim

    //Yeni bir methodda kullanıcı bilgileri başlığını silelim


    @Test
    public void test01() throws IOException {
        //Data isimli excel dosyasına yeni kullanıcı adı ve password ekliyelim


        String dosyayolu="C:\\Users\\ASUS\\Desktop\\data.xlsx";
        FileInputStream fis=new FileInputStream(dosyayolu);
        Workbook workbook= WorkbookFactory.create(fis);

        workbook.getSheet("sayfa1").createRow(3).createCell(0).setCellValue("ikinci kullanici bilgileri");
        workbook.getSheet("sayfa1").createRow(4).createCell(0).setCellValue("email");
        workbook.getSheet("sayfa1").createRow(5).createCell(0).setCellValue("passsword");
        FileOutputStream fos=new FileOutputStream(dosyayolu);
        workbook.write(fos);


    }
    //Yeni bir methodda kullanıcı bilgileri başlığını silelim
    @Test
    public void test02() throws IOException {
        String dosyayolu="C:\\Users\\ASUS\\Desktop\\data.xlsx";
        FileInputStream fis=new FileInputStream(dosyayolu);
        Workbook workbook= WorkbookFactory.create(fis);
        Sheet sheet= workbook.getSheet("Sayfa1");
        Row row=sheet.getRow(3);
        Cell cell= row.getCell(0);
        row.removeCell(cell);
        FileOutputStream fos=new FileOutputStream(dosyayolu);
        workbook.write(fos);




    }
}
