package se.lerinn.cerberus.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import se.lerinn.cerberus.model.Recipe;
import se.lerinn.cerberus.model.RecipeDto;
import se.lerinn.cerberus.service.RecipeService;

@Component
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("recipes")
public class RecipeResource {

	@Context
	private UriInfo uriInfo;
	
	@Autowired
	private RecipeService recipeService;

	@GET
	@Path("{id}")
	public Response get(@PathParam("id") Long id) {
		Recipe recipe = recipeService.get(id);
		return Response.ok(recipe).build();
	}
	
	@GET
	public Response getAll() {
		List<Recipe> recipes = recipeService.getAll();
		return Response.ok(recipes).build();
	}
	
	@POST
	public Response create(RecipeDto recipeDto) throws URISyntaxException {
		Recipe recipe = recipeService.save(recipeDto);
		URI location = new URI(uriInfo.getAbsolutePath().toString() + "/" + recipe.getId());
		return Response.created(location).build();
	}
	
	@PUT
	@Path("{id}")
	public Response update(@PathParam("id") Long id, RecipeDto recipeDto) {
		Recipe recipe = recipeService.update(id, recipeDto);
		return Response.ok(recipe).build();
	}
	
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") Long id) {
		Recipe recipe = recipeService.delete(id);
		return Response.ok(recipe).build();
	}
	
}
