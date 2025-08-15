package alternateearth.copperandtuffbackport.blocks;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.block.Block;
import net.minecraft.block.TorchBlock;
import net.minecraft.block.WallTorchBlock;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.VerticallyAttachableBlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import alternateearth.copperandtuffbackport.Initialise;
import alternateearth.copperandtuffbackport.particles.ModParticles;
import alternateearth.copperandtuffbackport.util.ModItemGroup;

public class ModCopperTorch {
    private static final int COPPER_TORCH_LIGHT_LEVEL = 12;

    private static final Settings COPPER_TORCH_SETTINGS = Block.Settings
            .create()
            .noCollision()
            .breakInstantly()
            .luminance(state -> COPPER_TORCH_LIGHT_LEVEL)
            .sounds(BlockSoundGroup.WOOD)
            .pistonBehavior(PistonBehavior.DESTROY);

    private static Block COPPER_TORCH;
    private static Block COPPER_WALL_TORCH;
    private static Item COPPER_TORCH_ITEM;

    // Register all copper torch blocks and items.
    public static void register() {
        registerTorch();
        registerWallTorch();
        registerTorchItem();
    }

    // Register the copper torch as oxidizable for the Fabric system.
    public static void registerOxidizable() {
        throw new UnsupportedOperationException("Copper torches does not support oxidization.");
    }

    // Register the copper torch in the mod's item group.
    public static void registerModItemGroup() {
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.BACKPORT_MOD_ITEM_GROUP_KEY).register(content -> {
            content.add(COPPER_TORCH_ITEM);
        });
    }

    // Setup the block render layer map for the copper torch, used by the client
    // init system.
    public static void setupBlockRenderLayerMap() {
        BlockRenderLayerMap.INSTANCE.putBlock(COPPER_TORCH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(COPPER_WALL_TORCH, RenderLayer.getCutout());
    }

    private static void registerTorch() {
        COPPER_TORCH = new TorchBlock(COPPER_TORCH_SETTINGS, ModParticles.COPPER_FLAME);
        registryRegister("copper_torch", COPPER_TORCH);
    }

    private static void registerWallTorch() {
        COPPER_WALL_TORCH = new WallTorchBlock(
                FabricBlockSettings.copyOf(COPPER_TORCH).dropsLike(COPPER_TORCH), ModParticles.COPPER_FLAME);
        registryRegister("copper_wall_torch", COPPER_WALL_TORCH);
    }

    private static void registerTorchItem() {
        COPPER_TORCH_ITEM = new VerticallyAttachableBlockItem(
                COPPER_TORCH,
                COPPER_WALL_TORCH,
                new FabricItemSettings().fireproof(),
                Direction.DOWN);
        registryRegisterItem("copper_torch", (BlockItem) COPPER_TORCH_ITEM);
    }

    private static void registryRegister(String name, Block block) {
        Identifier identifier = new Identifier(Initialise.MOD_ID, name);
        Registry.register(Registries.BLOCK, identifier, block);
    }

    private static void registryRegisterItem(String name, Item item) {
        Identifier identifier = new Identifier(Initialise.MOD_ID, name);
        Registry.register(Registries.ITEM, identifier, item);
    }
}
