/**
 * Implementation d'une grille
 */
public class GrilleImplTemp implements Grille {

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
    public GrilleImplTemp(int dim) {
        this.dim = dim;
        this.grille = new char[dim][dim];
    }

    @Override
    public int getDimension() {
        return dim;
    }

    @Override
    public void setValue(int x, int y, char value) throws IllegalArgumentException {
        if (x > dim && x >= 0 || y > dim && y >= 0) {
            throw new IllegalArgumentException("La case n'existe pas");
        } else {
            for (int i = x; i < this.grille.length; i++) {
                for (int j = y; j < this.grille.length; j++) {
                    if (this.grille[i][y] != value || this.grille[x][j] != value) {
                        if (possible(x, y, value)) {
                            this.grille[x][y] = value;
                        } else {
                            throw new IllegalArgumentException("C'est une valeur impossible");
                        }
                    } else {
                        throw new IllegalArgumentException("La valeur est déjà prise sur son axe");
                    }
                }
            }
        }
    }

    @Override
    public char getValue(int x, int y) throws IllegalArgumentException {
        if (x > dim && x >= 0 || y > dim && y >= 0) {
            throw new IllegalArgumentException("La case n'existe pas");
        } else {
            return this.grille[x][y];
        }
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

    @Override
    public boolean possible(int x, int y, char value) throws IllegalArgumentException {
        if (x > dim && x >= 0 || y > dim && y >= 0) {
            throw new IllegalArgumentException("La case n'existe pas");
        } else {
            for (int i = 0; i < this.grille.length; i++) {
                for (int j = 0; j < this.grille[i].length; i++) {
                    if (this.grille[i][j] == value) {
                        return true;
                    } else {
                        throw new IllegalArgumentException("value n'est pas un caractere autorise");
                    }
                }
            }
            return false;
        }
    }
}
