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

    public void initialisation2(){
        this.grille = new char[][]{ {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                                    {EMPTY, '1', '2', EMPTY, '3', '4', '5', '6', '7'},
                                    {EMPTY, '3', '4', '5', EMPTY, '6', '1', '8', '2'},
                                    {EMPTY, EMPTY, '1', EMPTY, '5', '8', '2', EMPTY, '6'},
                                    {EMPTY, EMPTY, '8', '6', EMPTY, EMPTY, EMPTY, EMPTY, '1'},
                                    {EMPTY, '2', EMPTY, EMPTY, EMPTY, '7', EMPTY, '5', EMPTY},
                                    {EMPTY, EMPTY, '3', '7', EMPTY, '5', EMPTY, '2', '8'},
                                    {EMPTY, '8', EMPTY, EMPTY, '6', EMPTY, '7', EMPTY, EMPTY},
                                    {'2', EMPTY, '7', EMPTY, '8', '3', '6', '1', '5'}};
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
        if (!ok){
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
        int val = (int)Math.sqrt(this.grille.length);
        checkBornes(x,y);
        checkPossibles(value);

        for (int i = 0; i < this.grille.length; i++) {
            if (this.grille[i][y] == value || this.grille[x][i] == value || checkZone(x-(x%val), y-(y%val), value)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkZone(int x, int y, int num) {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                if (this.grille[row + x][col + y] == num) {
                    return true;
                }
        return false;
    }

    public void print2D(){
        for (int i = 0; i < this.grille.length; i++) {
            for (int j = 0; j < this.grille[i].length; j++) {
                System.out.print(this.grille[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean solveur(){
        for (int i = 0; i < this.grille.length; i++) {
            for (int j = 0; j < this.grille[i].length; j++) {
                if (getValue(i,j) == EMPTY){
                    for (int value = 0; value < this.grille.length; value++){
                        try{
                            setValue(i, j, Possible[value]);
                            if (solveur()) {
                                return true;
                            } else {
                                setValue(i, j, EMPTY);
                            }
                        } catch (IllegalArgumentException e) {
                            continue;
                        }
                    return false;
                    }
                }
            }
        }
        return true;
    }
}
