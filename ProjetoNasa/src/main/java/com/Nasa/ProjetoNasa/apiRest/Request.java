package com.Nasa.ProjetoNasa.apiRest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.Nasa.ProjetoNasa.model.Apod;

public class Request {

	public static Apod requestApod(String date, boolean aleatorio) {
		
		RestTemplate template = new RestTemplate();
		
		String url = "https://api.nasa.gov/planetary/apod?thumbs=true&";
		String apiKey = "api_key=DEMO_KEY"; // api_key=DEMO_KEY // api_key=aVC9tfaVGOoIdZckt8DnErFYCMEdQHa3OzJtsDkQ
		if(date != null) {
			url += "date=" + date + "&";
		}else if(aleatorio) {
			url += "count=1&" + apiKey;
			ResponseEntity<Apod[]> forEntity = template.getForEntity(url, Apod[].class);
			return forEntity.getBody()[0];
		}
		url += apiKey;
				
		ResponseEntity<Apod> forEntity = template.getForEntity(url, Apod.class);
		return forEntity.getBody();
		
	}
	
}
