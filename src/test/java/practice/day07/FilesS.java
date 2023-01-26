package practice.day07;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FilesS {

    // Exercise 1...

// masaustunde bir text dosyası olusturun
// masaustundeki text dosyasının varlıgını test edin

    @Test
    public void test01() {
  /*      String path="C:\\Users\\ASUS                  \\Desktop\\text.txt";
        assert Files.exists(Paths.get(path));*/
        //Bu islemi dinamik hale getirelim
        String farkli =System.getProperty("user.home");
        String path=farkli+"\\Desktop\\text.txt";
        assert Files.exists(Paths.get(path));

    }
}
