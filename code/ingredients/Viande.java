package ingredients;

public class Viande extends Ingredient{
    public Viande(String nom, String description) {
        super(nom, description);
        setTypeIngredient(TypeIngredient.VIANDE);
    }
}
