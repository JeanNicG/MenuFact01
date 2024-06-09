package menufact.State;

import menufact.State.FactureState;
import menufact.facture.Facture;

public class Payee extends FactureState {
    public Payee(Facture facture) {
        super(facture);
    }

    @Override
    public void payer(){
        System.out.println("Payee");
    }

    @Override
    public void ouvrir(){
        System.out.println("Facture deja ouverte");
    }

    @Override
    public void fermer(){
        System.out.println("Facture ne peut pas etre fermee");
    }
}
