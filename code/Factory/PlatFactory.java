package Factory;

import menufact.plats.PlatAuMenu;

public abstract class PlatFactory {
    public abstract PlatAuMenu createPlat(int code, String description, double prix, Object... extraParams);
}
