package trainer;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class GUI {
	JFrame frame;
	JPanel cards;
	JPanel positionText;

	public GUI() {
		frame = new JFrame("New JFrame");
		frame.setSize(new Dimension(1000, 1000));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cards = new JPanel();
		positionText = new JPanel();
		cards.setSize(new Dimension(600, 400));
		positionText.setSize(new Dimension(100, 100));
		cards.setBounds(200, 100, 600, 400);
		positionText.setBounds(50, 50, 100, 100);
		frame.add(positionText);
		frame.add(cards);
		cards.setBackground(new Color(0));
		frame.setLayout(null);
	}

	public void displaySituation(Card c1, Card c2, String c1img, String c2img, String position) {
		System.out.println(c1img);
		System.out.println(c2img);
		JLabel rangePosition = new JLabel(position);
		ImageIcon icon = new ImageIcon(c1img);
		ImageIcon icon2 = new ImageIcon(c2img);
		JLabel card1Picture = new JLabel(icon);
		JLabel card2Picture = new JLabel(icon2);
		card1Picture.setBounds(0, 0, 300, 400);
		card2Picture.setBounds(0, 0, 300, 400);
		rangePosition.setBounds(0, 0, 100, 100);
		positionText.add(rangePosition);
		cards.add(card1Picture);
		cards.add(card2Picture);
		frame.setVisible(true);
	}
}
