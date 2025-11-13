import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.GridLayout;

public class GUITest2 extends JFrame{
	public GUITest2(EnemyField enemies, Player player) {
		setTitle("Test Window");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout(50,50));
		JPanel enemyPanel = new JPanel();
		for(Card card : enemies.getEnemies()) {
			enemyPanel.add(new JLabel(card.getImage()));
		}
		JLabel health = new JLabel("" + player.getHealth());
		EndTurnButtonListener listener = new EndTurnButtonListener(enemies, player, health);
		EndTurnButton endTurn = new EndTurnButton("End Turn");
		endTurn.addActionListener(listener);
		add(endTurn, BorderLayout.CENTER);
		add(health, BorderLayout.SOUTH);
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
}
