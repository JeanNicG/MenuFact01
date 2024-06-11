package ingredients;

import FlyWeight.IngredientFactory;
import FlyWeight.IngredientType;
import ingredients.exceptions.IngredientException;

import java.util.ArrayList;
import java.util.List;

public class IngredientInventaire {
    private IngredientInventaire ingredientInventaire;
    private int quantite;

    public IngredientInventaire(IngredientInventaire ingredientInventaire, int quantite) {
        this.ingredientInventaire = ingredientInventaire;
        this.quantite = quantite;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) throws IngredientException{

        if (quantite < 0)
            throw new IngredientException("Il n'est pas possible d'avoir une quantité negative");
        else
            this.quantite = quantite;
    }

}
