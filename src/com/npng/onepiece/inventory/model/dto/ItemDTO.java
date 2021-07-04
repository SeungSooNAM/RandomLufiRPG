package com.npng.onepiece.inventory.model.dto;

import java.io.Serializable;

public class ItemDTO implements Serializable{
	private int num;
	private String name;
	private int price;
	private String cate;
	private String grade;
	private String eq_yn;
	
	public ItemDTO() {}
	public ItemDTO(int num, String name, int price, String cate, String grade, String eq_yn) {
		super();
		this.num = num;
		this.name = name;
		this.price = price;
		this.cate = cate;
		this.grade = grade;
		this.eq_yn = eq_yn;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getEq_yn() {
		return eq_yn;
	}
	public void setEq_yn(String eq_yn) {
		this.eq_yn = eq_yn;
	}
	@Override
	public String toString() {
		return "ItemDTO [num=" + num + ", name=" + name + ", price=" + price + ", cate=" + cate + ", grade=" + grade
				+ ", eq_yn=" + eq_yn + "]";
	}
	
	
}
