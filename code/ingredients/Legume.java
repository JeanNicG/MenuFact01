package ingredients;

public class Legume extends Ingredient{
    public Legume(String nom, String description) {
        super(nom, description);
        setTypeIngredient(TypeIngredient.LEGUME);
    }
}
