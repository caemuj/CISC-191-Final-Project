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
	JPanel allyPanel;
	public GUITest2(EnemyField enemies, Player player) {
		setTitle("Test Window");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout(50,50));
		JPanel enemyPanel = new JPanel();
		
		for(Card card : enemies.getEnemies()) {
			enemyPanel.add(new JLabel(card.getImage()));
		}
		
		allyPanel = new JPanel();
		DeckList testList = new DeckList();
		Deck playerDeck = new Deck(testList);
		
		for(Card c : playerDeck.getHand()) {
			allyPanel.add(new JLabel(c.getImage()));
		}
		
		JLabel health = new JLabel("" + player.getHealth());
		EndTurnButtonListener listener = new EndTurnButtonListener(this, enemies, player, health, playerDeck, allyPanel);
		EndTurnButton endTurn = new EndTurnButton("End Turn");
		endTurn.addActionListener(listener);
		JPanel stuff = new JPanel();
		stuff.add(endTurn);
		stuff.add(health);
		add(allyPanel, BorderLayout.CENTER);
		add(stuff, BorderLayout.SOUTH);
		add(enemyPanel, BorderLayout.NORTH);
		health.setText("" + player.getHealth());
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Player thePlayer = new Player();
		EnemyField enemies = new EnemyField(thePlayer);
		new GUITest2(enemies, thePlayer);
	}
	
	public static void lose() {
		JOptionPane.showMessageDialog(null, "You Lose");
		System.exit(0);
	}
	
	public void updateUI() {
		add(allyPanel, BorderLayout.CENTER);
		pack();
	}
}
