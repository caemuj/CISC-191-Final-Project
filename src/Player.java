
public class Player {
	int hp;
	public Player() {
		hp = 10;
	}
	public void takeDamage() {
		hp--;
	}
	public int getHealth() {
		return hp;
	}
}
