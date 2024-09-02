package multimi;

import org.testng.annotations.Test;

import java.util.*;

public class Multimi {


    //multimi=array, list, set, map

    @Test
    public void metodaTest() {
        //cursantiArray();
        // cursantiList();
        //masiniList();
        //mapExample();
        //tariOrase();
        reteteIngrediente();
    }
    //afissam cursantio de la cursul de automation

    public void cursantiArray() {
        String[] cursanti = new String[10];
        cursanti[0] = "Rares";
        cursanti[1] = "Cristina";
        cursanti[2] = "Magda";
        cursanti[3] = "Razvan";
        cursanti[4] = "Radu";
        cursanti[5] = "Andrei";
        for (int i = 0; i < cursanti.length; i++) {
            System.out.println("numele cursantului este " + cursanti[i]);
        }
    }

    //v2 - list
    public void cursantiList() {
        List<String> cursanti = new ArrayList<>();
        cursanti.add("Rares");
        cursanti.add("Cristina");
        cursanti.add("Magda");
        cursanti.add("Razvan");
        cursanti.add("Radu");
        cursanti.add("Andrei");
        for (int i = 0; i < cursanti.size(); i++) {
            System.out.println("numele cursantului este " + cursanti.get(i));
        }
    }

    //definim o multime de masini din care afisam doar masinile de pe pozitii impare

    public void masiniList() {
        List<String> masini = new ArrayList<>();
        masini.add("Dacia");
        masini.add("BMW");
        masini.add("VW");
        masini.add("Tiguan");
        for (int i = 1; i < masini.size(); i = i + 2) {

            System.out.println("numele masinii este " + masini.get(i));
        }
    }

    //map: key=value ; map urile se parcurg cu foreach cheia trb sa fie unica
    //parcurgerea se face pe baza cheilor folosind un set

    public void mapExample() {
        Map<String, String> elemente = new HashMap<>();
        elemente.put("masina", "Dacia");
        elemente.put("persoana", "Rares");
        elemente.put("telefon", "Nokia");
        for (String key : elemente.keySet()) {
            System.out.println("cheia este in " + key);
            System.out.println("valoarea este " + elemente.get(key));
        }
    }

    //afisam tara cu anumite orase
    public void tariOrase() {
        Map<String, List<String>> obiecte = new HashMap<>();
        //facem listele

        List<String>  oraseRomania= Arrays.asList("Brasov","Cluj","Bucuresti");
        List<String> oraseItalia=Arrays.asList("Roma","Torino","Milano");
        List<String> oraseSpania=Arrays.asList("Madrid","Barcelona","Valencia");

        obiecte.put("Romania",oraseRomania);
        obiecte.put("Italia",oraseItalia);
        obiecte.put("Spania",oraseSpania);
        for(String key : obiecte.keySet()){
            System.out.println("tara este in " + key);
            System.out.println("orasele sunt  " + obiecte.get(key));
        }

    }

    //exemplu complet tari orase capitale -> tema in loc de lista de stringuri avem inca un map de string string


    public void reteteIngrediente(){
        Map<String,List<String>> obiecte=new HashMap<>();
        List<String>  ingredienteSupa= Arrays.asList("pui","legume","sare");
        List<String> ingredientePaste=Arrays.asList("paste","pui","sos");
        List<String> ingredientePizza=Arrays.asList("aluat","salam","cascaval");
        obiecte.put("Supa",ingredienteSupa);
        obiecte.put("Paste",ingredientePaste);
        obiecte.put("Pizza",ingredientePizza);
        for(String key : obiecte.keySet()){
            System.out.println("reteta este in " + key);
            System.out.println("ingredientele sunt  " + obiecte.get(key));
        }
    }

}

