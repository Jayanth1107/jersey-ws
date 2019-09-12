package com.jayan.jerseyws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.jayan.jerseyws.model.Activity;
import com.jayan.jerseyws.model.User;
import com.jayan.jerseyws.repository.ActivityRepository;
import com.jayan.jerseyws.repository.ActivityRepositoryStub;

@Path("activities")
public class ActivityResource {
	private ActivityRepository activityRepository = new ActivityRepositoryStub();
	
	
	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response deleteActivity(@PathParam("id") int id) {
		System.out.println("Deleting activity with ID : "+ id);
		activityRepository.deleteActivity(id);
		
		return Response.ok().build();
	}
	
	@PUT
	@Path("activity/{activtyId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response updateActivity(Activity activity) {
		System.out.println(activity.getId()+" : "+activity.getDescription()+" , "+activity.getDuration());
		activity = activityRepository.update(activity);
		
		return Response.ok().entity(activity).build();
	}
	
	@POST
	@Path("activity")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Activity createActivity(Activity activity) {
		System.out.println(activity.getDescription()+" , "+activity.getDuration());
		return activity;
	}
	
	@POST
	@Path("activity")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Activity createActivityParams(MultivaluedMap<String, String> formParams) {
		System.out.println(formParams.getFirst("description"));
		System.out.println(formParams.getFirst("duration"));
		
		Activity activity = new Activity();
		activity.setDescription(formParams.getFirst("description"));
		activity.setDuration(Integer.parseInt(formParams.getFirst("duration")));
		
		activityRepository.create(activity);
		
		return activity;
	}
	
	
	@GET
	//@Produces(MediaType.APPLICATION_XML)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Activity> getAllActivities(){ 
		return activityRepository.findAllActivities();
	}
	
	@GET
	@Path("{activityId}")
	//@Produces(MediaType.APPLICATION_XML)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getActivity(@PathParam("activityId") int activityId){
		if(activityId == 0) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		
		Activity activity = activityRepository.findActivity(activityId);
		
		if(activity==null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.ok().entity(activity).build();
	}
	
	@GET
	@Path("{activityId}/user")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public User getActivityUser(@PathParam("activityId") int activityId){
		return activityRepository.findActivity(activityId).getUser();
	}
	
	

}
