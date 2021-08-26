package sudoku4;

import javax.swing.*; 

public class SudokuButton extends JButton implements ActionListener {
	private SudokuBoard sudoku;
	private SudokuFrame view;
	
	public SudokuButton(SudokuBoard s, SudokuFrame f) {
		sudoku = s;
		view = f;
		addActionListener(this);
	}
//	 public void actionPerformed(ActionEvent evt) {
//		 
//	 }
//		String s = check_square(); 
//		if (s.hasEmptyHoles() == true) {
//			boolean ok = .(Integer.parseInt(s));
//			if (ok) view.update();
//	}
}
