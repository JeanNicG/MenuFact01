package State;

import menufact.facture.Facture;

public class Payee extends FactureState {
    public Payee(Facture facture) {
        super(facture);
    }

    @Override
    public void payer(){
        facture.setFactureState(new Payee(facture));
        System.out.println("Payee");
    }

    @Override
    public void ouvrir(){
        facture.setFactureState(new Payee(facture));
        System.out.println("Impossible d'ouvrir une facture payee");
    }

    @Override
    public void fermer(){
        facture.setFactureState(new Fermee(facture));
        System.out.println("Fermeture en cours...");
    }
}
