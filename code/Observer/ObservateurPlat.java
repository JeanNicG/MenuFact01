package Observer;

import menufact.plats.PlatChoisi;

import java.util.ArrayList;

public class ObservateurPlat {

    private ArrayList<ObserverInterface> observateur = new ArrayList<>();

    public void ajouterObservateur(ObserverInterface o) {
        observateur.add(o);
    }

    public void retirerObservateur(ObserverInterface o) {
        observateur.remove(o);
    }

    public void notifierObservateur(PlatChoisi plat){
        for(ObserverInterface o : observateur){
            o.update(plat);
        }
    }
}
