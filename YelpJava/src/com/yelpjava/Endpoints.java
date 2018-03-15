package com.yelpjava;

 class Endpoint {
	public static class Endpoints{
		public final static String search="https://api.yelp.com/v3/businesses/search?";
		public final static String phoneSearch="https://api.yelp.com/v3/businesses/search/phone?phone=";
		public final static String business="https://api.yelp.com/v3/businesses/";
		
		public static String BusinessSearchURL(String id) {
			return business+id;
		}
		public static String BusinessReviewURL(String id) {
			return business+id+"/reviews";
		}
		public static String BusinessPhoneURL(String phone) {
			return phoneSearch+phone;
		}
	}
}
