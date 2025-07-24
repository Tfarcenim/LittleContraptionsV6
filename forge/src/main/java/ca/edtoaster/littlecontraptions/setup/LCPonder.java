package ca.edtoaster.littlecontraptions.setup;

import ca.edtoaster.littlecontraptions.LCMod;
import ca.edtoaster.littlecontraptions.block.BargeAssemblerBlock;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.infrastructure.ponder.AllCreatePonderTags;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.entry.RegistryEntry;
import dev.murad.shipping.setup.ModBlocks;
import dev.murad.shipping.setup.ModItems;
import net.createmod.catnip.platform.CatnipServices;
import net.createmod.ponder.api.registration.PonderTagRegistrationHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

public class LCPonder {

    public static ResourceLocation LC_TUGS = LCMod.id("tugs");
    public static ResourceLocation LC_LOCOS = LCMod.id("trains");

    private static CreateRegistrate createRegistrate = CreateRegistrate.create(LCMod.MOD_ID);

    public static final BlockEntry<BargeAssemblerBlock> BARGE_ASSEMBLER_ENTRY = new BlockEntry<>(createRegistrate, LCBlocks.BARGE_ASSEMBLER);
    public static final BlockEntry<Block> CORNER_GUIDE_RAIL_BLOCK_BLOCK_ENTRY = new BlockEntry<>(createRegistrate, ModBlocks.GUIDE_RAIL_CORNER);
    public static final BlockEntry<Block> BARGE_DOCK_ENTRY = new BlockEntry<>(createRegistrate, ModBlocks.BARGE_DOCK);
    public static final BlockEntry<Block> TUG_DOCK_ENTRY = new BlockEntry<>(createRegistrate, ModBlocks.TUG_DOCK);
    public static final BlockEntry<Block> LOCO_DOCK_ENTRY = new BlockEntry<>(createRegistrate, ModBlocks.LOCOMOTIVE_DOCK_RAIL);
    public static final BlockEntry<Block> CAR_DOCK_ENTRY = new BlockEntry<>(createRegistrate, ModBlocks.CAR_DOCK_RAIL);
    public static final BlockEntry<Block> AUTO_SWITCH = new BlockEntry<>(createRegistrate, ModBlocks.AUTOMATIC_SWITCH_RAIL);
    public static final BlockEntry<Block> AUTO_TEE = new BlockEntry<>(createRegistrate, ModBlocks.AUTOMATIC_TEE_JUNCTION_RAIL);

    public static final ItemEntry<Item> STEAM_TUG_ITEM_ENTRY = new ItemEntry<>(createRegistrate, ModItems.STEAM_TUG);
    public static final ItemEntry<Item> ENERGY_TUG_ITEM_ENTRY = new ItemEntry<>(createRegistrate, ModItems.ENERGY_TUG);
    public static final ItemEntry<Item> STEAM_LOCOMOTIVE_ENTRY = new ItemEntry<>(createRegistrate, ModItems.STEAM_LOCOMOTIVE);
    public static final ItemEntry<Item> ENERGY_LOCOMOTIVE_ITEM_ENTRY = new ItemEntry<>(createRegistrate, ModItems.ENERGY_LOCOMOTIVE);
    public static final ItemEntry<Item> TUG_ROUTE_ENTRY = new ItemEntry<>(createRegistrate, ModItems.TUG_ROUTE);
    public static final ItemEntry<Item> LOCO_ROUTE_ENTRY = new ItemEntry<>(createRegistrate, ModItems.LOCO_ROUTE);
    public static final ItemEntry<Item> CONTRAPTION_BARGE_ENTRY = new ItemEntry<>(createRegistrate, LCItems.CONTRAPTION_BARGE_ITEM);

    public static void register(PonderTagRegistrationHelper<ResourceLocation> helper) {


       /* helper.registerTag(KINETIC_RELAYS)
                .addToIndex()
                .item(AllBlocks.COGWHEEL.get(), true, false)
                .title("Kinetic Blocks")
                .description("Components which help relaying Rotational Force elsewhere")
                .register();*/

        helper.registerTag(LC_TUGS)
                .item(ModItems.STEAM_TUG::get, true, false)
                .title("Little Logistics Tugs")
                .description("Water trains with pathfinding!").addToIndex()
                .register();

        helper.registerTag(LC_LOCOS)
                .item(ModItems.STEAM_LOCOMOTIVE::get, true, false)
                .title("Little Logistics Trains")
                .description("Small but smart locomotives!")
                .addToIndex()
                .register();

        PonderTagRegistrationHelper<RegistryEntry<?>> HELPER = helper.withKeyFunction(RegistryEntry::getId);

        PonderTagRegistrationHelper<ItemLike> itemHelper = helper.withKeyFunction(
                CatnipServices.REGISTRIES::getKeyOrThrow);



        HELPER.addToTag(AllCreatePonderTags.MOVEMENT_ANCHOR)
                        .add(BARGE_ASSEMBLER_ENTRY);


        HELPER.addToTag(LC_LOCOS)
                .add(LOCO_DOCK_ENTRY)
                .add(LOCO_ROUTE_ENTRY)
                .add(STEAM_LOCOMOTIVE_ENTRY)
                .add(ENERGY_LOCOMOTIVE_ITEM_ENTRY)
                .add(AUTO_TEE)
                .add(AUTO_SWITCH)
                .add(CAR_DOCK_ENTRY);

        HELPER.addToTag(LC_TUGS)
                .add(STEAM_TUG_ITEM_ENTRY)
                .add(CORNER_GUIDE_RAIL_BLOCK_BLOCK_ENTRY)
                .add(ENERGY_TUG_ITEM_ENTRY)
                .add(BARGE_ASSEMBLER_ENTRY)
                .add(CONTRAPTION_BARGE_ENTRY)
                .add(BARGE_DOCK_ENTRY)
                .add(TUG_DOCK_ENTRY)
                .add(TUG_ROUTE_ENTRY);
    }

}
