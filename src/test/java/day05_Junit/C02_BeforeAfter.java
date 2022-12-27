package day05_Junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C02_BeforeAfter {
    @Before
    public void setUp(){
        System.out.println("her test metodundan once calisir");

    }
    @After
    public void tearDown(){
        System.out.println("her test methodundan sonra calisir");
    }

    @Test
    public  void test01(){
        System.out.println("ilk test");
    }
    @Test
    public  void test02(){
        System.out.println("ikinci test");
    }
}
