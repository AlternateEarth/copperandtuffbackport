package alternateearth.copperandtuffbackport.blocks;

import alternateearth.copperandtuffbackport.Initialise;
import alternateearth.copperandtuffbackport.util.ModItemGroup;
import alternateearth.copperandtuffbackport.util.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.minecraft.block.Blocks.*;

public class ModPolishedTuff {
    private static Block POLISHED_TUFF;
    private static Block POLISHED_TUFF_SLAB;
    private static Block POLISHED_TUFF_STAIRS;
    private static Block POLISHED_TUFF_WALL;

    // Register all polished tuff blocks and items.
    public static void register() {
        registerPolishedTuff();
        registerPolishedTuffSlab();
        registerPolishedTuffStairs();
        registerPolishedTuffWall();
    }

    // Register the polished tuff blocks in the mod's item group.
    public static void registerModItemGroup() {
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.BACKPORT_MOD_ITEM_GROUP_KEY).register(content -> {
            content.add(POLISHED_TUFF);
            content.add(POLISHED_TUFF_SLAB);
            content.add(POLISHED_TUFF_STAIRS);
            content.add(POLISHED_TUFF_WALL);
        });
    }

    private static void registerPolishedTuff() {
        POLISHED_TUFF = new Block(FabricBlockSettings.copy(TUFF).sounds(ModSounds.POLISHED_TUFF));
        registryRegister("polished_tuff", POLISHED_TUFF);
    }

    private static void registerPolishedTuffSlab() {
        POLISHED_TUFF_SLAB = new SlabBlock(FabricBlockSettings.copy(POLISHED_TUFF));
        registryRegister("polished_tuff_slab", POLISHED_TUFF_SLAB);
    }

    private static void registerPolishedTuffStairs() {
        POLISHED_TUFF_STAIRS = new StairsBlock(POLISHED_TUFF.getDefaultState(),
                FabricBlockSettings.copy(POLISHED_TUFF));
        registryRegister("polished_tuff_stairs", POLISHED_TUFF_STAIRS);
    }

    private static void registerPolishedTuffWall() {
        POLISHED_TUFF_WALL = new WallBlock(FabricBlockSettings.copy(POLISHED_TUFF).solid());
        registryRegister("polished_tuff_wall", POLISHED_TUFF_WALL);
    }

    private static void registryRegister(String name, Block block) {
        var identifier = new Identifier(Initialise.MOD_ID, name);
        Registry.register(Registries.BLOCK, identifier, block);
        Registry.register(Registries.ITEM, identifier, new BlockItem(block, new FabricItemSettings()));
    }
}
