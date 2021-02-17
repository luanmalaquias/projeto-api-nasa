package com.Nasa.ProjetoNasa.apiRest;

import javax.swing.JOptionPane;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.Nasa.ProjetoNasa.model.Apod;
import com.Nasa.ProjetoNasa.model.InSight;
import com.Nasa.ProjetoNasa.model.MarsRoverPhotos;

public class Request {

	public static Apod requestApod(String date, boolean aleatorio) {

		try {
			RestTemplate template = new RestTemplate();

			String url = "https://api.nasa.gov/planetary/apod?thumbs=true&";
			String apiKey = "api_key=DEMO_KEY"; // api_key=DEMO_KEY // api_key=aVC9tfaVGOoIdZckt8DnErFYCMEdQHa3OzJtsDkQ
			if (date != null) {
				url += "date=" + date + "&";
			} else if (aleatorio) {
				url += "count=1&" + apiKey;
				ResponseEntity<Apod[]> forEntity = template.getForEntity(url, Apod[].class);
				return forEntity.getBody()[0];
			}
			url += apiKey;

			ResponseEntity<Apod> forEntity = template.getForEntity(url, Apod.class);
			return forEntity.getBody();
		} catch (Exception e) {
			erroMessage();
		}

		return null;

	}

	public static InSight requestInSight(String sol) {
		try {
			String url = "https://api.mars.spacexcompanion.app/v1/sols/" + sol;
			RestTemplate template = new RestTemplate();
			ResponseEntity<InSight> entidade = template.getForEntity(url, InSight.class);
			return entidade.getBody();
		} catch (Exception e) {
			erroMessage();
		}

		return null;

	}

	public static MarsRoverPhotos requestMRP(String rover, String sol) {
		try {
			String url = "https://api.nasa.gov/mars-photos/api/v1/rovers/" + rover + "/photos?sol=" + sol;
			String apiKey = "&api_key=DEMO_KEY";
			url += apiKey;
			RestTemplate template = new RestTemplate();
			ResponseEntity<MarsRoverPhotos> entidade = template.getForEntity(url, MarsRoverPhotos.class);
			return entidade.getBody();
		} catch (Exception e) {
			erroMessage();
		}
		return null;

	}

	public static void erroMessage() {
		JOptionPane.showMessageDialog(null, "Limite de requisiçoes excedidas", "Error 429",
				JOptionPane.WARNING_MESSAGE);
	}

	// REQUEST SIMPLES ->
	/*
	 * String url = "https://api.mars.spacexcompanion.app/v1/sols/708"; RestTemplate
	 * template = new RestTemplate(); ResponseEntity<InSight> entidade =
	 * template.getForEntity(url, InSight.class);
	 * System.out.println(entidade.getBody().measurement.last);
	 */

	// REQUEST COMPLETO ->
	/*
	 * UriComponents uri = UriComponentsBuilder.newInstance() .scheme("https")
	 * .host("swapi.dev") .path("api/people/1/") .queryParam("fields", "all")
	 * .build();
	 */

}
