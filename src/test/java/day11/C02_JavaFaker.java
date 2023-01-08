package day11;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C02_JavaFaker {


    @Test
    public void javafaker() {
        Faker faker = new Faker();
        //faker objesi fake data olusur
        String fname = faker.name().firstName();
        System.out.println("fname = " + fname);//faux prenom

        String flastname = faker.name().lastName();
        System.out.println("flastname = " + flastname);//faux nom

        String userName = faker.name().username();
        System.out.println("userName = " + userName);//fake nom d'utilisateur

        System.out.println(faker.name().title());// fake metier

        System.out.println(faker.address().city());//fake ville

        System.out.println(faker.address().state());//fake state

        System.out.println(faker.address().fullAddress());//fake adresse

        System.out.println(faker.phoneNumber().cellPhone());//fake tel

        System.out.println(faker.internet().emailAddress());//fake email

        System.out.println(faker.address().zipCode());//fake  code postal

        System.out.println(faker.number().digits(15));//fake no

        // sifre tel email sehir .. gibi veriler test datasidir

        //test datalari kimden alinir?
        // 1.BA (acceptance criteria yazar)Business analyst,
        //2.test lead peut vous donner les datas
        //3. Manuel tester
        //4. Tech lead,( team lead,  ou dev lead)
        //5.developer, 6. Database, 7. API call, 8. DOCUMENTATIONS or :Api swager documant  9. Java FAKER

        // test datalari kimden alinmaz? ;utulisateur, scrum master


    }
}
