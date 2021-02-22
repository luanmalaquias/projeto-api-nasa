package com.Nasa.ProjetoNasa.model.nasalibrary;

import java.util.List;

public class Item {
	
	/***/
	private List<Datum> data;
	private List<Link> links;
	private String href;
	
	/***/
	public List<Datum> getData() {
		return data;
	}
	public List<Link> getLinks() {
		return links;
	}
	public String getHref() {
		return href;
	}
	public void setData(List<Datum> data) {
		this.data = data;
	}
	public void setLinks(List<Link> links) {
		this.links = links;
	}
	public void setHref(String href) {
		this.href = href;
	}
	
}
