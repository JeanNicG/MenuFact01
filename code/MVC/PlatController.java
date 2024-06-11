package MVC;

import menufact.facture.Facture;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;

public class PlatController {
    private Facture factureModel;
    private PlatView platView;

    public PlatController(Facture factureModel, PlatView platView) {
        this.factureModel = factureModel;
        this.platView = platView;
    }

    public void ajouterPlat(PlatChoisi platChoisi) throws FactureException {
        factureModel.ajoutePlat(platChoisi);
    }

    public void updateView() {
        platView.afficherFacture(factureModel);
    }
}
