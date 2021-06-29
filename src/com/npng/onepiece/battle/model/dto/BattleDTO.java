package com.npng.onepiece.battle.model.dto;

import java.io.Serializable;

public class BattleDTO implements Serializable{

	private int cNumber;
	private int userNum;
	private int cLv;
	private String cName;
	private int cAtk;
	private int cHp;
	private int cMp;
	private int cLife;
	private int cExp;
	private int cStr;
	private int cDex;
	private int cCharisma;
	private int cPoint;
	private int cScore;
	
	private int mNum;
	private String mName;
	private String mCate;
	private int mLv;
	private int mAtk;
	private int mDef;
	private int mHp;
	private int mStr;
	private int mDex;
	private int mExp;
	private int mScore;
	private int mGord;
	
	public BattleDTO() {}

	public BattleDTO(int cNumber, int userNum, int cLv, String cName, int cAtk, int cHp, int cMp, int cLife, int cExp,
			int cStr, int cDex, int cCharisma, int cPoint, int cScore, int mNum, String mName, String mCate, int mLv,
			int mAtk, int mDef, int mHp, int mStr, int mDex, int mExp, int mScore, int mGord) {
		super();
		this.cNumber = cNumber;
		this.userNum = userNum;
		this.cLv = cLv;
		this.cName = cName;
		this.cAtk = cAtk;
		this.cHp = cHp;
		this.cMp = cMp;
		this.cLife = cLife;
		this.cExp = cExp;
		this.cStr = cStr;
		this.cDex = cDex;
		this.cCharisma = cCharisma;
		this.cPoint = cPoint;
		this.cScore = cScore;
		this.mNum = mNum;
		this.mName = mName;
		this.mCate = mCate;
		this.mLv = mLv;
		this.mAtk = mAtk;
		this.mDef = mDef;
		this.mHp = mHp;
		this.mStr = mStr;
		this.mDex = mDex;
		this.mExp = mExp;
		this.mScore = mScore;
		this.mGord = mGord;
	}

	public int getcNumber() {
		return cNumber;
	}

	public void setcNumber(int cNumber) {
		this.cNumber = cNumber;
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public int getcLv() {
		return cLv;
	}

	public void setcLv(int cLv) {
		this.cLv = cLv;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public int getcAtk() {
		return cAtk;
	}

	public void setcAtk(int cAtk) {
		this.cAtk = cAtk;
	}

	public int getcHp() {
		return cHp;
	}

	public void setcHp(int cHp) {
		this.cHp = cHp;
	}

	public int getcMp() {
		return cMp;
	}

	public void setcMp(int cMp) {
		this.cMp = cMp;
	}

	public int getcLife() {
		return cLife;
	}

	public void setcLife(int cLife) {
		this.cLife = cLife;
	}

	public int getcExp() {
		return cExp;
	}

	public void setcExp(int cExp) {
		this.cExp = cExp;
	}

	public int getcStr() {
		return cStr;
	}

	public void setcStr(int cStr) {
		this.cStr = cStr;
	}

	public int getcDex() {
		return cDex;
	}

	public void setcDex(int cDex) {
		this.cDex = cDex;
	}

	public int getcCharisma() {
		return cCharisma;
	}

	public void setcCharisma(int cCharisma) {
		this.cCharisma = cCharisma;
	}

	public int getcPoint() {
		return cPoint;
	}

	public void setcPoint(int cPoint) {
		this.cPoint = cPoint;
	}

	public int getcScore() {
		return cScore;
	}

	public void setcScore(int cScore) {
		this.cScore = cScore;
	}

	public int getmNum() {
		return mNum;
	}

	public void setmNum(int mNum) {
		this.mNum = mNum;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmCate() {
		return mCate;
	}

	public void setmCate(String mCate) {
		this.mCate = mCate;
	}

	public int getmLv() {
		return mLv;
	}

	public void setmLv(int mLv) {
		this.mLv = mLv;
	}

	public int getmAtk() {
		return mAtk;
	}

	public void setmAtk(int mAtk) {
		this.mAtk = mAtk;
	}

	public int getmDef() {
		return mDef;
	}

	public void setmDef(int mDef) {
		this.mDef = mDef;
	}

	public int getmHp() {
		return mHp;
	}

	public void setmHp(int mHp) {
		this.mHp = mHp;
	}

	public int getmStr() {
		return mStr;
	}

	public void setmStr(int mStr) {
		this.mStr = mStr;
	}

	public int getmDex() {
		return mDex;
	}

	public void setmDex(int mDex) {
		this.mDex = mDex;
	}

	public int getmExp() {
		return mExp;
	}

	public void setmExp(int mExp) {
		this.mExp = mExp;
	}

	public int getmScore() {
		return mScore;
	}

	public void setmScore(int mScore) {
		this.mScore = mScore;
	}

	public int getmGord() {
		return mGord;
	}

	public void setmGord(int mGord) {
		this.mGord = mGord;
	}

	@Override
	public String toString() {
		return "BattleDTO [cNumber=" + cNumber + ", userNum=" + userNum + ", cLv=" + cLv + ", cName=" + cName
				+ ", cAtk=" + cAtk + ", cHp=" + cHp + ", cMp=" + cMp + ", cLife=" + cLife + ", cExp=" + cExp + ", cStr="
				+ cStr + ", cDex=" + cDex + ", cCharisma=" + cCharisma + ", cPoint=" + cPoint + ", cScore=" + cScore
				+ ", mNum=" + mNum + ", mName=" + mName + ", mCate=" + mCate + ", mLv=" + mLv + ", mAtk=" + mAtk
				+ ", mDef=" + mDef + ", mHp=" + mHp + ", mStr=" + mStr + ", mDex=" + mDex + ", mExp=" + mExp
				+ ", mScore=" + mScore + ", mGord=" + mGord + "]";
	}
	
	
}
