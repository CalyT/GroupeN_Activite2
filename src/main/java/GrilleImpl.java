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

    /**
     * Initialise le tab donne en parametre avec des valeurs EMPTY
     */
    public void initialisation(){
        for (int i = 0; i < this.grille.length; i++){
            for (int j = 0; j < this.grille[i].length; j++){
                this.grille[i][j] = EMPTY;
            }
        }
    }

    /**
     * @throws IllegalArgumentException si x ou y sont hors bornes (0 - dimension-1)
     */
    public void checkBornes(int x, int y){
        if ( x > dim-1 || x < 0 || y > dim-1 || y < 0 ) {
            throw new IllegalArgumentException("Hors borne.");
        }
    }

    /**
     * @throws IllegalArgumentException si char n'est pas compris dans la table des Possibles
     */
    public void checkPossibles(char value){
        boolean ok = false;
        for (int i = 0; i < this.grille.length; i++) {
            if (value == Possible[i]){
                ok = true;
            }
        }
        if (ok == false){
            throw new IllegalArgumentException("Caractere pas autorise");
        }
    }

    @Override
    public int getDimension() {
        return this.dim;
    }

    @Override
    public void setValue(int x, int y, char value) throws IllegalArgumentException {
	    checkBornes(x,y);

	    if (possible(x, y, value)) {
            this.grille[x][y] = value;
        } else {
            throw new IllegalArgumentException("Valeur impossible");
        }
    }

    @Override
    public char getValue(int x, int y) throws IllegalArgumentException {
	    checkBornes(x,y);
        return this.grille[x][y];
    }

    @Override
    public boolean complete() {
        for (int i = 0; i < this.grille.length; i++) {
            for (int j = 0; j < this.grille[i].length; j++) {
                if (this.grille[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean possible(int x, int y, char value) throws IllegalArgumentException {

	    checkBornes(x,y);
        checkPossibles(value);

        for (int i = 0; i < this.grille.length; i++) {
            if (this.grille[i][y] == value || this.grille[x][i] == value) {
                return false;
            }
        }
        return true;
    }
}
