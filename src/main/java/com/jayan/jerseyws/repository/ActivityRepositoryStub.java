package com.jayan.jerseyws.repository;

import java.util.ArrayList;
import java.util.List;

import com.jayan.jerseyws.model.Activity;
import com.jayan.jerseyws.model.ActivitySearch;
import com.jayan.jerseyws.model.User;

public class ActivityRepositoryStub implements ActivityRepository {
	@Override
	public List<Activity> findAllActivities() {
		List<Activity> activitiesList = new ArrayList<Activity>();
		Activity activity1 = new Activity();
		activity1.setDescription("Swimming");
		activity1.setDuration(55);

		activitiesList.add(activity1);

		Activity activity2 = new Activity();
		activity2.setDescription("Cycling");
		activity2.setDuration(30);

		activitiesList.add(activity2);

		return activitiesList;
	}

	@Override
	public Activity findActivity(int activityId) {
		if (activityId == 7777) {
			return null;
		}
		Activity activity1 = new Activity();
		activity1.setId("123456");
		activity1.setDescription("Swimming");
		activity1.setDuration(100);

		User user = new User();
		user.setId("1234");
		user.setName("Jayanth");

		activity1.setUser(user);

		return activity1;
	}

	@Override
	public void create(Activity activity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Activity update(Activity activity) {
		return activity;
	}

	@Override
	public void deleteActivity(int id) {
		System.out.println("Deleting activity with ID: " + id);
	}

	@Override
	public List<Activity> findByDescriptions(List<String> descriptions) {
		List<Activity> activities = new ArrayList<Activity>();
		Activity activity = new Activity();
		activity.setId("1234");
		activity.setDescription("Running");
		activity.setDuration(150);

		activities.add(activity);

		return activities;
	}

	@Override
	public List<Activity> findByContraints(ActivitySearch activitySearch) {

		System.out.println(activitySearch.getDescriptions() + ", " + activitySearch.getDurationFrom() + ", "
				+ activitySearch.getDurationTo());

		List<Activity> activities = new ArrayList<Activity>();

		Activity activity = new Activity();
		activity.setDescription("running");
		activity.setDuration(150);
		activity.setId("321");

		activities.add(activity);

		return activities;

	}

}
