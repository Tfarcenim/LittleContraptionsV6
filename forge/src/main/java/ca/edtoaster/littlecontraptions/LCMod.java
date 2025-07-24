package ca.edtoaster.littlecontraptions;

import ca.edtoaster.littlecontraptions.setup.Registration;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(LCMod.MOD_ID)
public class LCMod {
    public static final String MOD_ID = "littlecontraptions";
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public LCMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        Registration.register();
        if (FMLEnvironment.dist.isClient()) {
            bus.addListener(LCClient::setup);
        }
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID,path);
    }

}
