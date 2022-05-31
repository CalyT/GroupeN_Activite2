public class prog {
    public static void main(String[] args) {
        GrilleImpl test = new GrilleImpl(16);
        test.initialisation4();
        System.out.println("Sudoku début");
        test.print2D();
        test.solveur();
        if (test.complete()) {
            System.out.println("Sudoku possible :");
            test.print2D();
        } else {
            System.out.println("Sudoku impossible :");
            test.print2D();
        }
    }
}
