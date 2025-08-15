package alternateearth.copperandtuffbackport;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import alternateearth.copperandtuffbackport.blocks.*;
import alternateearth.copperandtuffbackport.items.ModCopperItems;
import alternateearth.copperandtuffbackport.util.ModItemGroup;
import alternateearth.copperandtuffbackport.util.ModLootSpawn;
import alternateearth.copperandtuffbackport.util.ModSounds;

public final class Initialise implements ModInitializer {

    public static final String MOD_ID = "copperandtuffbackport";
    public static final String MOD_NAME = "Copper and Tuff Backport";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {

        LOGGER.info("[{}] Starting Initialization", MOD_NAME);

        registerModBlocksAndItems();

        setupItemGroups();

        // Register loot tables
        LOGGER.info("[{}] Registering loot tables", MOD_NAME);
        ModLootSpawn.registerLootSpawns();

        // Register sounds
        LOGGER.info("[{}] Registering sounds", MOD_NAME);
        ModSounds.registerSounds();

        registerOxidizable();

        LOGGER.info("[{}] Initialization complete", MOD_NAME);
    }

    // Register the various blocks and items
    private void registerModBlocksAndItems() {
        LOGGER.info("[{}] Registering blocks and items", MOD_NAME);
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
        LOGGER.info("[{}] Setting up item groups", MOD_NAME);
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
        LOGGER.info("[{}] Registering blocks as oxidizable", MOD_NAME);
        ModCopperDoor.registerOxidizable();
        ModCopperTrapDoor.registerOxidizable();
        ModCopperGrate.registerOxidizable();
        ModCopperBulb.registerOxidizable();
        ModCopperLantern.registerOxidizable();
        ModChiseledCopper.registerOxidizable();
    }
}
