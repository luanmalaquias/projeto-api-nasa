package com.Nasa.ProjetoNasa.model.insight;

import java.util.List;

public class Wind {

	private Speed speed;
	private List<Direction> directions;

	public Speed getSpeed() {
		return speed;
	}

	public void setSpeed(Speed speed) {
		this.speed = speed;
	}

	public List<Direction> getDirections() {
		return directions;
	}

	public void setDirections(List<Direction> directions) {
		this.directions = directions;
	}

}
