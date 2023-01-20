package day18;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class C02_Log4j {
    //3. Logger object olustur:
    //    private static Logger logger = LogManager.getLogger(Demo1.class.getName());
    //4. Logger fonksiyonuyla istenilen fonksiyonu kullan
    //                 logger.debug("Debug logger");
    //        logger.info("Info logger");
    //        logger.error("Error logger");
    //        logger.fatal("Fatal logger");

private static Logger logger= LogManager.getLogger(C02_Log4j.class.getName());//parantez icindeki ifade bu objenin sadece bu sinifta kullanmasi icicn

    @Test
    public void test01() {
        //logger ile yazdirma yap
        logger.fatal("fatal log");
        logger.error("error log");
        logger.warn("warn log");
        logger.debug("debug log");
        logger.info("info log");



    }
}
