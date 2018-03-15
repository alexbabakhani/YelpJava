package com.yelpjava;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yelpmodel.Example;

import jdk.incubator.http.HttpClient;

import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;
public class YelpJava {
	/***
	 * 
	 * @author Alex Babakhani
	 * Properties 
	 */

	public static class PropertiesLoader{
		private static String privateKey;
		public static ArrayList<String> readCategories;
		public static ArrayList<String> readZips;
		private static Properties appproperties;
		
		static {
			Properties properties=new Properties();
			File propfile=new File("config.properties");
			FileInputStream fileInput;
			try {

				fileInput=new FileInputStream(propfile);
				properties.load(fileInput);
				fileInput.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			appproperties=properties;
			privateKey=properties.getProperty("apikey");
		}
		public static String getPrivateKey() {
			return privateKey;
		}
	
	//public static void ReadCategories() {
		static {
		File catsfile=new File("terms.txt");
		FileReader fileReader;
		ArrayList<String> categories=new ArrayList<String>();
		try {

			fileReader=new FileReader(catsfile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			
			while ((line = bufferedReader.readLine()) != null) {
				categories.add(line);
				
			}
			fileReader.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		readCategories=categories;
	}
	//public static void ReadZips() {
		static {
		File zipsfile=new File("nyczips.txt");
		FileReader fileReader;
		ArrayList<String> zips=new ArrayList<String>();
		try {

			fileReader=new FileReader(zipsfile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			
			while ((line = bufferedReader.readLine()) != null) {
				zips.add(line);
				
			}
			fileReader.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		readZips=zips;
	}
	}
	public static void main(String[] args) {
		/*
		// TODO Auto-generated method stub
		System.out.println();
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request=null;
		try {
			request=HttpRequest.newBuilder()
					.uri(new URI("https://api.yelp.com/v3/businesses/search?"))
					.GET()
					.headers("Authorization", "Bearer "+PropertiesLoader.getPrivateKey(),"term","restaurant","location","11365")
					.build();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(request.headers().firstValue("Authorization"));
		HttpResponse<String> response=null;
		try {
			response = client.send(request, HttpResponse.BodyHandler.asString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(response.statusCode());
		System.out.println(response.body());
		*/
		ArrayList<String> p=PropertiesLoader.readCategories;
		BusinessSearch s=new BusinessSearch("restaurant","11365");
		s.Search();
		
		BusinessSearch s1=new BusinessSearch("restaurant","11365");
		s1.Search();
		
		BusinessSearch s2=new BusinessSearch("restaurant","11365");
		s2.Search();
		
		BusinessSearch s3=new BusinessSearch("restaurant","11365");
		s3.Search();
	
		BusinessSearch s4=new BusinessSearch("restaurant","11365");
		s4.Search();
		
		BusinessSearch s5=new BusinessSearch("restaurant","11365");
		s5.Search();
	
		BusinessSearch s6=new BusinessSearch("restaurant","11365");
		s6.Search();
	
		//s.Save();s1.Save();s2.Save();	s3.Save();s4.Save();	s5.Save();	s6.Save();
		
		/*HttpResponse<String> response=s.response;
		
		try {
			//Example itemWithOwner = new ObjectMapper().readValue(response.body(), Example.class);
			//System.out.println(itemWithOwner.getTotal());
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
		System.out.println(response.statusCode());
		System.out.println(response.body());
		 
		 */
	}
	
}