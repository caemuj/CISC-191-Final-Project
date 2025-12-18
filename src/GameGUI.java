import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.io.File;
import java.io.PrintWriter;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.BorderLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Caeden Mujahed
 * 
 * @version 1.0
 * This class is responsible for creating the main game window, updating the UI, and handling the game's end
 */
public class GameGUI extends JFrame{
	private JPanel handPanel;
	private JPanel fieldPanel;
	private JPanel enemyPanel;
	private JLabel manaLabel;
	private Player playerDeck;
	private EnemyField enemies;
	
	/**
	 * Constructor for the game window
	 * @param enemies The EnemyField object responsible for managing enemy cards
	 * @param playerDeck The Player object which is responsible for managing the player's resources
	 */
	public GameGUI(EnemyField enemies, Player playerDeck) {
		this.playerDeck = playerDeck;
		this.enemies = enemies;
		playerDeck.addUI(this);
		setTitle("Test Window");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout(50,50));
		enemyPanel = new JPanel();
		
		for(Card card : enemies.getEnemies()) {
			card.getView().addActionListener(new EnemyListener(card, enemies));
			enemyPanel.add(card.getView());
		}
		
		JPanel playerPanel = new JPanel();
		playerPanel.setLayout(new BorderLayout());
		handPanel = new JPanel();
		manaLabel = new JLabel("Mana: " + playerDeck.getMana());
		for(Card c : playerDeck.getHand()) {
			handPanel.add(c.getView());
		}
		playerPanel.add(handPanel, BorderLayout.SOUTH);
		fieldPanel = new JPanel();
		for(Card c : playerDeck.getField()) {
			fieldPanel.add(c.getView());
		}
		playerPanel.add(fieldPanel, BorderLayout.NORTH);
		JLabel health = new JLabel("Health: " + playerDeck.getHealth());
		EndTurnButtonListener listener = new EndTurnButtonListener(this, enemies, health, playerDeck, handPanel, manaLabel);
		EndTurnButton endTurn = new EndTurnButton("End Turn");
		playerDeck.addListeners();
		endTurn.addActionListener(listener);
		JPanel stuff = new JPanel();
		stuff.add(endTurn);
		stuff.add(health);
		stuff.add(manaLabel);
		add(playerPanel, BorderLayout.CENTER);
		add(stuff, BorderLayout.SOUTH);
		add(enemyPanel, BorderLayout.NORTH);
		this.setMinimumSize(new Rectangle(1400,600).getSize());
		pack();
		setVisible(true);
	}
	
	/**
	 * Main method to start the game
	 * @param args Not used
	 */
	public static void main(String[] args) {
		DeckList testList = new DeckList();
		Player playerDeck = new Player(testList);
		EnemyField enemies = new EnemyField(playerDeck);
		new GameGUI(enemies, playerDeck);
	}

	/**
	 * Method to handle the end of the game when the player loses. It updates score history, displays player score, and shows the local leaderboard.
	 */
	public static void lose() {
		String fileContents = "";
		try {
			Scanner fileScanner = new Scanner(new File("Leaderboard.txt"));
			while(fileScanner.hasNextLine()) {
				fileContents += fileScanner.nextLine() + "\n";
			}
			fileScanner.close();
		}
		catch(Exception e) {
		}
		String[] lines = fileContents.split("\n");
		ArrayList<Integer> scores = new ArrayList<Integer>();
		if(lines[0] != "") {
			for(int i = 0; i < lines.length; i++) {
				lines[i] = lines[i].replaceAll("Rank [0-9] Score: ", "");
			}
			for(int i = 0; i < lines.length; i++) {
				scores.add(Integer.parseInt(lines[i]));
			}
			Collections.sort(scores);
			for(int i = scores.size() - 1; i >= 0; i--) {
				if(scores.get(i) <= Director.getScore()) {
					scores.add(i + 1, Director.getScore());
					break;
				}
			}
		}
		else {
			scores.add(Director.getScore());
		}
		int counter = 1;
		String leaderboard = "";
		try {
			PrintWriter writer = new PrintWriter("Leaderboard.txt");
			for(int i = scores.size() - 1; i >= scores.size() - 5 && i >= 0; i--) {
				writer.println(String.format("Rank %d Score: %d", counter, scores.get(i)));
				leaderboard += String.format("Rank %d Score: %d\n", counter, scores.get(i));
				counter++;
			}
			writer.close();
		}
		catch(Exception e) {
			
		}
		
		JOptionPane.showMessageDialog(null, String.format("You Lost!\nYour Score: %d\n\nLeaderboard:\n%s", Director.getScore(), leaderboard));
		System.exit(0);
	}
	
	/**
	 * Method to update the game UI
	 */
	public void updateUI() {
		handPanel.removeAll();
		fieldPanel.removeAll();
		enemyPanel.removeAll();
		for(Card c : playerDeck.getHand()) {
			handPanel.add(c.getView());
		}
		for(Card c : playerDeck.getField()) {
			fieldPanel.add(c.getView());
		}
		for(Card c : enemies.getEnemies()) {
			enemyPanel.add(c.getView());
		}
		pack();
		repaint();
	}
	
	public JLabel getManaTag() {
		return manaLabel;
	}
	
	public EnemyField getEnemies() {
		return enemies;
	}
	
	public JPanel getAllyPanel() {
		return handPanel;
	}
}
