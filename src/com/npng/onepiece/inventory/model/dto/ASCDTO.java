package com.npng.onepiece.inventory.model.dto;

public class ASCDTO extends ItemDTO{
	
	private int cha;
	private int mp;
	
	public ASCDTO() {}
	public ASCDTO(int cha, int mp) {
		super();
		this.cha = cha;
		this.mp = mp;
	}
	public int getCha() {
		return cha;
	}
	public void setCha(int cha) {
		this.cha = cha;
	}
	public int getMp() {
		return mp;
	}
	public void setMp(int mp) {
		this.mp = mp;
	}
	
	@Override
	public String toString() {
		return "ASCDTO [cha=" + cha + ", mp=" + mp + "]";
	}
	
	
}
