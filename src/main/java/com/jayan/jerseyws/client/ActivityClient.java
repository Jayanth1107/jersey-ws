package com.jayan.jerseyws.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.jayan.jerseyws.model.Activity;

public class ActivityClient {
	private Client client;
	
	public ActivityClient(){
		client = ClientBuilder.newClient();
	}
	
	public Activity getActivity(String activityId) {
		WebTarget target = client.target("http://localhost:8080/jersey-ws/webapi/");
		//Activity response = target.path("activities/"+activityId).request(MediaType.APPLICATION_JSON).get(Activity.class);
		Response response = target.path("activities/"+activityId).request(MediaType.APPLICATION_JSON).get(Response.class);
		//String response = target.path("activities/"+activityId).request().get(String.class);
		//String response = target.path("activities/"+activityId).request(MediaType.APPLICATION_JSON).get(String.class);
		//return response;
		if(response.getStatus()!=200) {
			throw new RuntimeException(response.getStatus()+": there was an error on the server.");
		}
		return response.readEntity(Activity.class);
	}
	
	public List<Activity> getActivities() {
		WebTarget target = client.target("http://localhost:8080/jersey-ws/webapi/");
		//Activity response = target.path("activities").request(MediaType.APPLICATION_JSON).get(Activity.class);
		List<Activity> response = target.path("activities").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Activity>>() {});
		//String response = target.path("activities/"+activityId).request().get(String.class);
		//String response = target.path("activities/"+activityId).request(MediaType.APPLICATION_JSON).get(String.class);
		//return response;
		return response;
	}

	public Activity create(Activity activity) {
		WebTarget target = client.target("http://localhost:8080/jersey-ws/webapi/");
		
		Response response = target.path("/activities/activity").request(MediaType.APPLICATION_JSON).post(Entity.entity(activity, MediaType.APPLICATION_JSON));
		
		if(response.getStatus()!=200) {
			throw new RuntimeException(response.getStatus()+": there was an error on the server.");
		}
		return response.readEntity(Activity.class);
	}
	

}
