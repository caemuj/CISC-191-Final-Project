import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

import javax.swing.JPanel;

/**
 * @author Caeden Mujahed
 * @version 1.0
 *          Responsible for managing the player's board state and resources
 */
public class Player
{
	private GameGUI ui;
	private Stack<Card> drawPile;
	private LinkedList<Card> discardPile;
	private ArrayList<Card> hand;
	private ArrayList<Card> field;
	private DeckList cards;
	private int hp;
	private int maxMana;
	private int mana;

	/**
	 * A constructor for the Player class
	 * 
	 * @param cards The DeckList object containing the list of cards in the
	 *              player's deck
	 */
	public Player(DeckList cards)
	{
		hp = 10;
		mana = 5;
		maxMana = 5;
		discardPile = new LinkedList<Card>();
		this.cards = cards;
		drawPile = new Stack<Card>();
		for (Card c : cards.getCards())
		{
			drawPile.add(c);
		}
		Collections.shuffle(drawPile);
		hand = new ArrayList<Card>();
		for (int i = 0; i < 5; i++)
		{
			hand.add(drawPile.pop());
		}
		field = new ArrayList<Card>();
	}

	/**
	 * Method to reduce the player's health, called when the enemy attacks the
	 * player directly
	 * 
	 * @param damage The amount of damage to be dealt to the player
	 */
	public void takeDamage(int damage)
	{
		hp -= damage;
	}

	/**
	 * Getter for the player's current health
	 * 
	 * @return The player's current health
	 */
	public int getHealth()
	{
		return hp;
	}

	/**
	 * A method to add CardListeners to all of the player's cards
	 */
	public void addListeners()
	{
		for (Card c : cards.getCards())
		{
			c.getView().addActionListener(new CardListener(c, this,
					ui.getEnemies(), ui.getManaTag()));
		}
	}

	/**
	 * A method that checks to see if the player's field has space
	 * 
	 * @return Boolean value, true if player's field has space, false if it is
	 *         full
	 */
	public boolean fieldHasSpace()
	{
		if (field.size() >= 5)
		{
			return false;
		}
		return true;
	}

	/**
	 * Method to draw a card from the player's draw pile into their hand
	 * 
	 * @return The Card object drawn, or null if the draw and discard piles are
	 *         empty
	 */
	public Card draw()
	{
		if (drawPile.size() == 0)
		{
			while (discardPile.size() != 0)
			{
				Card c = discardPile.removeFirst();
				c.getView().offField();
				drawPile.add(c);
			}
		}
		if (drawPile.size() != 0 && hand.size() < 7)
		{
			Card drawnCard = drawPile.pop();
			hand.add(drawnCard);
			ui.updateUI();
			return drawnCard;
		}
		else
		{
			return null;
		}
	}

	public void draw(int drawAmount)
	{
		for (int i = 1; i <= drawAmount; i++)
		{
			draw();
		}
	}

	/**
	 * Getter for the player's hand
	 * 
	 * @return The ArrayList of Card objects in the player's hand
	 */
	public ArrayList<Card> getHand()
	{
		return hand;
	}

	/**
	 * Method to add a card from the player's hand to the field
	 * 
	 * @param addedCard The Card object to be added to the field
	 */
	public void addToField(Card addedCard)
	{
		field.add(addedCard);
		hand.remove(addedCard);
		ui.updateUI();
	}

	/**
	 * Method to link the GameGUI object to the Player for UI updates
	 * 
	 * @param ui The GameGUI object for the current game
	 */
	public void addUI(GameGUI ui)
	{
		this.ui = ui;
	}

	/**
	 * Method to check if the player's field is empty. Used to determine if
	 * enemies attack the player directly or attack cards on the field.
	 * 
	 * @return True if the field is empty, false otherwise
	 */
	public boolean fieldIsEmpty()
	{
		if (field.size() == 0)
		{
			return true;
		}
		return false;
	}

	/**
	 * Method to handle when the player's field is attacked by an enemy card
	 * 
	 * @param enemy The attacking enemy Card object
	 */
	public void fieldAttacked(Card enemy)
	{
		if (enemy.getStrength() >= field.get(0).getStrength())
		{
			discardPile.add(field.removeFirst());
		}
	}

	/**
	 * Getter for the player's field
	 * 
	 * @return The ArrayList of Card objects on the player's field
	 */
	public ArrayList<Card> getField()
	{
		return field;
	}

	/**
	 * Disables all player cards to prevent interaction. Stops player from
	 * attacking when it's not their turn and from trying to attack themselves.
	 */
	public void disableAllPlayerCards()
	{
		for (Card c : hand)
		{
			c.getView().setEnabled(false);
		}
		for (Card c : field)
		{
			c.getView().setEnabled(false);
		}
	}

	/**
	 * Enables all player cards to allow interaction. Used when it's the
	 * player's turn.
	 */
	public void enableAllPlayerCards()
	{
		for (Card c : hand)
		{
			c.getView().setEnabled(true);
		}
		for (Card c : field)
		{
			c.getView().setEnabled(true);
		}
	}

	/**
	 * Method to update the UI to reflect changes in the player's state. Useful
	 * for classes that have access to the Player but not the GameGUI.
	 */
	public void updateUI()
	{
		ui.updateUI();
	}

	/**
	 * Getter for the player's current mana
	 * 
	 * @return The player's current mana
	 */
	public int getMana()
	{
		return mana;
	}

	public void removeCard(Card card)
	{
		discardPile.add(card);
		hand.remove(card);
		ui.updateUI();
	}

	/**
	 * Method to reset the player's mana to the maximum at the start of their
	 * turn
	 */
	public void resetMana()
	{
		mana = maxMana;
	}

	/**
	 * Method to spend mana
	 * 
	 * @param cost The amount of mana to be spent
	 */
	public void spendMana(int cost)
	{
		mana = mana - cost;
	}
}
