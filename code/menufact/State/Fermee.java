package menufact.State;

import menufact.facture.Facture;

public class Fermee extends FactureState{
    public Fermee(Facture facture) {
        super(facture);
    }

    @Override
    public void ouvrir() {
        System.out.println("Facture déjà fermée");
    }

    @Override
    public void payer() {
        System.out.println("Impossible de payer une facture déjà fermée");
    }

    @Override
    public void fermer() {
        System.out.println("Facture déjà fermée");
    }
}
