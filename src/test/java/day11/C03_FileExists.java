package day11;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExists {
    @Test
    public void ExistsOuPas() {
        String userDIR=System.getProperty("user.dir");
        System.out.println("userDIR = " + userDIR);// C:\Users\ASUS\IdeaProjects\JawaDersleri\B103Maven_junit

        String userHOME=System.getProperty("user.home");
        System.out.println("userHOME = " + userHOME);////userHOME = C:\Users\ASUS

        // masa ustune logo.jpeg indir// telecharge le logo.jpeg sur desktop!
        // ou cette logo?= /users/techproed/Desktop

        String dosier=userHOME+"/Desktop/logo.jpeg";
        System.out.println("dosier = " + dosier);//dosier = C:\Users\ASUS/Desktop/logo.jpeg

        boolean existouPas=Files.exists(Paths.get(dosier));// s'il exist ==true ,exist pas==false
        System.out.println("existouPas = " + existouPas);//true
        Assert.assertTrue(existouPas);


        
    }
}
