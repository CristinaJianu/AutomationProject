package structuriRepetitive;

import org.testng.annotations.Test;

public class StructuriRepetitive {

    /*
    structuri repetitive : for / while/ foreach/do..while
     */
    @Test

    public void metodaTest() {
        //afisareNrFor(5);
        //afisamNrWhile(5);
        afisamNrPare(30);
    }


    //afisam primele n nr

    public void afisareNrFor(int capat) {
        for (int i = 0; i < capat; i++) {
            System.out.println("afisez nr " + i);
        }
    }

    //afisam primele n nr - while

    public void afisamNrWhile(int capat) {
        int i = 0;
        while (i < capat) {
            System.out.println("afisez nr " + i);
            i++;
        }

    }

    //afisam nr pare de la 0 la 50

    public void afisamNrPare(int capat) {
        for (int i = 0; i <= capat; i++) {
            if (i % 2 == 0) {
                System.out.println("nr este " + i);
            }
        }
    }

    // foreach
}
