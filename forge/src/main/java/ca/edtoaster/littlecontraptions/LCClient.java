package ca.edtoaster.littlecontraptions;

import ca.edtoaster.littlecontraptions.ponder.LCPonderPlugin;
import net.createmod.ponder.foundation.PonderIndex;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class LCClient {

    public static void setup(FMLClientSetupEvent event) {
        PonderIndex.addPlugin(new LCPonderPlugin());
    }

}
