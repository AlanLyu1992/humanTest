package com.iweb.nct.entity;

public class Result {
	private int id;
	private int userId;
	private int[] result;
	private int c1;
	private int c2;
	private int c3;
	private int c4;
	private int c5;
	private int c6;
	private int c7;
	private int c8;
	private int c9;
	
	public int getC1() {
		return c1;
	}
	public void setC1(int c1) {
		this.c1 = c1;
	}
	public int getC2() {
		return c2;
	}
	public void setC2(int c2) {
		this.c2 = c2;
	}
	public int getC3() {
		return c3;
	}
	public void setC3(int c3) {
		this.c3 = c3;
	}
	public int getC4() {
		return c4;
	}
	public void setC4(int c4) {
		this.c4 = c4;
	}
	public int getC5() {
		return c5;
	}
	public void setC5(int c5) {
		this.c5 = c5;
	}
	public int getC6() {
		return c6;
	}
	public void setC6(int c6) {
		this.c6 = c6;
	}
	public int getC7() {
		return c7;
	}
	public void setC7(int c7) {
		this.c7 = c7;
	}
	public int getC8() {
		return c8;
	}
	public void setC8(int c8) {
		this.c8 = c8;
	}
	public int getC9() {
		return c9;
	}
	public void setC9(int c9) {
		this.c9 = c9;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int[] getResult() {
		return result;
	}
	public void setResult(int[] result) {
		this.result = result;
		this.c1 = result[0];
		this.c2 = result[1];
		this.c3 = result[2];
		this.c4 = result[3];
		this.c5 = result[4];
		this.c6 = result[5];
		this.c7 = result[6];
		this.c8 = result[7];
		this.c9 = result[8];
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
