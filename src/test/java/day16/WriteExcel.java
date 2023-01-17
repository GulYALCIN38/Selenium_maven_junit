package day16;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {


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

        // ilk satir 3. sutun crieate et
        Cell cell3=row1.createCell(2);

        // nufus yaz bu kutuya

        cell3.setCellValue("NUFUS");



       // 2. satir 3. sutuna  450 000 yazdir
        sheet1.getRow(1).createCell(2).setCellValue(4500000);


       // 2. satir 3. sutuna  500 000 yazdir
        sheet1.getRow(2).createCell(2).setCellValue(5000000);

        // KAYDET

        FileOutputStream fileOutputStream=new FileOutputStream(path);
        workbook.write(fileOutputStream);




    }
}
