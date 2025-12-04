import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;

public class GUITest2 extends JFrame{
	JPanel handPanel;
	JPanel fieldPanel;
	JPanel enemyPanel;
	Player playerDeck;
	EnemyField enemies;
	public GUITest2(EnemyField enemies, Player playerDeck) {
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
		for(Card c : playerDeck.getHand()) {
			c.getView().addActionListener(new CardListener(c, playerDeck, enemies));
			handPanel.add(c.getView());
		}
		playerPanel.add(handPanel, BorderLayout.SOUTH);
		fieldPanel = new JPanel();
		for(Card c : playerDeck.getField()) {
			fieldPanel.add(c.getView());
		}
		playerPanel.add(fieldPanel, BorderLayout.NORTH);
		JLabel health = new JLabel("" + playerDeck.getHealth());
		EndTurnButtonListener listener = new EndTurnButtonListener(this, enemies, health, playerDeck, handPanel);
		EndTurnButton endTurn = new EndTurnButton("End Turn");
		endTurn.addActionListener(listener);
		JPanel stuff = new JPanel();
		stuff.add(endTurn);
		stuff.add(health);
		add(playerPanel, BorderLayout.CENTER);
		add(stuff, BorderLayout.SOUTH);
		add(enemyPanel, BorderLayout.NORTH);
		health.setText("" + playerDeck.getHealth());
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		DeckList testList = new DeckList();
		Player playerDeck = new Player(testList);
		EnemyField enemies = new EnemyField(playerDeck);
		new GUITest2(enemies, playerDeck);
	}

	public static void win() {
		Director.addScore();
		JOptionPane.showMessageDialog(null, "You Win");
		System.exit(0);
	}
	public static void lose() {
		JOptionPane.showMessageDialog(null, "You Lose");
		System.exit(0);
	}
	
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
	}
}
