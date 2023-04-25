package trainer;

public class Range {
	static String[] faces = { "Ace", "King", "Queen", "Jack", "Ten", "Nine", "Eight", "Seven", "Six", "Five", "Four",
			"Three", "Deuce" };
	int[][] rangeMatrix;

	enum Positions {
		UTG, MP, CUTOFF, BUTTON, SB, BB
	}

	Positions position;

	public Range(int[][] rangeMatrix, String position) {
		this.rangeMatrix = rangeMatrix;
		this.position = Positions.valueOf(position.toUpperCase());
	}

	public int printSimulation(int x, int y) {
		System.out.print("You have ");
		if (x == y) {
			System.out.print("Pocket " + faces[x]);
			if (x == 8) {
				System.out.print("e");
			}
			System.out.print("s ");
		} else {
			if (x > y) {
				System.out.print(faces[y] + " " + faces[x] + " Suited ");
			} else {
				System.out.print(faces[x] + " " + faces[y] + " Off-Suit ");
			}
		}
		System.out.print("in the " + position.toString() + " position. Raise or fold?\n");
		return rangeMatrix[y][x];
	}
}
