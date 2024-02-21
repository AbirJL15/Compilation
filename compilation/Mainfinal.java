
import java.util.ArrayList;

public class Mainfinal {
    public static void main(String[] args) {



        System.out.println("** Analyse lexical **");

        ArrayList<String> tab = new ArrayList<String>();

        Scannerfinal anaLex = new Scannerfinal();

        UniteLexicalefinal ul = null;
        do {
            ul = anaLex.lexemeSuivant();
            tab.add(ul.toString());
            System.out.println("ul: " + ul);
            System.out.println("tab: " + tab);

        } while (ul.getCategorie() != CategorieFinal.EOF);

        for (int i = 0; i < tab.size(); i++)

            System.out.println(" " +
                    tab.get(i));

        int taille = anaLex.fluxCaracteres.size();
        String tab1[] = new String[taille];
        
        for (int i = 0; i < anaLex.fluxCaracteres.size(); i++) {

            tab1[i] = String.valueOf(anaLex.fluxCaracteres.get(i));
        }

    
        System.out.println("**  Analyse Syntaxique **");

        parserIDS3 test22 = new parserIDS3();

        test22.analyzeSLnew();
    }
}
