package com.Nasa.ProjetoNasa.model.marsroverphotos;

public class Photos {

	private int id;
	private int sol;
	private Camera camera;
	private String img_src;
	private String earth_date;
	public Rover rover;

	public int getId() {
		return id;
	}

	public int getSol() {
		return sol;
	}

	public Camera getCamera() {
		return camera;
	}

	public String getImg_src() {
		return img_src;
	}

	public String getEarth_date() {
		return earth_date;
	}

	public Rover getRover() {
		return rover;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSol(int sol) {
		this.sol = sol;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}

	public void setImg_src(String img_src) {
		this.img_src = img_src;
	}

	public void setEarth_date(String earth_date) {
		this.earth_date = earth_date;
	}

	public void setRover(Rover rover) {
		this.rover = rover;
	}

}
