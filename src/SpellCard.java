
/**
 * @author Caeden Mujahed
 * @version 1.0
 * An extension of the Card class that contains data and methods specific to spell cards
 */
public class SpellCard extends Card{
	private int draw;
	private int cost;

	/**
	 * Constructor for the SpellCard class
	 * @param cardID An internal string representing the card's stats. The standard format is "draw;cost"
	 */
	public SpellCard(String cardID) {
		super(cardID);
		String[] stringStats = cardID.split(";");
		draw = Integer.parseInt(stringStats[0]);
		cost = Integer.parseInt(stringStats[1]);
	}
	
	/**
	 * Getter for the spell's cost
	 * @return The spell's mana cost
	 */
	@Override
	public int getCost(){
		return cost;
	}
	
	/**
	 * Getter for the spell's draw amount
	 * @return The number of cards drawn when the spell is played
	 */
	public int getDraw() {
		return draw;
	}

}
