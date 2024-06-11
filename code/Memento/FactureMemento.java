package Memento;

import State.FactureState;

public class FactureMemento {
    private final FactureState factureState;

    public FactureMemento(FactureState factureState) {
        this.factureState = factureState;
    }

    public FactureState getEtat(){
        return factureState;
    }
}
