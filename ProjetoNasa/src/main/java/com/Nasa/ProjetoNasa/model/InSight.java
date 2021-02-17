package com.Nasa.ProjetoNasa.model;

import com.Nasa.ProjetoNasa.model.insight.Air;
import com.Nasa.ProjetoNasa.model.insight.Measurement;
import com.Nasa.ProjetoNasa.model.insight.Wind;

public class InSight {

	private int sol;
	private String season;
	private Measurement measurement;
	private Air air;
	private Wind wind;

	@Override
	public String toString() {
		String s = "";
		s += "Sol: " + this.sol + "\n";
		s += "Season: " + this.season + "\n";
		s += "Measurement First: " + this.measurement.getFirst() + "\n";
		s += "Measurement Last: " + this.measurement.getLast() + "\n\n";
		s += "Air Temperature Maximum: " + this.air.getTemperature().getMaximum() + " F | " + celsiusConverter(Double.parseDouble(air.getTemperature().getMaximum())) + " C\n";
		s += "Air Temperature Average: " + this.air.getTemperature().getAverage() + " F | " + celsiusConverter(Double.parseDouble(air.getTemperature().getAverage())) + " C\n";
		s += "Air Temperature Minimum: " + this.air.getTemperature().getMinimum() + " F | " + celsiusConverter(Double.parseDouble(air.getTemperature().getMinimum())) + " C\n";
		s += "Wind Speed Maximum: " + this.wind.getSpeed().getMaximum() + "\n";
		s += "Wind Speed Average: " + this.wind.getSpeed().getAverage() + "\n";
		s += "Wind Speed Minimum: " + this.wind.getSpeed().getMinimum() + "\n\n";
		s += "Wind Directions \n";
		for (int i = 0; i < wind.getDirections().size(); i++) {
			s += "Point: " + wind.getDirections().get(i).getPoint();
			s += " | Degrees: " + wind.getDirections().get(i).getDegrees();
			s += " | Up: " + wind.getDirections().get(i).getUp();
			s += " | Right: " + wind.getDirections().get(i).getRight() + "\n" ;
		}
		return s;
	}
	
	public static String celsiusConverter(double tempF) {
		double celsius = ((tempF - 32) * 0.55);
		return Double.toString(celsius).substring(0,5);
	}

	public int getSol() {
		return sol;
	}

	public String getSeason() {
		return season;
	}

	public Measurement getMeasurement() {
		return measurement;
	}

	public Air getAir() {
		return air;
	}

	public Wind getWind() {
		return wind;
	}

	public void setSol(int sol) {
		this.sol = sol;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public void setMeasurement(Measurement measurement) {
		this.measurement = measurement;
	}

	public void setAir(Air air) {
		this.air = air;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

}
