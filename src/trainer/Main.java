package trainer;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ArrayList<Range> ranges = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		int[][] myBoard = new int[13][13];
		for(int i = 0; i < 13; i++) {
			for(int j = 0; j < 13; j++) {
				myBoard[i][j] = 1;
			}
		}
		Range myRange = new Range(myBoard, "Button");
		ranges.add(myRange);
		startSimulations(ranges, scan);
	}

	public static void startSimulations(ArrayList<Range> ranges, Scanner scan) {
		int score = 0;
		System.out.println("Welcome to the simulation zone! Type 'quit' at any time to quit. Type 'score' at any time to see your score!");
		while (true) {
			int range = (int) (Math.random() * ranges.size() - 1);
			int x = (int) (Math.random() * 13);
			int y = (int) (Math.random() * 13);
			int correctDecision = ranges.get(range).printSimulation(x, y);
			String playerInput = scan.nextLine();
			int playerDecision;
			if(playerInput.toLowerCase().equals("quit")) {
				break;
			}
			if(playerInput.toLowerCase().equals("score")) {
				System.out.println("Score: " + score);
				playerInput = scan.nextLine();
			}
			if (playerInput.toLowerCase().equals("raise")) {
				playerDecision = 1;
			} else if (playerInput.toLowerCase().equals("fold")) {
				playerDecision = 0;
			} else {
				playerDecision = -1;
			}
			if (playerDecision == correctDecision) {
				System.out.println("Great job, that's correct!");
				score++;
			} else {
				System.out.print("Not quite, you'd want to ");
				if (correctDecision == 1) {
					System.out.print("raise");
				} else {
					System.out.print("fold");
				}
				System.out.print(" here.\n");
			}
		}
	}

}
