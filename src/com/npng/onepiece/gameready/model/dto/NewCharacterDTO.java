package com.npng.onepiece.gameready.model.dto;

public class NewCharacterDTO {

	private String name;
	private int level;
	private int atk;
	private int hp;
	private int life;
	private int exp;
	private int str;
	private int dex;
	private int charisma;
	private int point;
	private int mp;
	private int charNumber;
	private int userNum;
	private int score;
	
	public NewCharacterDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public NewCharacterDTO(String name, int level, int atk, int hp, int life, int exp, int str, int dex, int charisma,
			int point, int mp, int charNumber, int userNum, int score) {
		super();
		this.name = name;
		this.level = level;
		this.atk = atk;
		this.hp = hp;
		this.life = life;
		this.exp = exp;
		this.str = str;
		this.dex = dex;
		this.charisma = charisma;
		this.point = point;
		this.mp = mp;
		this.charNumber = charNumber;
		this.userNum = userNum;
		this.score = score;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}


	public int getAtk() {
		return atk;
	}


	public void setAtk(int atk) {
		this.atk = atk;
	}


	public int getHp() {
		return hp;
	}


	public void setHp(int hp) {
		this.hp = hp;
	}


	public int getLife() {
		return life;
	}


	public void setLife(int life) {
		this.life = life;
	}


	public int getExp() {
		return exp;
	}


	public void setExp(int exp) {
		this.exp = exp;
	}


	public int getStr() {
		return str;
	}


	public void setStr(int str) {
		this.str = str;
	}


	public int getDex() {
		return dex;
	}


	public void setDex(int dex) {
		this.dex = dex;
	}


	public int getCharisma() {
		return charisma;
	}


	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}


	public int getPoint() {
		return point;
	}


	public void setPoint(int point) {
		this.point = point;
	}


	public int getMp() {
		return mp;
	}


	public void setMp(int mp) {
		this.mp = mp;
	}


	public int getCharNumber() {
		return charNumber;
	}


	public void setCharNumber(int charNumber) {
		this.charNumber = charNumber;
	}


	public int getUserNum() {
		return userNum;
	}


	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	@Override
	public String toString() {
		return "NewCharacterDTO [name=" + name + ", level=" + level + ", atk=" + atk + ", hp=" + hp + ", life=" + life
				+ ", exp=" + exp + ", Str=" + str + ", Dex=" + dex + ", charisma=" + charisma + ", point=" + point
				+ ", mp=" + mp + ", charNumber=" + charNumber + ", userNum=" + userNum + ", score=" + score + "]";
	}



	



	






}


