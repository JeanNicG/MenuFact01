package menufact.plats;

import Observer.ObservateurPlat;

public class PlatChoisi {
    private PlatAuMenu plat;
    private int quantite;
    public ObservateurPlat observateur;

    public PlatChoisi(PlatAuMenu plat, int quantite) {
        this.plat = plat;
        this.quantite = quantite;
        this.observateur = new ObservateurPlat();
    }

    @Override
    public String toString() {
        return "menufact.plats.PlatChoisi{" +
                "quantite=" + quantite +
                ", plat=" + plat +
                '}';
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
        observateur.notifierObservateur(this);
    }

    public PlatAuMenu getPlat() {
        return plat;
    }

}
