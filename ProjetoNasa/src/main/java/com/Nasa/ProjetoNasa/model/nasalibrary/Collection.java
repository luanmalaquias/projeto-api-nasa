package com.Nasa.ProjetoNasa.model.nasalibrary;

import java.util.List;

public class Collection {

	/***/
	private Metadata metadata;
	private String version;
	private List<Item> items;
	private String href;
	private List<Link> links;
	
	/***/
	public Metadata getMetadata() {
		return metadata;
	}
	public String getVersion() {
		return version;
	}
	public List<Item> getItems() {
		return items;
	}
	public String getHref() {
		return href;
	}
	public List<Link> getLinks() {
		return links;
	}
	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
}
