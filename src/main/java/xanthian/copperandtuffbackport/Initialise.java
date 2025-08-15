package xanthian.copperandtuffbackport;

import net.fabricmc.api.ModInitializer;
import xanthian.copperandtuffbackport.blocks.*;
import xanthian.copperandtuffbackport.items.ModCopperItems;
import xanthian.copperandtuffbackport.util.ModItemGroup;
import xanthian.copperandtuffbackport.util.ModLootSpawn;
import xanthian.copperandtuffbackport.util.ModSounds;

public class Initialise implements ModInitializer {

    public static final String MOD_ID = "copperandtuffbackport";

    @Override
    public void onInitialize() {

        registerModBlocksAndItems();

        setupItemGroups();

        // Register loot tables
        ModLootSpawn.registerLootSpawns();

        // Register sounds
        ModSounds.registerSounds();

        registerOxidizable();
    }

    // Register the various blocks and items
    private void registerModBlocksAndItems() {
        ModChiseledCopper.register();
        ModCopperDoor.register();
        ModCopperTrapDoor.register();
        ModCopperGrate.register();
        ModCopperBulb.register();
        ModCopperLantern.register();
        ModCopperTorch.register();
        ModCopperItems.registerItems();
        ModTuffBlocks.registerBlocks();
    }

    // Setup the item groups
    private void setupItemGroups() {
        ModItemGroup.addToMod();
        ModItemGroup.addToCombat();
        ModItemGroup.addToTools();
        ModItemGroup.addToIngredients();
        ModItemGroup.addToBuildingBlocks();
        ModItemGroup.addToRedstoneBlocks();
        ModItemGroup.addToFunctionalBlocks();
    }

    // Register blocks as oxidizable
    private void registerOxidizable() {
        ModCopperDoor.registerOxidizable();
        ModCopperTrapDoor.registerOxidizable();
        ModCopperGrate.registerOxidizable();
        ModCopperBulb.registerOxidizable();
        ModCopperLantern.registerOxidizable();
        ModChiseledCopper.registerOxidizable();
    }
}
