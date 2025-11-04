
public class SpellCard extends Card{
	int draw;
	int discard;

	public SpellCard(String cardID) {
		super(cardID);
		String[] stringStats = cardID.split(";");
		draw = Integer.parseInt(stringStats[0]);
		discard = Integer.parseInt(stringStats[1]);
	}

}
