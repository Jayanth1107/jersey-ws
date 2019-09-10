package com.jayan.jerseyws.repository;

import java.util.List;

import com.jayan.jerseyws.model.Activity;

public interface ActivityRepository {

	List<Activity> findAllActivities();

	Activity findActivity(int activityId);

	void create(Activity activity);

}