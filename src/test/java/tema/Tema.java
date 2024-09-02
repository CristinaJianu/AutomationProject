package tema;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tema {
    @Test
    public void metodaTest() {
        tariOraseCapitale();
    }
    //exemplu complet tari orase capitale -> tema in loc de lista de stringuri avem inca un map de string string

    public void tariOraseCapitale() {
        Map<String, Map<String, String>> elemente = new HashMap<>();
        Map<String,String> romania= new HashMap<>();
        romania.put("Timisoara","Bucuresti");
        Map<String,String> franta= new HashMap<>();
        franta.put("Nantes", "Paris");
        Map<String,String> italia= new HashMap<>();
        italia.put("Milano","Roma");
        elemente.put("Romania", romania);
        elemente.put("Italia", italia);
        elemente.put("Franta", franta);

        for (String tara : elemente.keySet()) {
            System.out.println("Tara: " + tara);
            Map<String, String> oraseCapitale = elemente.get(tara);
            for (String oras : oraseCapitale.keySet()) {
                System.out.println("Oras: " + oras + ", Capitala: " + oraseCapitale.get(oras));
            }
        }
    }
}


