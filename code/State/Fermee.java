package State;

import menufact.facture.Facture;

public class Fermee extends FactureState{
    public Fermee(Facture facture) {
        super(facture);
    }

    @Override
    public void ouvrir() {
        facture.setFactureState(new Fermee(facture));
        System.out.println("Impossible d'ouvrir une facture déjà fermée");
    }

    @Override
    public void payer() {
        facture.setFactureState(new Fermee(facture));
        System.out.println("Impossible de payer une facture déjà fermée");
    }

    @Override
    public void fermer() {
        facture.setFactureState(new Fermee(facture));
        System.out.println("Facture déjà fermée");
    }
}
