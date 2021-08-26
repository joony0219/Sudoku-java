package sudoku4;

import java.util.Arrays;
import java.util.Collections;

import javax.swing.*;

import sudoku4.SudokuFrame;
import sudoku4.SudokuBoard;

public class Sudoku4 {
	
	private SudokuBoard board;
	
	public Sudoku4() {
		board = new SudokuBoard(6);
	}
	
//	public void play() {
//		int row, col, num;
//		// view.printBoard();
//		while (board.hasEmptyHoles()) {
//			String input;
//			input = JOptionPane.showInputDialog("Row#(1,2,3,4)");
//			row = Integer.parseInt(input) - 1;
//			input = JOptionPane.showInputDialog("Column#(1,2,3,4)");
//			col = Integer.parseInt(input) - 1;
//			if (! board.isEmpty(row, col)) {
//				JOptionPane.showMessageDialog(null, "Not empty!");
//				continue;
//			}
//			input = JOptionPane.showInputDialog("Number(1,2,3,4)");
//			num = Integer.parseInt(input);
//			if (board.fillIn(num, row, col))
//				view.printBoard();
//			else
//				JOptionPane.showMessageDialog(null, "Wrong number!");
//		}
//		System.out.println("Bye!");
//	}
	public void play() {
	

	public static void main(String[] arg) {
		int size = 6;
		SudokuBoard board = new SudokuBoard(size);
		SudokuFrame frame = new SudokuFrame(size, board);
		//new Sudoku4().play();
	}

}