package logistics.utilities.loader.factory;

import logistics.utilities.loader.config.LoaderConfig;
import logistics.utilities.loader.implementation.InventoryXmlLoaderImpl;
import logistics.utilities.loader.interfaces.InventoryLoader;

/**
 * Created by uchennafokoye on 4/23/16.
 */
public class InventoryLoaderFactory 
{
    public static InventoryLoader build() 
    {
        switch (LoaderConfig.FilePath.FILE_TYPE)
        {
            case "xml":
                return new InventoryXmlLoaderImpl(LoaderConfig.FilePath.INVENTORY);
            case "json":
                return null;
            default:
                return null;
        }
    }
}
