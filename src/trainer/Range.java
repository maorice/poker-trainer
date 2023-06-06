package trainer;

import java.util.HashMap;

public class Range {
	int[][] rangeMatrix;
	static HashMap<String, Integer> indexMap = new HashMap<>();
	
	static {	
		String[] faces = {"deuce", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king", "ace"};
		int[] indices = {12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		for(int i = 0; i < 13; i++) {
			indexMap.put(faces[i], indices[i]);
		}
	}

	enum Positions {
		UTG, MP, CUTOFF, BUTTON, SB, BB
	}

	Positions position;

	public Range(int[][] rangeMatrix, String position) {
		this.rangeMatrix = rangeMatrix;
		this.position = Positions.valueOf(position.toUpperCase());
	}
	
	public String getPosition() {
		return position.toString();
	}
	
	public boolean checkSolution(Hand hand, int action) {
		int x = indexMap.get(hand.getCard(1).getFace());
		int y = indexMap.get(hand.getCard(2).getFace());
		if(!hand.suited()) {
			int temp = x;
			x = y;
			y = temp;
		}
		return action == rangeMatrix[x][y];
	}
	
	public int[][] getRange(){
		return rangeMatrix;
	}

}
