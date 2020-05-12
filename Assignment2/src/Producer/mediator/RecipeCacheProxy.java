package Producer.mediator;

import Producer.mediator.RecipeProvider;
import Producer.mediator.RecipeReader;
import model.Recipe;

import java.rmi.server.UnicastRemoteObject;

public class RecipeCacheProxy implements RecipeProvider {
    private Recipe currentRecipe;
    private RecipeReader reader;

    public RecipeCacheProxy(String filename){
        this.reader = new RecipeReader(filename);
        currentRecipe = null;
    }

    @Override
    public Recipe getRecipeById(String id) throws Exception {
        if(currentRecipe == null){
            currentRecipe=reader.getRecipeById(id);
            return currentRecipe;
        }
        else if(currentRecipe.getId().equals(id)){
            return currentRecipe;
         }
        else{
            currentRecipe=reader.getRecipeById(id);
            return currentRecipe;
        }
    }
    @Override
    public Recipe getRecipeByName(String name) throws Exception {
        if(currentRecipe == null){
            currentRecipe=reader.getRecipeByName(name);
            return currentRecipe;
        }
        else if(currentRecipe.getName().equals(name)){
            return currentRecipe;
        }
        else{
            currentRecipe=reader.getRecipeByName(name);
            return currentRecipe;
        }
    }

    @Override
    public void updateRecipe(Recipe recipe) throws Exception {
        reader.updateRecipe(recipe);
    }
}
