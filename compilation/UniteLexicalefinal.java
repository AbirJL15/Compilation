// package parserexemple;

public class UniteLexicalefinal {
    public CategorieFinal categorie;
    public Object lexeme;

    public UniteLexicalefinal(CategorieFinal categorie, Object lexeme) {
        this.categorie = categorie;
        this.lexeme = lexeme;
    }

    public CategorieFinal getCategorie() {
        return categorie;
    }

    public String toString() {
        return "<" + categorie.toString() + "," + lexeme + ">";
    }
}
