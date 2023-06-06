package trainer;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class GUI implements ActionListener {
	JFrame frame;
	JPanel cardPanel;
	JPanel positionTextPanel;
	JPanel scoreTextPanel;
	JPanel buttonPanel;
	int action;
	boolean awaitingAction;
	int score;

	public GUI() {
		frame = new JFrame("Poker Preflop Trainer");
		frame.setSize(new Dimension(1000, 1000));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		cardPanel = new JPanel();
		positionTextPanel = new JPanel();
		buttonPanel = new JPanel();
		scoreTextPanel = new JPanel();

		cardPanel.setSize(new Dimension(600, 400));
		positionTextPanel.setSize(new Dimension(100, 100));
		buttonPanel.setSize(new Dimension(500, 100));
		scoreTextPanel.setSize(new Dimension(100, 100));

		cardPanel.setBounds(200, 100, 600, 400);
		positionTextPanel.setBounds(50, 50, 100, 100);
		buttonPanel.setBounds(50, 500, 750, 1000);
		scoreTextPanel.setBounds(800, 50, 100, 100);

		frame.add(positionTextPanel);
		frame.add(cardPanel);
		frame.add(buttonPanel);
		frame.add(scoreTextPanel);
		frame.setLayout(null);
	}

	public int displaySituation(Card c1, Card c2, String c1img, String c2img, String position, String score) {
		JLabel rangePosition = new JLabel(position);
		JLabel scoreText = new JLabel("Score: " + score);
		ImageIcon icon = new ImageIcon(c1img);
		ImageIcon icon2 = new ImageIcon(c2img);
		JLabel card1Picture = new JLabel(icon);
		JLabel card2Picture = new JLabel(icon2);
		JButton raise = new JButton("Raise");
		JButton fold = new JButton("Fold");
		JButton quit = new JButton("Quit");
		raise.setBounds(50, 500, 250, 700);
		fold.setBounds(250, 700, 450, 900);
		quit.setBounds(450, 900, 650, 1000);
		card1Picture.setBounds(0, 0, 300, 400);
		card2Picture.setBounds(0, 0, 300, 400);
		rangePosition.setBounds(0, 0, 100, 100);
		scoreText.setBounds(800, 50, 100, 100);
		positionTextPanel.add(rangePosition);
		cardPanel.add(card1Picture);
		cardPanel.add(card2Picture);
		buttonPanel.add(raise);
		buttonPanel.add(fold);
		buttonPanel.add(quit);
		scoreTextPanel.add(scoreText);
		frame.setVisible(true);
		
		raise.addActionListener(this);
		fold.addActionListener(this);
		quit.addActionListener(this);
		awaitingAction = true;
		action = -1;
		while(awaitingAction) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		cardPanel.removeAll();
		positionTextPanel.removeAll();
		buttonPanel.removeAll();
		scoreTextPanel.removeAll();
		return action;
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Raise") {
			action = 1;
		}
		else if(e.getActionCommand() == "Fold"){
			action = 0;
		}
		else {
			action = -1;
		}
		awaitingAction = false;
	}
}
