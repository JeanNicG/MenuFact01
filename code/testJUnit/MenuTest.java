package testJUnit;

import Decorator.ReductionEnfantDecorator;
import Factory.PlatEnfantCreator;
import Factory.PlatFactory;
import Factory.PlatSanteCreator;
import MVC.PlatController;
import MVC.PlatView;
import Memento.Caretaker;
import State.Fermee;
import State.Ouverte;
import State.Payee;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import menufact.plats.PlatEnfant;
import menufact.plats.PlatSante;
import org.junit.jupiter.api.Test;
import menufact.facture.Facture;

import menufact.Menu;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class MenuTest {
    @Test
    public void testSingletonInstance() {
        Menu menu1 = Menu.getInstance("Menu 1");
        Menu menu2 = Menu.getInstance("Menu 2");

        // Vérifie que les deux références pointent vers la même instance
        assertSame(menu1, menu2, "Les instances ne sont pas identiques");
    }

    @Test
    public void testFactoryPlatEnfant() {
        PlatFactory factory = new PlatEnfantCreator();
        PlatAuMenu plat = factory.createPlat(1, "Plat Enfant", 10.0, 0.5);

        assertTrue(plat instanceof PlatEnfant);
        PlatEnfant platEnfant = (PlatEnfant) plat;
        assertEquals(1, platEnfant.getCode());
        assertEquals("Plat Enfant", platEnfant.getDescription());
        assertEquals(10.0, platEnfant.getPrix(), 0.001);
        assertEquals(0.5, platEnfant.getProportion(), 0.001);

    }

    @Test
    public void testFactoryPlatSante() {
        PlatFactory factory = new PlatSanteCreator();
        PlatAuMenu plat = factory.createPlat(2, "Plat Sante", 15.0, 500.0, 20.0, 5.0);

        assertTrue(plat instanceof PlatSante);
        PlatSante platSante = (PlatSante) plat;
        assertEquals(2, platSante.getCode());
        assertEquals("Plat Sante", platSante.getDescription());
        assertEquals(15.0, platSante.getPrix(), 0.001);
        assertEquals(500.0, platSante.getKcal(), 0.001);
        assertEquals(20.0, platSante.getChol(), 0.001);
        assertEquals(5.0, platSante.getGras(), 0.001);
    }

    @Test
    public void testObserver(){
        PlatFactory factory = new PlatEnfantCreator();
        PlatAuMenu plat = factory.createPlat(1, "Plat Enfant", 10.0, 0.5);
        PlatChoisi platChoisi = new PlatChoisi(plat, 8);
        platChoisi.observateur.ajouterObservateur(new Facture("test"));

        platChoisi.setQuantite(5);
    }

    @Test
    public void testState() throws FactureException {
        Facture facture = new Facture("test");
        facture.ouvrir();
        assertTrue(facture.getFactureState() instanceof Ouverte);
        facture.fermer();
        assertTrue(facture.getFactureState() instanceof Ouverte);
        facture.payer();
        assertTrue(facture.getFactureState() instanceof Payee);
        facture.fermer();
        assertTrue(facture.getFactureState() instanceof Fermee);
    }

    @Test
    public void testMVC() throws FactureException {
        Facture factureModel = new Facture("test");
        PlatView platView = new PlatView();
        PlatController platController = new PlatController(factureModel,platView);

        PlatFactory factory = new PlatSanteCreator();
        PlatAuMenu plat1 = factory.createPlat(2, "Plat Sante", 15.0, 500.0, 20.0, 5.0);
        PlatChoisi platChoisi1 = new PlatChoisi(plat1, 8);

        platController.updateView();

        platController.ajouterPlat(platChoisi1);

        platController.updateView();

    }

    @Test
    public void testDecorator(){
        PlatFactory factory = new PlatEnfantCreator();
        PlatAuMenu plat = factory.createPlat(1, "Plat Enfant", 10.0, 0.5);
        PlatEnfant platEnfant = (PlatEnfant) plat;
        ReductionEnfantDecorator reduction1 = new ReductionEnfantDecorator(platEnfant,50);
        assertEquals(5,platEnfant.getPrix());
    }

    @Test
    public void testMemento() throws FactureException {
        Facture facture = new Facture("test");
        Caretaker caretaker = new Caretaker();

        facture.ouvrir();
        assertTrue(facture.getFactureState() instanceof Ouverte);
        facture.fermer();
        caretaker.saveState(facture);
        assertTrue(facture.getFactureState() instanceof Ouverte);
        facture.payer();
        caretaker.saveState(facture);
        assertTrue(facture.getFactureState() instanceof Payee);
        facture.fermer();
        assertTrue(facture.getFactureState() instanceof Fermee);

        //Retour en arriere pour les etats de la facture
        caretaker.restoreState(facture);
        assertTrue(facture.getFactureState() instanceof Payee);
        caretaker.restoreState(facture);
        assertTrue(facture.getFactureState() instanceof Ouverte);
    }

}

