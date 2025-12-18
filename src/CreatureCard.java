/**
 * @author Caeden Mujahed
 * @version 1.0
 * An extension of the Card class that contains data and methods specific to creature cards
 */
public class CreatureCard extends Card{
	private int strength;
	private int cost;

	/**
	 * Constructor for the CreatureCard class
	 * @param cardID An internal string representing the card's stats. The standard format is "strength;cost"
	 */
	public CreatureCard(String cardID) {
		super(cardID);
		String[] stringStats = cardID.split(";");
		strength = Integer.parseInt(stringStats[0]);
		cost = Integer.parseInt(stringStats[1]);
	}
	
	/**
	 * Getter for the creature's strength
	 * @return The creature's strength
	 */
	public int getStrength() {
		return strength;
	}
	
	/**
	 * Getter for the creature's cost
	 * @return The creature's mana cost
	 */
	@Override
	public int getCost() {
		return cost;
	}

}
