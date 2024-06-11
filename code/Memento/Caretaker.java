package Memento;

import menufact.facture.Facture;

import java.util.Stack;

public class Caretaker {
    private final Stack<FactureMemento> factureHistory = new Stack<>();

    public void saveState(Facture facture) {
        factureHistory.push(facture.saveToMemento());
    }

    public void restoreState(Facture facture) {
        if (!factureHistory.isEmpty()) {
            FactureMemento memento = factureHistory.pop();
            facture.restoreFromMemento(memento);
        }
    }

}
