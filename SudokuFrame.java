package sudoku4;

import java.awt.*;

import javax.swing.JFrame;

import sudoku4.SudokuButton;
import sudoku4.SudokuPiece; 
import sudoku4.SudokuBoard;

public class SudokuFrame extends JFrame {
	private SudokuBoard board;
	private int size, button_size = 60;
	private SudokuButton[][] button;
	
	public SudokuFrame(int board_size, SudokuBoard b) { 
		size = board_size; 
		board = b;
		button = new SudokuButton[size][size]; 
		Container cp = getContentPane(); 
		cp.setLayout(new GridLayout(size, size)); 
		for (int i=0; i<size; i++) 
			for(int j=0; j<size; j++) {
				button[i][j] = new SudokuButton(board, this);
				cp.add(button[i][j]);
			}		
		update();
		setTitle("Sudoku"); 
		setSize(size * button_size + 10, size * button_size + 20); 
		setVisible(true);
	}
	
	public void update() { 
		SudokuPiece[][] r = board.contents();
		for(int i=0; i<size; i++) 
			for(int j=0; j<size; j++) {
				if (r[i][j]!=null) {
					button[i][j].setBackground(Color.white);
					button[i][j].setText("" + r[i][j].valueOf()); 
				} 
				else { 
					button[i][j].setBackground(Color.black);
					button[i][j].setText("");
				}
			}
	}
}
