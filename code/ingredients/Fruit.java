package ingredients;

public class Fruit extends Ingredient{
    public Fruit(String nom, String description) {
        super(nom, description);
        setTypeIngredient(TypeIngredient.FRUIT);
    }
}
