package com.npng.onepiece.inventory.model.dto;

public class EquipDTO {
	
	private int eWeaponNum;
	private int eArmorNum;
	private int eASCNum;
	private int charNum;
	
	public EquipDTO() {}
	public EquipDTO(int eWeaponNum, int eArmorNum, int eASCNum, int charNum) {
		super();
		this.eWeaponNum = eWeaponNum;
		this.eArmorNum = eArmorNum;
		this.eASCNum = eASCNum;
		this.charNum = charNum;
	}
	public int geteWeaponNum() {
		return eWeaponNum;
	}
	public void seteWeaponNum(int eWeaponNum) {
		this.eWeaponNum = eWeaponNum;
	}
	public int geteArmorNum() {
		return eArmorNum;
	}
	public void seteArmorNum(int eArmorNum) {
		this.eArmorNum = eArmorNum;
	}
	public int geteASCNum() {
		return eASCNum;
	}
	public void seteASCNum(int eASCNum) {
		this.eASCNum = eASCNum;
	}
	public int getCharNum() {
		return charNum;
	}
	public void setCharNum(int charNum) {
		this.charNum = charNum;
	}
	@Override
	public String toString() {
		return "EquipDTO [eWeaponNum=" + eWeaponNum + ", eArmorNum=" + eArmorNum + ", eASCNum=" + eASCNum + ", charNum="
				+ charNum + "]";
	}
	
	
	
}
