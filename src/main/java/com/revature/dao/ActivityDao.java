package com.revature.dao;

import java.util.List;

import com.revature.model.Activity;

public interface ActivityDao {

	public Activity findActivity(int activityId);
	List<Activity> GetAllActivities();
	
}
