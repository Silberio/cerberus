package se.lerinn.cerberus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.lerinn.cerberus.model.Recipe;
import se.lerinn.cerberus.model.RecipeDto;
import se.lerinn.cerberus.repository.RecipeRepository;

@Service
public class RecipeService {

	@Autowired
	private RecipeRepository recipeRepository;
	
	public Recipe get(Long id) {
		return recipeRepository.findOne(id);
	}
	
	public List<Recipe> getAll() {
		return recipeRepository.findAll();
	}
	
	public Recipe save(RecipeDto recipeDto) {
		Recipe recipe = new Recipe();
		recipe.setTitle(recipeDto.getTitle());
		recipe.setIngredients(recipeDto.getIngredients());
		recipe.setInstruction(recipeDto.getInstruction());
		
		return recipeRepository.save(recipe);
	}
	
	public Recipe update(Long id, RecipeDto recipeDto) {
		Recipe recipe = recipeRepository.findOne(id);
		recipe.setTitle(recipeDto.getTitle());
		recipe.setIngredients(recipeDto.getIngredients());
		recipe.setInstruction(recipeDto.getInstruction());
		
		return recipeRepository.save(recipe);
	}
	
	public Recipe delete(Long id) {
		Recipe recipe = recipeRepository.findOne(id);
		recipeRepository.delete(recipe);
		return recipe;
	}
	
}
