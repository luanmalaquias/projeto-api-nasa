package com.Nasa.ProjetoNasa.model;

public class HistoryEvents {
	
	public class Links{
		private String article;

		public String getArticle() {
			return article;
		}
		public void setArticle(String article) {
			this.article = article;
		}
	}

    private String title;
    private String event_date_utc;
    private String details;
    private String id;
    private Links links;
    
	public String getTitle() {
		return title;
	}
	public String getEvent_date_utc() {
		return event_date_utc;
	}
	public String getDetails() {
		return details;
	}
	public String getId() {
		return id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setEvent_date_utc(String event_date_utc) {
		this.event_date_utc = event_date_utc;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Links getLinks() {
		return links;
	}
	public void setLinks(Links links) {
		this.links = links;
	}

}
