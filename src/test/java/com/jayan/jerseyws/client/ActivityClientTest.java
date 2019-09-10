package com.jayan.jerseyws.client;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.jayan.jerseyws.model.Activity;

public class ActivityClientTest {
	
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
