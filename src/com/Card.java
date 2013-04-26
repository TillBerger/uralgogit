package com;


public class Card implements Comparable<Card> {
	private String name, clan, condition, effect, rarity, elo;
	private int lvl, pow, dmg, effectvalue, min, maxlvl, id, value;
	


	/**
	 * @param name
	 * @param clan
	 * @param condition
	 * @param effect
	 * @param rarity
	 * @param lvl
	 * @param pow
	 * @param dmg
	 * @param effectvalue
	 * @param min
	 * @param maxlvl
	 * @param id
	 */
	public Card(String name, String clan, int lvl, int pow, int dmg,
			String condition, String effect, int effectvalue, int min,
			String elo, String rarity, int value) {
		this.name = name;
		this.clan = clan;
		this.condition = condition;
		this.effect = effect;
		this.rarity = rarity;
		this.lvl = lvl;
		this.pow = pow;
		this.dmg = dmg;
		this.effectvalue = effectvalue;
		this.min = min;
		this.elo = elo;
		this.value = value;
	}
	
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getElo() {
		return elo;
	}
	public void setElo(String elo) {
		this.elo = elo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClan() {
		return clan;
	}
	public void setClan(String clan) {
		this.clan = clan;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getEffect() {
		return effect;
	}
	public void setEffect(String effect) {
		this.effect = effect;
	}
	public String getRarity() {
		return rarity;
	}
	public void setRarity(String rarity) {
		this.rarity = rarity;
	}
	public int getLvl() {
		return lvl;
	}
	public void setLvl(int lvl) {
		this.lvl = lvl;
	}
	public int getPow() {
		return pow;
	}
	public void setPow(int pow) {
		this.pow = pow;
	}
	public int getDmg() {
		return dmg;
	}
	public void setDmg(int dmg) {
		this.dmg = dmg;
	}
	public int getEffectvalue() {
		return effectvalue;
	}
	public void setEffectvalue(int effectvalue) {
		this.effectvalue = effectvalue;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMaxlvl() {
		return maxlvl;
	}
	public void setMaxlvl(int maxlvl) {
		this.maxlvl = maxlvl;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	




	@Override
	public int compareTo(Card c) {
		return name.compareTo(((Card)c).getName());
	}
}

