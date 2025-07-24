package ca.edtoaster.littlecontraptions.setup;

import ca.edtoaster.littlecontraptions.ponder.AssemblerScenes;
import ca.edtoaster.littlecontraptions.ponder.LocomotiveScenes;
import ca.edtoaster.littlecontraptions.ponder.TugScenes;
import com.simibubi.create.foundation.ponder.CreateSceneBuilder;
import com.tterrag.registrate.util.entry.ItemProviderEntry;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;
import net.minecraft.resources.ResourceLocation;

import static ca.edtoaster.littlecontraptions.setup.LCPonder.*;

public class LCPonderScenes {

    public static void register(PonderSceneRegistrationHelper<ResourceLocation> helper) {
        PonderSceneRegistrationHelper<ItemProviderEntry<?>> HELPER = helper.withKeyFunction(RegistryEntry::getId);

        //HELPER.addTagToComponent();

        HELPER.forComponents(BARGE_ASSEMBLER_ENTRY, CONTRAPTION_BARGE_ENTRY)
                .addStoryBoard("basic_assembler", (scene, util) -> AssemblerScenes.basicAssemblerScene(new CreateSceneBuilder(scene), util));

        HELPER.forComponents(STEAM_TUG_ITEM_ENTRY, CORNER_GUIDE_RAIL_BLOCK_BLOCK_ENTRY, ENERGY_TUG_ITEM_ENTRY, TUG_ROUTE_ENTRY)
                .addStoryBoard("basic_tug", TugScenes::basicTugScene);

        HELPER.forComponents(BARGE_DOCK_ENTRY, TUG_DOCK_ENTRY, STEAM_TUG_ITEM_ENTRY, ENERGY_TUG_ITEM_ENTRY)
                .addStoryBoard("tug_dock", TugScenes::dockingScene);

        HELPER.forComponents(LOCO_DOCK_ENTRY, CAR_DOCK_ENTRY, STEAM_LOCOMOTIVE_ENTRY, ENERGY_LOCOMOTIVE_ITEM_ENTRY)
                .addStoryBoard("loco_dock", LocomotiveScenes::dockingScene);

        HELPER.forComponents(STEAM_LOCOMOTIVE_ENTRY, ENERGY_LOCOMOTIVE_ITEM_ENTRY, LOCO_ROUTE_ENTRY, AUTO_SWITCH, AUTO_TEE)
                .addStoryBoard("loco_route", LocomotiveScenes::routeScene);

    }
}
