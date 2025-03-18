package com.spring_SpEL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("demo")
public class Demo {

	// Normal expression
	@Value("#{54+4}")
	private int x;
	// if else or Ternary operation
	@Value("#{ 8 > 4 ? 54 : 4 }")
	private int y;
	// Static method expression
	@Value("#{ T(java.lang.Math).sqrt(144) }")
	private double sqr;
	// Static variable
	@Value("#{ T(java.lang.Math).PI }")
	private double p;
	// Object type system and user-defined
	@Value("#{ new java.lang.String('Ujjwal pandey obj expression')  }")
	private String st;
	// Boolean type expression default false
	@Value("#{ true }") // or@Value("#{ 5>3 }")
	private boolean bol;

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	public double getSqr() {
		return sqr;
	}
	public void setSqr(double sqr) {
		this.sqr = sqr;
	}

	public double getP() {
		return p;
	}
	public void setP(double p) {
		this.p = p;
	}
	public String getSt() {
		return st;
	}
	public void setSt(String st) {
		this.st = st;
	}

	public boolean isBol() {
		return bol;
	}
	public void setBol(boolean bol) {
		this.bol = bol;
	}
	public void des() {
		System.out.println("Inside SpEl dis method");
	}
	@Override
	public String toString() {
		return "Demo [\n x=" + x + ",\n y=" + y + ",\n sqr=" + sqr + ",\n p="
				+ p + ",\n st=" + st + ",\n bol=" + bol + "\n]";
	}

}
