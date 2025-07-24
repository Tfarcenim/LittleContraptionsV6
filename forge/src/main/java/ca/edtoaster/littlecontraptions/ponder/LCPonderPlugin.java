package ca.edtoaster.littlecontraptions.ponder;
import ca.edtoaster.littlecontraptions.LCMod;
import ca.edtoaster.littlecontraptions.setup.LCPonder;
import ca.edtoaster.littlecontraptions.setup.LCPonderScenes;
import net.createmod.ponder.api.registration.PonderPlugin;
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;
import net.createmod.ponder.api.registration.PonderTagRegistrationHelper;
import net.minecraft.resources.ResourceLocation;

public class LCPonderPlugin implements PonderPlugin {


    @Override
    public String getModId() {
        return LCMod.MOD_ID;
    }

    @Override
    public void registerTags(PonderTagRegistrationHelper<ResourceLocation> helper) {
        LCPonder.register(helper);
    }

    @Override
    public void registerScenes(PonderSceneRegistrationHelper<ResourceLocation> helper) {
        LCPonderScenes.register(helper);
    }
}
