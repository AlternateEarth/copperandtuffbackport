package alternateearth.copperandtuffbackport.blocks;

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
import alternateearth.copperandtuffbackport.Initialise;
import alternateearth.copperandtuffbackport.util.ModItemGroup;

import static net.minecraft.block.Blocks.*;

public class ModTuffBlocks {

    private static Block TUFF_SLAB;
    private static Block TUFF_STAIRS;
    private static Block TUFF_WALL;

    // Register all tuff blocks and items.
    public static void register() {
        registerTuffSlab();
        registerTuffStairs();
        registerTuffWall();
    }

    // Register the tuff blocks in the mod's item group.
    public static void registerModItemGroup() {
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.BACKPORT_MOD_ITEM_GROUP_KEY).register(content -> {
            content.add(TUFF_SLAB);
            content.add(TUFF_STAIRS);
            content.add(TUFF_WALL);
        });
    }

    private static void registerTuffSlab() {
        TUFF_SLAB = new SlabBlock(FabricBlockSettings.copy(TUFF));
        registryRegister("tuff_slab", TUFF_SLAB);
    }

    private static void registerTuffStairs() {
        TUFF_STAIRS = new StairsBlock(TUFF.getDefaultState(), FabricBlockSettings.copy(TUFF));
        registryRegister("tuff_stairs", TUFF_STAIRS);
    }

    private static void registerTuffWall() {
        TUFF_WALL = new WallBlock(FabricBlockSettings.copy(TUFF).solid());
        registryRegister("tuff_wall", TUFF_WALL);
    }

    private static void registryRegister(String name, Block block) {
        var identifier = new Identifier(Initialise.MOD_ID, name);
        Registry.register(Registries.BLOCK, identifier, block);
        Registry.register(Registries.ITEM, identifier, new BlockItem(block, new FabricItemSettings()));
    }
}
