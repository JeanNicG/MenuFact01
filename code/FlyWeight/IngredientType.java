package FlyWeight;

import ingredients.TypeIngredient;

public class IngredientType {
    private String nom;
    private TypeIngredient typeIngredient;

    public IngredientType(String nom, TypeIngredient typeIngredient) {
        this.nom = nom;
        this.typeIngredient = typeIngredient;
    }
}
