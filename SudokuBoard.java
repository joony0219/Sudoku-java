package sudoku4;

import java.util.*;

public class SudokuBoard {
	private int size;
	private int[][] board;
	private int holes;
	
	public SudokuBoard(int h) {
		board = createBoard(16-h);
		makeHoles(h);
		holes = h;
	}

	private int[][] createBoard(int h) {
		// initialize
		Integer base[] = {1,2,3,4};
		List<Integer> base_list = Arrays.asList(base);
		Collections.shuffle(base_list);
		int[] row0 = {base[0],base[1],base[2],base[3]};
		int[] row1 = {base[2],base[3],base[0],base[1]};
		int[] row2 = {base[1],base[0],base[3],base[2]};
		int[] row3 = {base[3],base[2],base[1],base[0]};
		// shuffle rows
		int[][] board = {row0, row1, row2, row3};
		board = shuffleRibbons(board);
		// shuffle columns
		board = transpose(board);
		board = shuffleRibbons(board);
		board = transpose(board);
		return board;
	}
	
	private int[][] shuffleRibbons(int[][] board) {
		int[] row0, row1, row2, row3;
		// shuffle the first half rows randomly
		if ((int)(Math.random()) == 0) {
			row0 = board[0];
			row1 = board[1];
		}
		else {
			row0 = board[1];
			row1 = board[0];
		}
		// shuffle the second half rows randomly
		if ((int)(Math.random()) == 0) {
			row2 = board[2];
			row3 = board[3];
		}
		else {
			row2 = board[3];
			row3 = board[2];
		}
		int[][] suhffled_board = {row0, row1, row2, row3};
		return suhffled_board;
	}
	
	private int[][] transpose(int[][] board) {
		int[] row0 = {board[0][0],board[1][0],board[2][0],board[3][0]};
		int[] row1 = {board[0][1],board[1][1],board[2][1],board[3][1]};
		int[] row2 = {board[0][2],board[1][2],board[2][2],board[3][2]};
		int[] row3 = {board[0][3],board[1][3],board[2][3],board[3][3]};
		int[][] transposed_board = {row0, row1, row2, row3};
		return transposed_board;
	}
	
	public void makeHoles(int count) {
		int n, i, j;
		while (count > 0) {
			n = (int)(Math.random() * 4 + 1);
			i = (int)(Math.random() * 4);
			j = (int)(Math.random() * 4);
			if (board[i][j] != 0) {
				board[i][j] = 0;
				count -= 1;
			}
		}
	}
	
	public int[][] getBoard() {
		return board;
	}
	
	public boolean hasEmptyHoles() {
		return holes > 0;
	}
	
	public boolean isEmpty(int i, int j) {
		return board[i][j] == 0;
	}
	
	public boolean fillIn(int n, int i, int j) {
		if (board[i][j] == 0 && line_safe(n,i,j) && square_safe(n,i,j)) {
			board[i][j] = n;
			holes -= 1;
			return true;
		}
		else
			return false;
	}
	
	private boolean line_safe(int n, int i, int j) {
		for (int k = 0; k < 4; k++) {
			if (board[i][k] == n)
				return false;
		}
		for (int k = 0; k < 4; k++) {
			if (board[k][j] == n)
				return false;
		}
		return true;
	}
	
	
	public SudokuPiece[][] contents() { 
		SudokuPiece[][] answer = new SudokuPiece[size][size];
		for(int i = 0; i != size; i = i + 1) 
			for(int j = 0; j != size; j = j + 1)
				answer[i][j] = board[i][j];
		return answer;
	}
	
	private boolean square_safe(int n, int i, int j) {
		boolean safe = true;
		if (i < 2)
			if (j < 2)
				safe = check_square(n, 0, 2, 0, 2);
			else
				safe = check_square(n, 0, 2, 2, 4);
		else
			if (j < 2)
				safe = check_square(n, 2, 4, 0, 2);
			else
				safe = check_square(n, 2, 4, 2, 4);
		return safe;
	}

	private boolean check_square(int n, int i_top, int i_bottom, int j_top, int j_bottom) {
		for (int k = i_top; k < i_bottom; k++)
			for (int l = j_top; l < j_bottom; l++) {
				if (board[k][l] == n)
					return false;
			}
		return true;
	}

}
