package com.npng.onepiece.inventory.model.dto;

public class WeaponDTO extends ItemDTO{
	private int atk;
	private int str;
	public WeaponDTO() {}
	public WeaponDTO(int atk, int str) {
		super();
		this.atk = atk;
		this.str = str;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getStr() {
		return str;
	}

	public void setStr(int str) {
		this.str = str;
	}
	
	

}
