package FlyWeight;

import ingredients.TypeIngredient;

import java.util.HashMap;
import java.util.Map;

public class IngredientFactory {
    static Map<String, IngredientType> ingredientType = new HashMap<String, IngredientType>();

    public static IngredientType getIngredient(String nom,TypeIngredient typeIngredient) {
        IngredientType result = ingredientType.get(nom);
        if (result == null) {
            result = new IngredientType(nom, typeIngredient);
            ingredientType.put(nom, result);
        }
        return result;
    }
}
