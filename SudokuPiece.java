package sudoku4;

public class SudokuPiece {
	private int face_value;
	
	/** Constructor - SudokuPiece 퍼즐 조각을 만듬 
	 * @param value - 퍼즐 조각 위에 표시되는 값  */
	public SudokuPiece(int value) { 
		face_value = value; 
	}
	
	/** valueOf - 조각의 액면 값을 리턴  */ 
	public int valueOf() { 
		return face_value; 
	}
}
