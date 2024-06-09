package Factory;

import menufact.plats.PlatAuMenu;
import menufact.plats.PlatEnfant;
import menufact.plats.PlatSante;

public class PlatEnfantCreator extends PlatFactory{
    @Override
    public PlatAuMenu createPlat(int code, String description, double prix, Object... extraParams) {
        if (extraParams.length != 1) {
            throw new IllegalArgumentException("Expected 1 extra parameter for PlatEnfant");
        }
        double proportion = (double) extraParams[0];
        return new PlatEnfant(code, description, prix, proportion);
    }
}
