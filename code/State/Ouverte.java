package State;

import menufact.facture.Facture;

public class Ouverte extends FactureState{
    public Ouverte(Facture facture) {
        super(facture);
    }

    @Override
    public void ouvrir() {
        facture.setFactureState(new Ouverte(facture));
        System.out.println("Facture ouverte");
    }

    @Override
    public void payer() {
        facture.setFactureState(new Payee(facture));
        System.out.println("Paiement en cours...");
    }

    @Override
    public void fermer() {
        facture.setFactureState(new Ouverte(facture));
        System.out.println("Impossible de fermer une facture ouverte mais pas payee");
    }
}
