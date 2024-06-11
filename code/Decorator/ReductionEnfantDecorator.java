package Decorator;

import menufact.plats.PlatEnfant;

public class ReductionEnfantDecorator {
    PlatEnfant platEnfant;

    public ReductionEnfantDecorator(PlatEnfant platEnfant, double pourcentage ) {
        this.platEnfant = platEnfant;
        double prixReduit = platEnfant.getPrix()-(platEnfant.getPrix()*pourcentage/100);
        platEnfant.setPrix(prixReduit);
    }

}
