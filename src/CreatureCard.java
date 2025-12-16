
public class CreatureCard extends Card{
	private int strength;
	private int cost;

	public CreatureCard(String cardID) {
		super(cardID);
		String[] stringStats = cardID.split(";");
		strength = Integer.parseInt(stringStats[0]);
		cost = Integer.parseInt(stringStats[1]);
	}
	
	public int getStrength() {
		return strength;
	}
	
	@Override
	public int getCost() {
		return cost;
	}

}
