/**
 * @author Caeden Mujahed
 * @version 1.0
 *          Manages score
 */
public class Director
{
	private static int levelScore = 0;

	/**
	 * A constructor for the Director class
	 */
	public Director()
	{
	}

	/**
	 * Increases the player's score by 1
	 */
	public static void addScore()
	{
		levelScore++;
	}

	/**
	 * Getter for the player's score
	 * 
	 * @return The player's current score
	 */
	public static int getScore()
	{
		return levelScore;
	}
}
