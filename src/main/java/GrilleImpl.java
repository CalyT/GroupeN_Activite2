/**
 * Info dans package-info.java file.
 */

import java.util.Arrays;

/**
 * Implementation d'une grille.
 */
public class GrilleImpl implements Grille {

    /**
     * Variable de dimension.
     */
    private int dim;

    /**
     * Variable de dimension.
     */
    private char[][] grille;

    /**
     * Constructeur.
     * @param dim sont les dimentions de la grille
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
            if (Possible(x, y, value)) {
                this.grille[x][y] = value;
            } else {
                throw new IllegalArgumentException("Valeur impossible");
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
                if (this.grille[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

<<<<<<< Updated upstream

    @Override
    public boolean possible(int x, int y, char value) throws IllegalArgumentException {
=======
    /**
     * Test si une valeur est possible dans la grille par rapport a ce qu'elle.
     * contient deja.
     *
     * @param x     position x dans la grille
     * @param y     position y dans la grille
     * @param value valeur a mettre dans la case
     * @throw IllegalArgumentException si x ou y sont hors bornes (0-8)
     * @throw IllegalArgumentException si value n'est pas un caractere autorise
     *        ('1',...,'9',..)
     */
    @Override
    public boolean Possible(final int x, final int y, final char value) throws IllegalArgumentException {
>>>>>>> Stashed changes
        boolean ok = false;
        if (x > dim && x >= 0 || y > dim && y >= 0) {
            throw new IllegalArgumentException("Hors borne.");
        }
        for (int i = 0; i < Possible.length; i++) {
            if (value == Possible[i]) {
                ok = true;
            }
        }
        if (ok == false) {
            throw new IllegalArgumentException("Caractere non autorise");
        } else {
            return true;
        }
    }
}
