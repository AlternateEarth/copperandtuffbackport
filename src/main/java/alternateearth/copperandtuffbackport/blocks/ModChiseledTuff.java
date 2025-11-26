package alternateearth.copperandtuffbackport.blocks;

import alternateearth.copperandtuffbackport.Initialise;
import alternateearth.copperandtuffbackport.util.ModItemGroup;
import alternateearth.copperandtuffbackport.util.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.minecraft.block.Blocks.*;

public class ModChiseledTuff {
    private static Block CHISELED_TUFF;
    private static Block CHISELED_TUFF_BRICKS;

    // Register all tuff brick blocks and items.
    public static void register() {
        registerChiseledTuff();
        registerChiseledTuffBricks();
    }

    // Register the polished tuff blocks in the mod's item group.
    public static void registerModItemGroup() {
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.BACKPORT_MOD_ITEM_GROUP_KEY).register(content -> {
            content.add(CHISELED_TUFF);
            content.add(CHISELED_TUFF_BRICKS);
        });
    }

    private static void registerChiseledTuff() {
        CHISELED_TUFF = new Block(FabricBlockSettings.copy(TUFF));
        registryRegister("chiseled_tuff", CHISELED_TUFF);
    }

    private static void registerChiseledTuffBricks() {
        CHISELED_TUFF_BRICKS = new Block(FabricBlockSettings.copy(TUFF).sounds(ModSounds.TUFF_BRICKS));
        registryRegister("chiseled_tuff_bricks", CHISELED_TUFF_BRICKS);
    }

    private static void registryRegister(String name, Block block) {
        var identifier = new Identifier(Initialise.MOD_ID, name);
        Registry.register(Registries.BLOCK, identifier, block);
        Registry.register(Registries.ITEM, identifier, new BlockItem(block, new FabricItemSettings()));
    }
}
