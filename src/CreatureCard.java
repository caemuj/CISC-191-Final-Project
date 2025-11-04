
public class CreatureCard extends Card{
	int health;
	int damage;

	public CreatureCard(String cardID) {
		super(cardID);
		String[] stringStats = cardID.split(";");
		health = Integer.parseInt(stringStats[0]);
		damage = Integer.parseInt(stringStats[1]);
	}

}
