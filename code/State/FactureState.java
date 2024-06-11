package State;

import menufact.facture.Facture;

public abstract class FactureState {
    Facture facture;

    FactureState(Facture facture){
        this.facture = facture;
    }

    public abstract void ouvrir();
    public abstract void payer();
    public abstract void fermer();
}
