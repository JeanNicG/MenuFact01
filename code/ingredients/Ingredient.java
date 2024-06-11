package ingredients;

import FlyWeight.IngredientType;

public class Ingredient {
    private String nom;
    private String description;
    private TypeIngredient typeIngredient;
    private IngredientType ingredientType;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypeIngredient getTypeIngredient() {
        return typeIngredient;
    }

    public void setTypeIngredient(TypeIngredient typeIngredient) {
        this.typeIngredient = typeIngredient;
    }

    public Ingredient(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }
}
