package com.yelpjava;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yelpjava.Endpoint.Endpoints;
import com.yelpjava.YelpJava.PropertiesLoader;
import com.yelpmodel.Example;

import jdk.incubator.http.HttpClient.Version;
import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpHeaders;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

public class BusinessSearch extends YelpSearch{
	public HttpRequest request;
	private String Term;
	private String Location;
	public BusinessSearch(String term, String location) {
		Term=term;
		Location=location;
	}
	

	@Override
	public void Search() {
		HttpRequest request=super.MakeRequest(UriComponentsBuilder.fromUriString(Endpoints.search)
				   .queryParam("term", Term)
				   .queryParam("location", Location)
				   .build().toUri());
		try {
			super.SendRequest(request);
		}catch(Exception e) {
			System.out.println("Error Making Request");
		}
	}

	@Override
	public void Save() {
		// TODO Auto-generated method stub
		Example parsedJson=null;
		try {
			parsedJson = new ObjectMapper().readValue(super.savedResponse.body(), Example.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(parsedJson!=null) {
			businesses= parsedJson.getBusinesses();
			region=parsedJson.getRegion();
			count=parsedJson.getTotal();
		}
		
	}

	

}
