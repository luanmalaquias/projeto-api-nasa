package com.Nasa.ProjetoNasa.model.insight;

public class Direction {

	private String point;
	private double degrees;
	private double up;
	private double right;
	
	public String getPoint() {
		return point;
	}
	public double getDegrees() {
		return degrees;
	}
	public double getUp() {
		return up;
	}
	public double getRight() {
		return right;
	}
	public void setPoint(String point) {
		this.point = point;
	}
	public void setDegrees(double degrees) {
		this.degrees = degrees;
	}
	public void setUp(double up) {
		this.up = up;
	}
	public void setRight(double right) {
		this.right = right;
	}

}
