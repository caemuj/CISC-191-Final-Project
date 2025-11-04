import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class GUITest extends JFrame{
	public GUITest(Card displayCard) {
		setTitle("Test Window");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout(50,50));
		JLabel testLabel = new JLabel(displayCard.getImage());
		JPanel handPanel = new JPanel();
		handPanel.add(testLabel);
		add(testLabel, BorderLayout.NORTH);
		add(new JLabel(displayCard.getImage()), BorderLayout.CENTER);
		add(handPanel, BorderLayout.SOUTH);
		pack();
		setVisible(true);
	}
	public static void main(String[] args) {
		Card myCard = new Card("10;15");
		new GUITest(myCard);
	}
}
