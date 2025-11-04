
public class TargetedSpellCard extends Card{
	int damage;
	int heal;
	int boost;
	
	public TargetedSpellCard(String cardID) {
		super(cardID);
		String[] stringStats = cardID.split(";");
		damage = Integer.parseInt(stringStats[0]);
		heal = Integer.parseInt(stringStats[1]);
		boost = Integer.parseInt(stringStats[2]);
	}	
}
