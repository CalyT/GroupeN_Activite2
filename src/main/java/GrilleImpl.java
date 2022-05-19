import java.util.Arrays;

/**
 * Implementation d'une grille
 */
public class GrilleImpl implements Grille {

    /**
     * Variable de dimension
     */
    private int dim;

    /**
     * Variable de dimension
     */
    private char[][] grille;

    /**
     * Constructeur
     */
    public GrilleImpl(int dim) {
        this.dim = dim;
        this.grille = new char[dim][dim];
    }

    @Override
    public int getDimension() {
        return this.dim;
    }

    @Override
    public void setValue(int x, int y, char value) throws IllegalArgumentException {
        if (x > dim && x >= 0 || y > dim && y >= 0) {
            throw new IllegalArgumentException("Hors borne.");
        } else {
            if (possible(x, y, value)) {
                this.grille[x][y] = value;
            } else {
                throw new IllegalArgumentException("C'est une valeur impossible");
            }
        }
    }

    @Override
    public char getValue(int x, int y) throws IllegalArgumentException {
        if (x > dim && x >= 0 || y > dim && y >= 0) {
            throw new IllegalArgumentException("Hors borne.");
        }
        return this.grille[x][y];
    }

    @Override
    public boolean complete() {
        for (int i = 0; i < this.grille.length; i++) {
            for (int j = 0; j < this.grille[i].length; i++) {
                if (this.grille[i][j] == '@') {
                    return false;
                }
            }
        }
        return true;
    }


    @Override
    public boolean possible(int x, int y, char value) throws IllegalArgumentException {
        boolean ok = false;

        if (x > dim && x >= 0 || y > dim && y >= 0) {
            throw new IllegalArgumentException("Hors borne.");
        }

        for (int i = 0; i < Possible.length; i++) {
            if (value == Possible[i]){
                ok = true;
            }
        }

        if (ok == false){
            throw new IllegalArgumentException("Il ne s'agit pas d'un caractere autorise");
        } else {
            for (int i = 0; i < this.grille.length; i++) {
                for (int j = 0; j < this.grille[i].length; i++) {
                    if (this.grille[i][j] == value) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
