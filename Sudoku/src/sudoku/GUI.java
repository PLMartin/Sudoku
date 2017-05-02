package sudoku;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// GRAPHISME

public class GUI extends JFrame {


    public GUI(Grid grid){
        super();
        buildFrame(grid);
    }


    private void buildFrame(final Grid sudoku){
        this.setSize(600, 600);
        this.setTitle("Sudoku");

        JPanel subpanel = null;
        JPanel panel =  new JPanel(new GridLayout(3,3));
        JTextField [][] grid = new JTextField[9][9];
        for (int fatsquare = 0; fatsquare < 9; ++fatsquare)
        {
            subpanel = new JPanel(new GridLayout(3,3));
            subpanel.setEnabled(false);
            Border lineBorder = new LineBorder(Color.BLACK,2);
            subpanel.setBorder(lineBorder);
            for(int smallsquare = 0; smallsquare < 9; ++smallsquare){
                final JTextField cell = new JTextField(1);
                final int x = smallsquare;
                final int y = fatsquare;
                cell.setEditable(true);
                cell.setFont(new Font("Serif", Font.BOLD, 20));
                cell.setHorizontalAlignment(JTextField.CENTER);
                int value = sudoku.getValue(fatsquare, smallsquare);
                String valueCell = "";
                if(value != 0)
                    valueCell = Integer.toString(value);

                cell.setText(valueCell);
                cell.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        //System.out.println(cell.getX() + " " + cell.getY() + "\n");
                        //System.out.println(cell.getWidth() + " " + cell.getHeight() + "\n");
                        System.out.println(x + "  " + y);
                        sudoku.play(y, x, Integer.parseInt(cell.getText()));
                        sudoku.display();
                        if(sudoku.checkCase(x, y)) {
                            cell.setEditable(false);
                        }
                        else{
                            sudoku.delete(x, y);
                            cell.setText("");
                        }
                    }
                });
                subpanel.add(cell);
            }
            panel.add(subpanel);
        }
        JButton valider = new JButton("Valider");
        valider.setSize(450, 50);
        JButton solve = new JButton("Résoudre");
        solve.setSize(450, 50);
        JPanel buttons = new JPanel();
        buttons.add(valider);
        buttons.add(solve);
        this.getContentPane().add(buttons, BorderLayout.SOUTH);
        this.getContentPane().add(panel);

        this.setVisible(true);
    }

    private void update(){

    }


}
