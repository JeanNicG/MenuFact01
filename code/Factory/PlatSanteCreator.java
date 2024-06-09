package Factory;

import menufact.plats.PlatAuMenu;
import menufact.plats.PlatSante;

public class PlatSanteCreator extends PlatFactory {
    @Override
    public PlatAuMenu createPlat(int code, String description, double prix, Object... extraParams) {
        if (extraParams.length != 3) {
            throw new IllegalArgumentException("Expected 3 extra parameters for PlatSante");
        }
        double kcal = (double) extraParams[0];
        double chol = (double) extraParams[1];
        double gras = (double) extraParams[2];
        return new PlatSante(code, description, prix, kcal, chol, gras);
    }
}
