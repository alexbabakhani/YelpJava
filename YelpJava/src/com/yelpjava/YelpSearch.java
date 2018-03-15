package com.yelpjava;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yelpjava.YelpJava.PropertiesLoader;
import com.yelpmodel.Business;
import com.yelpmodel.Example;
import com.yelpmodel.Region;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

public abstract class YelpSearch{
	public List<Business> businesses;
	public int count;
	public String searchTerm;
	public Region region;
	public URI searchUri;
	public HttpResponse<String> savedResponse;
	CompletableFuture<Void> saved;
	public HttpRequest MakeRequest(URI uri) {
		searchUri=uri;
		HttpRequest request=null;
		try {
			request=HttpRequest.newBuilder()
					.uri(uri)
					.GET()
					.headers("Authorization", "Bearer "+PropertiesLoader.getPrivateKey())
					.build();						
		}catch(Exception e) {
			System.out.println("Error Making Request");
		}
		return request;
	}
	public HttpResponse<String> SendRequest(HttpRequest request) {
		HttpClient client = HttpClient.newHttpClient();
		HttpResponse<String> response=null;
		try {
			//response = client.send(request, HttpResponse.BodyHandler.asString());
			saved=client.sendAsync(request, HttpResponse.BodyHandler.asString()).thenAccept(result->{this.savedResponse=result;Save();});
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return response;
	}
	public abstract void Search();
	public abstract void Save();
	
}
