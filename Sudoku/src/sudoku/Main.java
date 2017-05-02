package sudoku;


public class Main {
    public static void main(String [] args){
        Grid grid = new Grid("sudoku.txt");
        GUI gui = new GUI(grid);
    }
}
