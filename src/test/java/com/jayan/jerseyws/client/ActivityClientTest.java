package com.jayan.jerseyws.client;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.jayan.jerseyws.model.Activity;
import com.jayan.jerseyws.model.ActivitySearch;

public class ActivityClientTest {
	
	@Test
	public void testSearchObject() {
		ActivitySearchClient client = new ActivitySearchClient();
		
		List<String> searchValues = new ArrayList<String>();
		searchValues.add("Biking");
		searchValues.add("Running");
		
		ActivitySearch search = new ActivitySearch();
		search.setDescriptions(searchValues);
		search.setDurationFrom(30);
		search.setDurationTo(200);
		
		List<Activity> activities = client.search(search);
		
		System.out.println(activities);
		
		assertNotNull(activities);
	}
	
	@Test
	public void testSearch() {
		ActivitySearchClient client = new ActivitySearchClient();
		
		String param = "description";
		List<String> searchValues = new ArrayList<String>();
		
		searchValues.add("Swimming");
		searchValues.add("Running");
		
		List<Activity> activities = client.search(param, searchValues);
		
		System.out.println(activities);
		
		assertNotNull(activities);
	}
	
	@Test
	public void testDelete() {		
		ActivityClient client = new ActivityClient();
		client.delete(1234);
	}
	
	@Test
	public void testPut() {
		Activity activity = new Activity();
		activity.setId("1223");
		activity.setDescription("Gym");
		activity.setDuration(100);
		
		ActivityClient client = new ActivityClient();
		activity = client.update(activity);
		
		assertNotNull(activity);
		
	}
	
	@Test
	public void testCreate() {
		ActivityClient client = new ActivityClient();
		Activity actvity = new Activity();
		actvity.setDescription("Swimming");
		actvity.setDuration(200);
		
		actvity = client.create(actvity);
		
		assertNotNull(actvity);
	}

	@Test
	public void testGetActivity() {
		ActivityClient client = new ActivityClient();
		
		Activity activity = client.getActivity("1234");
		System.out.println(activity);
		assertNotNull(activity);
		
		//fail("Not yet implemented");
	}
	
	@Test
	public void testGetActivities() {
		ActivityClient client = new ActivityClient();
		List<Activity> activities = client.getActivities();
		System.out.println(activities);
		assertNotNull(activities);
		
		//fail("Not yet implemented");
	}
	
	@Test(expected = RuntimeException.class)
	public void testGetWithBadRequest() {
		ActivityClient client = new ActivityClient();
		
		client.getActivity(null);
		
	}
	
	@Test(expected = RuntimeException.class)
	public void testGetWith404BadRequest() {
		ActivityClient client = new ActivityClient();
		
		client.getActivity("7777");
		
	}

}
