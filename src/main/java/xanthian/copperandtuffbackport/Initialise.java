package xanthian.copperandtuffbackport;

import net.fabricmc.api.ModInitializer;
import xanthian.copperandtuffbackport.blocks.ModCopperBlocks;
import xanthian.copperandtuffbackport.blocks.ModTuffBlocks;
import xanthian.copperandtuffbackport.items.ModCopperItems;
import xanthian.copperandtuffbackport.util.ModItemGroup;
import xanthian.copperandtuffbackport.util.ModLootSpawn;
import xanthian.copperandtuffbackport.util.ModRegistries;
import xanthian.copperandtuffbackport.util.ModSounds;

public class Initialise implements ModInitializer {

    public static final String MOD_ID = "copperandtuffbackport";

    @Override
    public void onInitialize() {

        ModCopperItems.registerItems();
        ModCopperBlocks.registerBlocks();
        ModTuffBlocks.registerBlocks();

        ModItemGroup.addToCombat();
        ModItemGroup.addToTools();
        ModItemGroup.addToIngredients();
        ModItemGroup.addToBuildingBlocks();
        ModItemGroup.addToRedstoneBlocks();
        ModItemGroup.addToFunctionalBlocks();
        ModLootSpawn.registerLootSpawns();
        ModSounds.registerSounds();
        ModRegistries.registerOxidizableBlocks();

    }
}
