package sudoku;

import java.io.*;

public class Grid {

    private int [][] table = new int[9][9];

    private int nbCasesVides;

    public Grid(){
        for(int colonne = 0 ; colonne < 9 ; ++colonne){
            for(int ligne = 0 ; ligne < 9 ; ++ligne){
                //table[colonne][ligne] = 0; maybe useless

            }
        }
    }

    public Grid(String file){
        try {
            DataInputStream loading = new DataInputStream(new FileInputStream(file));
            int n = 0;
            int c = 0;
            while((c = loading.readInt()) != 0){
                System.out.print(c + "|");
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }
        catch( IOException e){
            System.out.println("IOException");
        }
    }

    private int howManyBlankCell(){
        int nbBlankCell = 0;
        for(int [] col : table){
            for(int cell : col){
                if(cell == 0){this.nbCasesVides += 1;}
            }
        }
        return nbBlankCell;
    }

    public void play(int line, int col, int value){
        assert(table[col][line] == 0);
        table[col][line] = value;
    }

    public void delete(int line, int col){
        table[col][line] = 0;
    }

    public int getValue(int line, int col){
        return table[col][line];
    }

    private boolean checkLigne(int line){
        for(int colonne = 0 ; colonne < 9 ; ++colonne){
            if(table[colonne][line] != 0){
                for(int check = 0 ; check < 9 ; ++check) {
                    if (check != colonne) {
                        if (table[colonne][line] == table[check][line])
                            return false;
                    }
                }
            }
        }
    return true;
    }

    private boolean checkColonne(int col){
        for(int ligne = 0 ; ligne < 9 ; ++ligne){
            if(table[col][ligne] != 0){
                for(int check = 0 ; check < 9 ; ++check){
                    if(check != ligne)
                    {
                        if(table[col][ligne] == table[col][check])
                            return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean checkCase(int line, int col) {
        return checkColonne(col) && checkLigne(line);
    }


    public void save(){
        //TODO Saving
    }

    // TODO public boolean solve(){}

    public void display(){
        for(int col = 0 ; col < 9; ++col){
            System.out.println("_______________________");
            if((col % 3) == 0)
                System.out.println("_______________________");
            for(int line = 0 ; line < 9; ++line){
                if((line % 3) == 0)
                    System.out.print("|");
                System.out.print("|");
                System.out.print(table[col][line]);
            }
            System.out.print("||\n");
        }
        System.out.println("_______________________");
    }

}
