package structuriAlternative;

import org.testng.annotations.Test;

public class StructuriAlternative {

    /*
    in programare exista 2 tipuri de structuri: alternative si repetitive
    Str alternative: if...then..else sau switch...case
    //case sare direct la valoare , if evalueaza unul cate unul
     */
    @Test

    public void metodaTest() {
        //verificaPersoanaMajora(30);
        //verificaPersoanaMajora(18);
        //verificaPersoanaMajora(15);
        //verificNrPar(2);
        // verificNrPar(1);
        // verificNrPar(0);
        //verificNrPar(-2);
        //verificNrPar(-3);
//        verificaNrDivizibil(5);
//        verificaNrDivizibil(12);
        zileSaptamana (1);
        zileSaptamana(19);
    }

    //facem o metoda care verifica daca o persoana e majora

    public void verificaPersoanaMajora(int varsta) {
        if (varsta >= 18) {
            System.out.println("Persoana cu varsta " + varsta + " este majora");
        } else {
            System.out.println("Persoana cu varsta " + varsta + " este minora");
        }

    }

    //sa verificam daca un nr este par si pozitiv
    //dc vrem catul unei imaprtiri => / div, iar restul e mod %

    public void verificNrPar(int nr) {
       /* if(nr%2==0 & nr>0)
        {
            System.out.println("nr "+nr+" este par si pozitiv");
        }
        else {
            System.out.println("nr "+nr+" este impar si negativ");
        }*/
        if (nr > 0) {
            if (nr % 2 == 0) {
                System.out.println("nr " + nr + "  e pozitiv si par");
            } else {
                System.out.println("nr " + nr + " e pozitiv si impar");
            }
        } else if (nr < 0) {
            if (nr % 2 == 0) {
                System.out.println("nr " + nr + "  e negativ si par");
            } else {
                System.out.println("nr " + nr + "  e negativ si impar");
            }
        } else {
            System.out.println("nr " + nr + " e pozitiv si par");
        }
    }

    //verificam daca un nr e pozitiv si divizibil cu 5
    public void verificaNrDivizibil(int nr) {

        if (nr > 0 && nr % 5 == 0) {
            System.out.println("nr " + nr + "  e pozitiv si divizibi");
        } else {
            System.out.println("nr " + nr + " e pozitiv dar nu e divizibil");
        }

    }

    //switch case navigare meniuuri
    //afisam zilele saptamanii
    public void zileSaptamana(int zi) {
        switch (zi) {
            case 1:
                System.out.println("astazi e luni ");
                break;
            case 2:
                System.out.println("astazi e marti ");
                break;
            case 3:
                System.out.println("astazi e miercuri ");
                break;
            case 4:
                System.out.println("astazi e joi ");
                break;
            case 5:
                System.out.println("astazi e vineri ");
                break;
            case 6:
                System.out.println("astazi e sambata ");
                break;
            case 7:
                System.out.println("astazi e duminica ");
                break;
            default:
                System.out.println("nu mai exista zile");


        }
    }


}

