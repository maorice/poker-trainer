package trainer;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class GUI {
	JFrame frame;
	JPanel cards;
	ArrayList<Range> ranges;
	ArrayList<Card> deck;
	ArrayList<Hand> allHands;

	public GUI() {
		frame = new JFrame("New JFrame");
		frame.setSize(new Dimension(1000, 1000));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cards = new JPanel();
		cards.setSize(new Dimension(600, 400));
		cards.setBounds(200, 100, 600, 400);
		frame.add(cards);
		cards.setBackground(new Color(0));
		frame.setLayout(null);
	}

	public void start() {
		ImageIcon icon = new ImageIcon("resources/fronts/png_96_dpi/clubs_10.png");
		ImageIcon icon2 = new ImageIcon("resources/fronts/png_96_dpi/clubs_9.png");
		JLabel card1Picture = new JLabel(icon);
		JLabel card2Picture = new JLabel(icon2);
		card1Picture.setBounds(0, 0, 300, 400);
		card2Picture.setBounds(0, 0, 300, 400);
		cards.add(card1Picture);
		cards.add(card2Picture);
		frame.setVisible(true);
		while (true) {

		}
	}
}
