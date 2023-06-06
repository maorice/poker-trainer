package trainer;

public class Range {
	int[][] rangeMatrix;

	enum Positions {
		UTG, MP, CUTOFF, BUTTON, SB, BB
	}

	Positions position;

	public Range(int[][] rangeMatrix, String position) {
		this.rangeMatrix = rangeMatrix;
		this.position = Positions.valueOf(position.toUpperCase());
	}

}
