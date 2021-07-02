
package com.npng.onepiece.event.model.dto;

public class SceDTO {
	
	private int logionnum;
	private int charnum;
	
	
	/*시나리오*/
	private int scenum;
	private String scestroy;
	private String sceclear;
	private int sceexp;
	private int scescore;
	private int scemoney;
	/*선택지 스탯*/
	private int optnum;
	private int optstr;
	private int optdex;
	private int optcha;
	/* 캐릭터*/
	private int charlife;
	private int charstr;
	private int chardex;
	private int charcha;
	private int charexp;
	private int charscore;
	
	/*인벤토리 */
	private int invengold;
	
	

	public SceDTO() {
		
	}



	public int getLogionnum() {
		return logionnum;
	}



	public void setLogionnum(int logionnum) {
		this.logionnum = logionnum;
	}



	public int getCharnum() {
		return charnum;
	}



	public void setCharnum(int charnum) {
		this.charnum = charnum;
	}



	public int getScenum() {
		return scenum;
	}



	public void setScenum(int scenum) {
		this.scenum = scenum;
	}



	public String getScestroy() {
		return scestroy;
	}



	public void setScestroy(String scestroy) {
		this.scestroy = scestroy;
	}



	public String getSceclear() {
		return sceclear;
	}



	public void setSceclear(String sceclear) {
		this.sceclear = sceclear;
	}



	public int getSceexp() {
		return sceexp;
	}



	public void setSceexp(int sceexp) {
		this.sceexp = sceexp;
	}



	public int getScescore() {
		return scescore;
	}



	public void setScescore(int scescore) {
		this.scescore = scescore;
	}



	public int getScemoney() {
		return scemoney;
	}



	public void setScemoney(int scemoney) {
		this.scemoney = scemoney;
	}



	public int getOptnum() {
		return optnum;
	}



	public void setOptnum(int optnum) {
		this.optnum = optnum;
	}



	public int getOptstr() {
		return optstr;
	}



	public void setOptstr(int optstr) {
		this.optstr = optstr;
	}



	public int getOptdex() {
		return optdex;
	}



	public void setOptdex(int optdex) {
		this.optdex = optdex;
	}



	public int getOptcha() {
		return optcha;
	}



	public void setOptcha(int optcha) {
		this.optcha = optcha;
	}



	public int getCharlife() {
		return charlife;
	}



	public void setCharlife(int charlife) {
		this.charlife = charlife;
	}



	public int getCharstr() {
		return charstr;
	}



	public void setCharstr(int charstr) {
		this.charstr = charstr;
	}



	public int getChardex() {
		return chardex;
	}



	public void setChardex(int chardex) {
		this.chardex = chardex;
	}



	public int getCharcha() {
		return charcha;
	}



	public void setCharcha(int charcha) {
		this.charcha = charcha;
	}



	public int getCharexp() {
		return charexp;
	}



	public void setCharexp(int charexp) {
		this.charexp = charexp;
	}



	public int getCharscore() {
		return charscore;
	}



	public void setCharscore(int charscore) {
		this.charscore = charscore;
	}



	public int getInvengold() {
		return invengold;
	}



	public void setInvengold(int invengold) {
		this.invengold = invengold;
	}



	public SceDTO(int logionnum, int charnum, int scenum, String scestroy, String sceclear, int sceexp, int scescore,
			int scemoney, int optnum, int optstr, int optdex, int optcha, int charlife, int charstr, int chardex,
			int charcha, int charexp, int charscore, int invengold) {
		super();
		this.logionnum = logionnum;
		this.charnum = charnum;
		this.scenum = scenum;
		this.scestroy = scestroy;
		this.sceclear = sceclear;
		this.sceexp = sceexp;
		this.scescore = scescore;
		this.scemoney = scemoney;
		this.optnum = optnum;
		this.optstr = optstr;
		this.optdex = optdex;
		this.optcha = optcha;
		this.charlife = charlife;
		this.charstr = charstr;
		this.chardex = chardex;
		this.charcha = charcha;
		this.charexp = charexp;
		this.charscore = charscore;
		this.invengold = invengold;
	}



	@Override
	public String toString() {
		return "SceDTO [logionnum=" + logionnum + ", charnum=" + charnum + ", scenum=" + scenum + ", scestroy="
				+ scestroy + ", sceclear=" + sceclear + ", sceexp=" + sceexp + ", scescore=" + scescore + ", scemoney="
				+ scemoney + ", optnum=" + optnum + ", optstr=" + optstr + ", optdex=" + optdex + ", optcha=" + optcha
				+ ", charlife=" + charlife + ", charstr=" + charstr + ", chardex=" + chardex + ", charcha=" + charcha
				+ ", charexp=" + charexp + ", charscore=" + charscore + ", invengold=" + invengold + "]";
	}




	
	

}
