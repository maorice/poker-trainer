package trainer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ArrayList<Card> deck = new ArrayList<>();
		ArrayList<Hand> allHands = new ArrayList<>();
		HashMap<Card, String> imgMap = new HashMap<>();
		GUI gui = new GUI();
		int score = 0;

		String[] faces = { "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen",
				"King", "Ace" };
		String[] altFaces = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king", "ace" };
		String[] suits = { "clubs", "diamonds", "hearts", "spades" };
		final String cardImgPath = "resources/fronts/png_96_dpi/";
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				Card temp = new Card(faces[j], suits[i]);
				deck.add(temp);
				imgMap.put(temp, cardImgPath + suits[i] + "_" + altFaces[j] + ".png");
			}
		}
		for (int i = 0; i < 52; i++) {
			for (int j = i + 1; j < 52; j++) {
				allHands.add(new Hand(deck.get(i), deck.get(j)));
			}
		}
		ArrayList<Range> ranges = new ArrayList<>();
		readData(ranges);

		int action = 0;
		while(action != -1) {
			int rangeIndex = (int) (Math.random() * ranges.size());
			int handIndex = (int) (Math.random() * allHands.size());
			Hand myHand = allHands.get(handIndex);
			Card myHandOne = myHand.getCard(1);
			Card myHandTwo = myHand.getCard(2);
			Range myRange = ranges.get(rangeIndex);
			action = gui.displaySituation(myHandOne, myHandTwo, imgMap.get(myHandOne), imgMap.get(myHandTwo), myRange.getPosition(), ((Integer) score).toString());
			if(action != -1) {
				if(myRange.checkSolution(myHand, action)) {
					score++;
					
				}
			}
		}
		
		System.out.println(writeData(ranges));
		System.exit(0);
	}

	public static void readData(ArrayList<Range> ranges) {
		File def = new File("resources/default.txt");
		try {
			FileReader reader = new FileReader(def);
			int c;
			while ((c = reader.read()) != -1) {
				int range[][] = new int[13][13];
				char character = (char) c;
				for (int i = 0; i < 13; i++) {
					for (int j = 0; j < 13; j++) {
						range[i][j] = reader.read() - '0';
					}
				}
				String position = null;
				if (character == 'D') {
					position = "Button";
				} else if (character == 'S') {
					position = "SB";
				} else if (character == 'B') {
					position = "BB";
				} else if (character == 'U') {
					position = "UTG";
				} else if (character == 'M') {
					position = "MP";
				} else if (character == 'C') {
					position = "CUTOFF";
				} else {
					System.err.println("Invalid Data File");
				}
				ranges.add(new Range(range, position));
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.err.println("File Error");
		} catch (IOException e) {
			System.err.println("IOException");
		}
	}
	
	public static int writeData(ArrayList<Range> ranges) {
		File def = new File("resources/default.txt");
		try {
			FileWriter writer = new FileWriter(def, false);
			for(Range r : ranges) {
				String position = r.getPosition();
				char c = '0';
				
				if(position.equals("UTG")) {
					c = 'U';
				}
				else if(position.equals("SB")) {
					c = 'S';
				}
				else if(position.equals("BB")) {
					c = 'B';
				}
				else if(position.equals("BUTTON")) {
					c = 'D';
				}
				else if(position.equals("CUTOFF")) {
					c = 'C';
				}
				else if(position.equals("MP")) {
					c = 'M';
				}
				else {
					System.err.println("Invalid Range Data");
					writer.close();
					return -1;
				}
				
				writer.write(c);
				int[][] rRange = r.getRange();
				for(int i = 0; i < 13; i++) {
					for(int j = 0; j < 13; j++) {
						writer.write(((Integer)rRange[i][j]).toString());
					}
				}
			}
			writer.close();
			return 0;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}
}
