package com;
import java.util.Arrays;


public class Simulation {
	public int life_p1;
	public int pills_p1;
	public int poison_value_p1;
	public int poison_min_p1;
	public int heal_value_p1;
	public int heal_max_p1;
	public String teameffect_p1;
	public boolean[] available_cards_p1;
	public boolean[] bonus_p1;
	public Card[] deck_p1;
	
	public int life_p2;
	public int pills_p2;
	public int poison_value_p2;
	public int poison_min_p2;
	public int heal_value_p2;
	public int heal_max_p2;
	public String teameffect_p2;
	public boolean[] available_cards_p2;
	public boolean[] bonus_p2;
	public Card[] deck_p2;
	
	public Simulation(int life_p1, int pills_p1, int life_p2, int pills_p2, Card[] deck_p1, Card[] deck_p2){
	    this.life_p1			= life_p1;
	    this.pills_p1			= pills_p1;
	    this.life_p2			= life_p2;
	    this.pills_p2			= pills_p2;
	    this.deck_p1			= deck_p1;
	    this.deck_p2			= deck_p2;
	    
	    this.poison_value_p1	= 0;
	    this.poison_min_p1		= 0;
	    this.heal_value_p1		= 0;
	    this.heal_max_p1		= 0;
	    this.teameffect_p1		= "";
	    this.available_cards_p1	= new boolean[4];
	    Arrays.fill(available_cards_p1, true);
	    this.bonus_p1	= new boolean[4];
	    Arrays.fill(bonus_p1, false);
	    this.poison_value_p2	= 0;
	    this.poison_min_p2		= 0;
	    this.heal_value_p2		= 0;
	    this.heal_max_p2		= 0;
	    this.teameffect_p2		= "";
	    this.available_cards_p2	= new boolean[4];
	    Arrays.fill(available_cards_p2, true);
	    this.bonus_p2	= new boolean[4];
	    Arrays.fill(bonus_p2, false);
	}

	public Simulation(int life_p1, int pills_p1, int poison_value_p1, int poison_min_p1, int heal_value_p1, int heal_max_p1, String teameffect_p1, boolean[] available_cards_p1, boolean[] bonus_p1, int life_p2, int pills_p2, int poison_value_p2, int poison_min_p2, int heal_value_p2, int heal_max_p2, String teameffect_p2, boolean[] available_cards_p2, boolean[] bonus_p2, Card[] deck_p1, Card[] deck_p2){
	    this.life_p1			= life_p1;
	    this.pills_p1			= pills_p1;
	    this.life_p2			= life_p2;
	    this.pills_p2			= pills_p2;
	    this.deck_p1			= deck_p1;
	    this.deck_p2			= deck_p2;
	    
	    this.poison_value_p1	= poison_value_p1;
	    this.poison_min_p1		= poison_min_p1;
	    this.heal_value_p1		= heal_value_p1;
	    this.heal_max_p1		= heal_max_p1;
	    this.teameffect_p1		= teameffect_p1;
	    this.available_cards_p1	= available_cards_p1;
	    this.poison_value_p2	= poison_value_p2;
	    this.poison_min_p2		= poison_min_p2;
	    this.heal_value_p2		= heal_value_p2;
	    this.heal_max_p2		= heal_max_p2;
	    this.teameffect_p2		= teameffect_p2;
	    this.available_cards_p2	= available_cards_p2;
	}

	public Simulation copy(){
	    return new Simulation(life_p1, pills_p1, poison_value_p1, poison_min_p1, heal_value_p1, heal_max_p1, teameffect_p1, available_cards_p1.clone(), bonus_p1.clone(), life_p2, pills_p2, poison_value_p2, poison_min_p2, heal_value_p2, heal_max_p2, teameffect_p2, available_cards_p2.clone(), bonus_p2.clone(), deck_p1, deck_p2);
	}

	public boolean[][] effects(Card[] deck){
		boolean[][] eff = new boolean[2][4];
		for (int j=0; j<3; j++){
			for (int i=j+1; i<4; i++){
				if (deck[j].getClan().equals(deck[i].getClan())){
					eff[1][j] = true;
					eff[1][i] = true;
				}
			}
		}
		return eff;
	}

	public void calculateFight(){

	}
	
	public void output(){
		System.out.println("P1:");
		System.out.println("A: " + effects(deck_p1)[0][0] + " " + effects(deck_p1)[0][1] + " " + effects(deck_p1)[0][2] + " " + effects(deck_p1)[0][3]);
		System.out.println("B: " + effects(deck_p1)[1][0] + " " + effects(deck_p1)[1][1] + " " + effects(deck_p1)[1][2] + " " + effects(deck_p1)[1][3]);
		System.out.println("");
		System.out.println("P2:");
		System.out.println("A: " + effects(deck_p2)[0][0] + " " + effects(deck_p2)[0][1] + " " + effects(deck_p2)[0][2] + " " + effects(deck_p2)[0][3]);
		System.out.println("B: " + effects(deck_p2)[1][0] + " " + effects(deck_p2)[1][1] + " " + effects(deck_p2)[1][2] + " " + effects(deck_p2)[1][3]);
	}
}