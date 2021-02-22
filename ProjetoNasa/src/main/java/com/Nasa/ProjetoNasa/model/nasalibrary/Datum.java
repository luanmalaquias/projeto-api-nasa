package com.Nasa.ProjetoNasa.model.nasalibrary;

import java.util.List;

public class Datum {
	
	/***/
	private String date_created;
	private String center;
	private String secondary_creator;
	private String title;
	private String media_type;
	private String nasa_id;
	private List<String> keywords;
	private String description_508;
	private String description;
	
	/***/
	public String getDate_created() {
		return date_created;
	}
	public String getCenter() {
		return center;
	}
	public String getSecondary_creator() {
		return secondary_creator;
	}
	public String getTitle() {
		return title;
	}
	public String getMedia_type() {
		return media_type;
	}
	public String getNasa_id() {
		return nasa_id;
	}
	public List<String> getKeywords() {
		return keywords;
	}
	public String getDescription_508() {
		return description_508;
	}
	public String getDescription() {
		return description;
	}
	public void setDate_created(String date_created) {
		this.date_created = date_created;
	}
	public void setCenter(String center) {
		this.center = center;
	}
	public void setSecondary_creator(String secondary_creator) {
		this.secondary_creator = secondary_creator;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setMedia_type(String media_type) {
		this.media_type = media_type;
	}
	public void setNasa_id(String nasa_id) {
		this.nasa_id = nasa_id;
	}
	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}
	public void setDescription_508(String description_508) {
		this.description_508 = description_508;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
