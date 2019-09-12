package com.jayan.jerseyws.repository;

import java.util.List;

import com.jayan.jerseyws.model.Activity;
import com.jayan.jerseyws.model.ActivitySearch;

public interface ActivityRepository {

	List<Activity> findAllActivities();

	Activity findActivity(int activityId);

	void create(Activity activity);

	Activity update(Activity activity);

	void deleteActivity(int id);

	List<Activity> findByDescriptions(List<String> descriptions);

	List<Activity> findByContraints(ActivitySearch activitySearch);

}