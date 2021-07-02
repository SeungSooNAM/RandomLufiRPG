package com.npng.onepiece.inventory.model.dto;

public class ArmorDTO extends ItemDTO{
	private int hp;
	private int dex;
	
	public ArmorDTO() {}
	public ArmorDTO(int hp, int dex) {
		super();
		this.hp = hp;
		this.dex = dex;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getDex() {
		return dex;
	}

	public void setDex(int dex) {
		this.dex = dex;
	}

	@Override
	public String toString() {
		return "ArmorDTO [hp=" + hp + ", dex=" + dex + "]";
	}
	
	
}
