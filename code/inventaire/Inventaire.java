package inventaire;

import FlyWeight.IngredientFactory;
import FlyWeight.IngredientType;
import ingredients.Ingredient;
import ingredients.TypeIngredient;

import java.util.ArrayList;
import java.util.List;

public class Inventaire {
    private List<Ingredient> ingredients = new ArrayList<>();

    public Ingredient addIngredient(String nom, String description, TypeIngredient typeIngredient) {
        IngredientType ingredientType = IngredientFactory.getIngredient(nom,typeIngredient);
        Ingredient ingredient = new Ingredient(nom, description);
        ingredients.add(ingredient);
        return ingredient;
    }
}
