package docInfo.java;

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
    public void initialisation3(){
        this.grille = new char[][]{ {'5', '7', '6', '8', '2', '1', '3', '4', '9'},
                                    {'8', '1', '2', EMPTY, '3', '4', '5', '6', '7'},
                                    {'9', '3', '4', '5', EMPTY, '6', '1', '8', '2'},
                                    {'7', EMPTY, '1', EMPTY, '5', '8', '2', EMPTY, '6'},
                                    {'3', EMPTY, '8', '6', EMPTY, EMPTY, EMPTY, EMPTY, '1'},
                                    {'6', '2', EMPTY, EMPTY, EMPTY, '7', EMPTY, '5', EMPTY},
                                    {'4', EMPTY, '3', '7', EMPTY, '5', EMPTY, '2', '8'},
                                    {'1', '8', EMPTY, EMPTY, '6', EMPTY, '7', EMPTY, EMPTY},
                                    {'2', EMPTY, '7', EMPTY, '8', '3', '6', '1', '5'}};
    }
    public void initialisation4(){
        this.grille = new char[][]{ {'7', EMPTY , 'e', EMPTY ,'a' , EMPTY , '3', EMPTY , EMPTY , '2', EMPTY ,'9', EMPTY ,'0','5','b'},
                                    {'4', EMPTY , 'c', '6', 'e', '2', EMPTY , '0', 'd', '5', EMPTY , '3', 'a', EMPTY ,'f','1'},
                                    {'f' ,'2' ,'ç' , EMPTY, EMPTY , EMPTY ,'5', 'b', 'e', EMPTY , EMPTY , EMPTY , EMPTY , EMPTY , EMPTY,'d'},
                                    { EMPTY , EMPTY , EMPTY , '3', 'c','8' , '7', 'd', 'b', EMPTY , EMPTY ,'a','6' , EMPTY , EMPTY , 'd'},
                                    {'8', '3', '6', '1', '5',  EMPTY, '4', EMPTY , '2', EMPTY , EMPTY , EMPTY , EMPTY , EMPTY , EMPTY, EMPTY},
                                    { EMPTY, EMPTY , '4', EMPTY , EMPTY , EMPTY , EMPTY , EMPTY , EMPTY , EMPTY , EMPTY , EMPTY , EMPTY ,  EMPTY,'3','c'},
                                    { EMPTY, 'f', EMPTY , '9',  EMPTY, 'a', EMPTY , EMPTY , EMPTY , '8', EMPTY , 'd', '1', '2', EMPTY, EMPTY},
                                    {'d', EMPTY , '2', EMPTY , '1', 'e', '0', '9', EMPTY , EMPTY , EMPTY , 'f', EMPTY , EMPTY , EMPTY, EMPTY},
                                    {'e', '4', EMPTY ,  EMPTY, EMPTY, '7', '2', '1', EMPTY , EMPTY , '6', 'c', '5', 'f', EMPTY , EMPTY},
                                    {'9', '6', EMPTY , '0', EMPTY , EMPTY ,  EMPTY, '5', 'f', EMPTY , '2', EMPTY , 'c', EMPTY ,'a',  EMPTY },
                                    {'c', '1', EMPTY , '7', EMPTY ,  EMPTY, EMPTY , EMPTY , '9','d', EMPTY , 'e', EMPTY ,'4' , EMPTY , '0'},
                                    { EMPTY , EMPTY , EMPTY , EMPTY ,'f' ,'9','d' , EMPTY , EMPTY , '0', '4', '7', EMPTY ,  EMPTY, EMPTY , EMPTY },
                                    {'1', EMPTY , 'd', EMPTY ,'2' ,'O' ,'b' , 'f', EMPTY , EMPTY , '9', EMPTY , EMPTY , EMPTY ,'7','5'},
                                    { EMPTY ,  EMPTY, '0',  EMPTY, EMPTY , EMPTY , '1', EMPTY , EMPTY , EMPTY , EMPTY ,'b', 'd', 'e',  EMPTY,'a' },
                                    {'2', 'e', '7', EMPTY ,'9' ,  EMPTY,'a' , '8', '0', EMPTY ,  EMPTY, '5', 'b', 'c','6', '4'},
                                    {'b', EMPTY , EMPTY , EMPTY , EMPTY , EMPTY , EMPTY , EMPTY ,  EMPTY,'7' , EMPTY ,  EMPTY, '9','1' , EMPTY, EMPTY }};
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

	    if (possible(x, y, value)){
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
        int val = (int)Math.sqrt(getDimension());
        checkBornes(x,y);
        checkPossibles(value);

        for (int i = 0; i < this.grille.length; i++) {
            if (this.grille[i][y] == value || this.grille[x][i] == value || checkZone(x-(x%val), y-(y%val), value, val)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkZone(int x, int y, int num, int val) {
        for (int row = 0; row < val; row++)
            for (int col = 0; col < val; col++)
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
                                return false;
                            } else {
                                setValue(i, j, EMPTY);
                            }
                        } catch (IllegalArgumentException e) {
                            continue;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
