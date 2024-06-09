package menufact.State;

import menufact.facture.Facture;

public class Ouverte extends FactureState{
    public Ouverte(Facture facture) {
        super(facture);
    }

    @Override
    public void ouvrir() {
        System.out.println("Facture ouverte");
    }

    @Override
    public void payer() {
        System.out.println("Paiement en cours...");
    }

    @Override
    public void fermer() {
        System.out.println("Il faut attendre avant de fermer la facture");
    }
}
