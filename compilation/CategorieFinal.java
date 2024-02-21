// package parserexemple;
public enum CategorieFinal {
    EOF,
    $,
    NUL,

    ID,
    NB,
    OPPRel,
    OPP,
    OPPAff,
    DP,
    PV,
    P_OUV,
    P_FER,
    Litteral,
    SINON,
    SI,
    ENTIER,
    BOOLEEN,
    DEBUT,
    DE,
    TABLEAU,
    TRUE,
    FIN,
    FINPOUR,
    FINSI,
    FALSE,
    FAIRE,
    ALORS,
    AFFICHER,
    ERREUR,
    LIRE,
    REEL,
    POUR,
    C_OUV,
    C_FER,
    ;

  

    public String toString() {
        return this.name().toLowerCase();
    }

    
    public static CategorieFinal toCategorie(String s) {
        for (CategorieFinal c : CategorieFinal.values())
            if (c.toString().equalsIgnoreCase(s))
                return c;
        return null;
    }

 
    public boolean estTerminal() {
        return ordinal() >= 0 && ordinal() <= 4;
    }

    public boolean estNonTerminal() {
        return ordinal() > 4;
    }
}
