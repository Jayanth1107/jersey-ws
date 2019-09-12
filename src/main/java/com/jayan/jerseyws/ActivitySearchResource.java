package com.jayan.jerseyws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.jayan.jerseyws.model.Activity;
import com.jayan.jerseyws.model.ActivitySearch;
import com.jayan.jerseyws.repository.ActivityRepository;
import com.jayan.jerseyws.repository.ActivityRepositoryStub;

@Path("search/activities")
public class ActivitySearchResource {
	ActivityRepository activityRepository = new ActivityRepositoryStub();

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response searchForActivities(@QueryParam(value = "description") List<String> descriptions) {
		System.out.println(descriptions);

		List<Activity> activities = activityRepository.findByDescriptions(descriptions);

		System.out.println("List: " + activities);

		if (activities == null || activities.size() <= 0) {

			return Response.status(Status.NOT_FOUND).build();
		}

		return Response.ok().entity(new GenericEntity<List<Activity>>(activities) {
		}).build();

	}

	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_ATOM_XML })
	public Response searchForActivities(ActivitySearch activitySearch) {
		System.out.println(activitySearch.getDescriptions() + ", " + activitySearch.getDurationFrom() + ", "
				+ activitySearch.getDurationTo());

		List<Activity> activities = activityRepository.findByContraints(activitySearch);

		if (activities == null || activities.size() <= 0) {

			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.ok().entity(new GenericEntity<List<Activity>>(activities) {
		}).build();

	}

}
