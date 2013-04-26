
public class Player {
	private int life, pills;
	private int[] poison, heal; //die arrays muessen laenge 2 haben, aber kp wie
	private Card[] cards; //laenge 4
	
	public Player(int life, int pills, int[] poison, int[] heal, Card[] cards) {
		this.life = life;
		this.pills = pills;
		this.poison = poison;
		this.heal = heal;
		this.cards = cards;
	}

	//getters und setters fuer poison, heal und cards koennen so doch garnicht funktionieren glaub ich
	
	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public int getPills() {
		return pills;
	}

	public void setPills(int pills) {
		this.pills = pills;
	}

	public int[] getPoison() {
		return poison;
	}

	public void setPoison(int[] poison) {
		this.poison = poison;
	}

	public int[] getHeal() {
		return heal;
	}

	public void setHeal(int[] heal) {
		this.heal = heal;
	}

	public Card[] getCards() {
		return cards;
	}

	public void setCards(Card[] cards) {
		this.cards = cards;
	}
	
}
