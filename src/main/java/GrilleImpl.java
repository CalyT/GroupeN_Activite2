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
    public GrilleImpl(final int dim) {
        this.dim = dim;
        this.grille = new char[dim][dim];
        Arrays.fill(this.grille, EMPTY);
    }

    @Override
    public int getDimension() {
        return this.dim;
    }

    @Override
    public void setValue(final int x, final int y, final char value) throws IllegalArgumentException {
        if (x > dim && x >= 0 || y > dim && y >= 0) {
            throw new IllegalArgumentException("La case n'existe pas");
        } else {
            if (possible(x, y, value)) {
                this.grille[x][y] = value;
            } else {
                throw new IllegalArgumentException("C'est une valeur impossible");
            }
        }
    }

    @Override
    public char getValue(final int x, final int y) throws IllegalArgumentException {
        return this.grille[x][y];
    }

    @Override
    public boolean complete() {
        for (int i = 0; i < this.grille.length; i++) {
            for (int j = 0; j < this.grille[i].length; i++) {
                if (this.grille[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Test si une valeur est possible dans la grille par rapport a ce qu'elle
     * contient deja
     *
     * @param x     position x dans la grille
     * @param y     position y dans la grille
     * @param value valeur a mettre dans la case
     * @throw IllegalArgumentException si x ou y sont hors bornes (0-8)
     * @throw IllegalArgumentException si value n'est pas un caractere autorise
     *        ('1',...,'9',..)
     */
    @Override
    public boolean possible(final int x, final int y, final char value) throws IllegalArgumentException {
        boolean ok = false;
        if (x > dim && x >= 0 || y > dim && y >= 0) {
            throw new IllegalArgumentException("La case n'existe pas.");
        }
        for (int i = 0; i < possible.length; i++) {
            if (value == possible[i]){
                ok = true;
            }
        }
        if (ok == false){
            throw new IllegalArgumentException("Il ne s'agit pas d'un caractere autorise");
        } else {
            return true;
        }
    }
}
