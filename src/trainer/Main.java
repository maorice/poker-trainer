package trainer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ArrayList<Card> deck = new ArrayList<Card>();
		HashMap<Card, String> imgMap = new HashMap<>();
		String[] faces = { "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen",
				"King", "Ace" };
		String[] altFaces = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king", "ace" };
		String[] suits = { "clubs", "diamonds", "hearts", "spades" };
		final String cardImgPath = "resources/png_96_dpi/";
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				Card temp = new Card(faces[j], suits[i]);
				deck.add(temp);
				imgMap.put(temp, cardImgPath + suits[i] + "_" + altFaces[j]);
			}
		}
		ArrayList<Range> ranges = new ArrayList<>();
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
		GUI gui = new GUI();
		gui.start();
	}
}
