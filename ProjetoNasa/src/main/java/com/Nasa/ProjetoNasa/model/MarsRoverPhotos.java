package com.Nasa.ProjetoNasa.model;

import java.util.List;
import com.Nasa.ProjetoNasa.model.marsroverphotos.Photos;

public class MarsRoverPhotos {

	private List<Photos> photos;

	public List<Photos> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photos> photos) {
		this.photos = photos;
	}	
	
	public String info(int i){
		String s = "";
		s += "Photo id " + getPhotos().get(i).getId() + "\n";
		s += "Sol " + getPhotos().get(i).getSol() + " | " + "Date " + getPhotos().get(i).getEarth_date() + "\n\n"; 
		s += "Camera " + getPhotos().get(i).getCamera().getName() + " id " + getPhotos().get(i).getCamera().getId() + "\n";
		s += "(" + getPhotos().get(i).getCamera().getFull_name() + ")" + "\n";
		s += "Rover " + getPhotos().get(i).getRover().getName() + " id " + getPhotos().get(i).getRover().getId() + "\n";
		s += "Launch date " + getPhotos().get(i).getRover().getLaunch_date() + "\n";
		s += "Landing date " + getPhotos().get(i).getRover().getLanding_date() + "\n\n";
		s += "Status: " + getPhotos().get(i).getRover().getStatus();
		return s;
		
	}
	
}
