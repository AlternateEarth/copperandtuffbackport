package xanthian.copperandtuffbackport.util;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import xanthian.copperandtuffbackport.Initialise;
import xanthian.copperandtuffbackport.blocks.*;
import xanthian.copperandtuffbackport.items.ModCopperItems;

public class ModItemGroup {
    public static final RegistryKey<ItemGroup> BACKPORT_MOD_ITEM_GROUP_KEY = RegistryKey.of(
            Registries.ITEM_GROUP.getKey(),
            new Identifier(Initialise.MOD_ID, "copper_and_tuff_backport"));
    public static final ItemGroup BACKPORT_MOD_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(
                    ModChiseledCopper.CHISELED_COPPER))
            .displayName(Text.translatable("copperandtuffbackport.identifier"))
            .build();

    public static void addToMod() {

        Registry.register(Registries.ITEM_GROUP, BACKPORT_MOD_ITEM_GROUP_KEY, BACKPORT_MOD_ITEM_GROUP);

        // Miscellaneous
        ModCopperTorch.registerModItemGroup();
        ModCopperLantern.registerModItemGroup();

        // Blocks
        ModChiseledCopper.registerModItemGroup();
        ModCopperDoor.registerModItemGroup();
        ModCopperTrapDoor.registerModItemGroup();
        ModCopperGrate.registerModItemGroup();
        ModCopperBulb.registerModItemGroup();

        ItemGroupEvents.modifyEntriesEvent(BACKPORT_MOD_ITEM_GROUP_KEY).register(content -> {
            // Tools and Weapons
            content.add(ModCopperItems.COPPER_SWORD);
            content.add(ModCopperItems.COPPER_AXE);
            content.add(ModCopperItems.COPPER_HOE);
            content.add(ModCopperItems.COPPER_SHOVEL);
            content.add(ModCopperItems.COPPER_PICKAXE);

            // Armor
            content.add(ModCopperItems.COPPER_HELMET);
            content.add(ModCopperItems.COPPER_CHESTPLATE);
            content.add(ModCopperItems.COPPER_LEGGINGS);
            content.add(ModCopperItems.COPPER_BOOTS);
            content.add(ModCopperItems.COPPER_HORSE_ARMOR);

            // Miscellaneous
            content.add(ModCopperItems.COPPER_NUGGET);
            // Copper torch goes here
            // Copper Lanter goes here

            // Blocks
            // Chiseled Copper Goes Here
            // Copper Door Goes Here
            // Copper Trapdoor goes here
            // Copper grate goes here
            // Copper bulb goes here

            content.add(ModTuffBlocks.TUFF_STAIRS);
            content.add(ModTuffBlocks.TUFF_SLAB);
            content.add(ModTuffBlocks.TUFF_WALL);
            content.add(ModTuffBlocks.CHISELED_TUFF);
            content.add(ModTuffBlocks.POLISHED_TUFF);
            content.add(ModTuffBlocks.POLISHED_TUFF_STAIRS);
            content.add(ModTuffBlocks.POLISHED_TUFF_SLAB);
            content.add(ModTuffBlocks.POLISHED_TUFF_WALL);
            content.add(ModTuffBlocks.TUFF_BRICKS);
            content.add(ModTuffBlocks.TUFF_BRICK_STAIRS);
            content.add(ModTuffBlocks.TUFF_BRICK_SLAB);
            content.add(ModTuffBlocks.TUFF_BRICK_WALL);
            content.add(ModTuffBlocks.CHISELED_TUFF_BRICKS);
        });
    }

    public static void addToCombat() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(Items.LEATHER_BOOTS, ModCopperItems.COPPER_HELMET);
            content.addAfter(ModCopperItems.COPPER_HELMET, ModCopperItems.COPPER_CHESTPLATE);
            content.addAfter(ModCopperItems.COPPER_CHESTPLATE, ModCopperItems.COPPER_LEGGINGS);
            content.addAfter(ModCopperItems.COPPER_LEGGINGS, ModCopperItems.COPPER_BOOTS);

            content.addAfter(Items.LEATHER_HORSE_ARMOR, ModCopperItems.COPPER_HORSE_ARMOR);

            content.addAfter(Items.STONE_SWORD, ModCopperItems.COPPER_SWORD);
            content.addAfter(Items.STONE_AXE, ModCopperItems.COPPER_AXE);
        });
    }

    public static void addToTools() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(Items.STONE_HOE, ModCopperItems.COPPER_SHOVEL);
            content.addAfter(ModCopperItems.COPPER_SHOVEL, ModCopperItems.COPPER_PICKAXE);
            content.addAfter(ModCopperItems.COPPER_PICKAXE, ModCopperItems.COPPER_AXE);
            content.addAfter(ModCopperItems.COPPER_AXE, ModCopperItems.COPPER_HOE);
        });
    }

    public static void addToIngredients() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
            content.addAfter(Items.IRON_NUGGET, ModCopperItems.COPPER_NUGGET);
        });
    }

    public static void addToBuildingBlocks() {

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
            /*
             * content.addAfter(Blocks.COPPER_BLOCK, ModCopperBlocks.CHISELED_COPPER);
             * content.addBefore(Blocks.CUT_COPPER, ModCopperBlocks.COPPER_GRATE);
             * content.addAfter(Blocks.CUT_COPPER_SLAB, ModCopperBlocks.COPPER_DOOR);
             * content.addAfter(ModCopperBlocks.COPPER_DOOR,
             * ModCopperBlocks.COPPER_TRAPDOOR);
             * content.addBefore(Blocks.EXPOSED_COPPER, ModCopperBlocks.COPPER_BULB);
             * 
             * content.addAfter(Blocks.EXPOSED_COPPER,
             * ModCopperBlocks.EXPOSED_CHISELED_COPPER);
             * content.addBefore(Blocks.EXPOSED_CUT_COPPER,
             * ModCopperBlocks.EXPOSED_COPPER_GRATE);
             * content.addAfter(Blocks.EXPOSED_CUT_COPPER_SLAB,
             * ModCopperBlocks.EXPOSED_COPPER_DOOR);
             * content.addAfter(ModCopperBlocks.EXPOSED_COPPER_DOOR,
             * ModCopperBlocks.EXPOSED_COPPER_TRAPDOOR);
             * content.addBefore(Blocks.WEATHERED_COPPER,
             * ModCopperBlocks.EXPOSED_COPPER_BULB);
             * 
             * content.addAfter(Blocks.WEATHERED_COPPER,
             * ModCopperBlocks.WEATHERED_CHISELED_COPPER);
             * content.addBefore(Blocks.WEATHERED_CUT_COPPER,
             * ModCopperBlocks.WEATHERED_COPPER_GRATE);
             * content.addAfter(Blocks.WEATHERED_CUT_COPPER_SLAB,
             * ModCopperBlocks.WEATHERED_COPPER_DOOR);
             * content.addAfter(ModCopperBlocks.WEATHERED_COPPER_DOOR,
             * ModCopperBlocks.WEATHERED_COPPER_TRAPDOOR);
             * content.addBefore(Blocks.OXIDIZED_COPPER,
             * ModCopperBlocks.WEATHERED_COPPER_BULB);
             * 
             * content.addAfter(Blocks.OXIDIZED_COPPER,
             * ModCopperBlocks.OXIDIZED_CHISELED_COPPER);
             * content.addBefore(Blocks.OXIDIZED_CUT_COPPER,
             * ModCopperBlocks.OXIDIZED_COPPER_GRATE);
             * content.addAfter(Blocks.OXIDIZED_CUT_COPPER_SLAB,
             * ModCopperBlocks.OXIDIZED_COPPER_DOOR);
             * content.addAfter(ModCopperBlocks.OXIDIZED_COPPER_DOOR,
             * ModCopperBlocks.OXIDIZED_COPPER_TRAPDOOR);
             * content.addBefore(Blocks.WAXED_COPPER_BLOCK,
             * ModCopperBlocks.OXIDIZED_COPPER_BULB);
             * 
             * content.addAfter(Blocks.WAXED_COPPER_BLOCK,
             * ModCopperBlocks.WAXED_CHISELED_COPPER);
             * content.addBefore(Blocks.WAXED_CUT_COPPER,
             * ModCopperBlocks.WAXED_COPPER_GRATE);
             * content.addAfter(Blocks.WAXED_CUT_COPPER_SLAB,
             * ModCopperBlocks.WAXED_COPPER_DOOR);
             * content.addAfter(ModCopperBlocks.WAXED_COPPER_DOOR,
             * ModCopperBlocks.WAXED_COPPER_TRAPDOOR);
             * content.addBefore(Blocks.WAXED_EXPOSED_COPPER,
             * ModCopperBlocks.WAXED_COPPER_BULB);
             * 
             * content.addAfter(Blocks.WAXED_EXPOSED_COPPER,
             * ModCopperBlocks.WAXED_EXPOSED_CHISELED_COPPER);
             * content.addBefore(Blocks.WAXED_EXPOSED_CUT_COPPER,
             * ModCopperBlocks.WAXED_EXPOSED_COPPER_GRATE);
             * content.addAfter(Blocks.WAXED_EXPOSED_CUT_COPPER_SLAB,
             * ModCopperBlocks.WAXED_EXPOSED_COPPER_DOOR);
             * content.addAfter(ModCopperBlocks.WAXED_EXPOSED_COPPER_DOOR,
             * ModCopperBlocks.WAXED_EXPOSED_COPPER_TRAPDOOR);
             * content.addBefore(Blocks.WAXED_WEATHERED_COPPER,
             * ModCopperBlocks.WAXED_EXPOSED_COPPER_BULB);
             * 
             * content.addAfter(Blocks.WAXED_WEATHERED_COPPER,
             * ModCopperBlocks.WAXED_WEATHERED_CHISELED_COPPER);
             * content.addBefore(Blocks.WAXED_WEATHERED_CUT_COPPER,
             * ModCopperBlocks.WAXED_WEATHERED_COPPER_GRATE);
             * content.addAfter(Blocks.WAXED_WEATHERED_CUT_COPPER_SLAB,
             * ModCopperBlocks.WAXED_WEATHERED_COPPER_DOOR);
             * content.addAfter(ModCopperBlocks.WAXED_WEATHERED_COPPER_DOOR,
             * ModCopperBlocks.WAXED_WEATHERED_COPPER_TRAPDOOR);
             * content.addBefore(Blocks.WAXED_OXIDIZED_COPPER,
             * ModCopperBlocks.WAXED_WEATHERED_COPPER_BULB);
             * 
             * content.addAfter(Blocks.WAXED_OXIDIZED_COPPER,
             * ModCopperBlocks.WAXED_OXIDIZED_CHISELED_COPPER);
             * content.addBefore(Blocks.WAXED_OXIDIZED_CUT_COPPER,
             * ModCopperBlocks.WAXED_OXIDIZED_COPPER_GRATE);
             * content.addAfter(Blocks.WAXED_OXIDIZED_CUT_COPPER_SLAB,
             * ModCopperBlocks.WAXED_OXIDIZED_COPPER_DOOR);
             * content.addAfter(ModCopperBlocks.WAXED_OXIDIZED_COPPER_DOOR,
             * ModCopperBlocks.WAXED_OXIDIZED_COPPER_TRAPDOOR);
             * content.addAfter(ModCopperBlocks.WAXED_OXIDIZED_COPPER_TRAPDOOR,
             * ModCopperBlocks.WAXED_OXIDIZED_COPPER_BULB);
             */
            content.addAfter(Blocks.REINFORCED_DEEPSLATE, Blocks.TUFF);
            content.addAfter(Blocks.TUFF, ModTuffBlocks.TUFF_STAIRS);
            content.addAfter(ModTuffBlocks.TUFF_STAIRS, ModTuffBlocks.TUFF_SLAB);
            content.addAfter(ModTuffBlocks.TUFF_SLAB, ModTuffBlocks.TUFF_WALL);
            content.addAfter(ModTuffBlocks.TUFF_WALL, ModTuffBlocks.CHISELED_TUFF);
            content.addAfter(ModTuffBlocks.CHISELED_TUFF, ModTuffBlocks.POLISHED_TUFF);
            content.addAfter(ModTuffBlocks.POLISHED_TUFF, ModTuffBlocks.POLISHED_TUFF_STAIRS);
            content.addAfter(ModTuffBlocks.POLISHED_TUFF_STAIRS, ModTuffBlocks.POLISHED_TUFF_SLAB);
            content.addAfter(ModTuffBlocks.POLISHED_TUFF_SLAB, ModTuffBlocks.POLISHED_TUFF_WALL);
            content.addAfter(ModTuffBlocks.POLISHED_TUFF_WALL, ModTuffBlocks.TUFF_BRICKS);
            content.addAfter(ModTuffBlocks.TUFF_BRICKS, ModTuffBlocks.TUFF_BRICK_STAIRS);
            content.addAfter(ModTuffBlocks.TUFF_BRICK_STAIRS, ModTuffBlocks.TUFF_BRICK_SLAB);
            content.addAfter(ModTuffBlocks.TUFF_BRICK_SLAB, ModTuffBlocks.TUFF_BRICK_WALL);
            content.addAfter(ModTuffBlocks.TUFF_BRICK_WALL, ModTuffBlocks.CHISELED_TUFF_BRICKS);

        });
    }

    public static void addToRedstoneBlocks() {

        /*
         * ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(content -> {
         * content.addAfter(Blocks.TARGET, ModCopperBlocks.WAXED_COPPER_BULB);
         * content.addAfter(ModCopperBlocks.WAXED_COPPER_BULB,
         * ModCopperBlocks.WAXED_EXPOSED_COPPER_BULB);
         * content.addAfter(ModCopperBlocks.WAXED_EXPOSED_COPPER_BULB,
         * ModCopperBlocks.WAXED_WEATHERED_COPPER_BULB);
         * content.addAfter(ModCopperBlocks.WAXED_WEATHERED_COPPER_BULB,
         * ModCopperBlocks.WAXED_OXIDIZED_COPPER_BULB);
         * });
         */
    }

    public static void addToFunctionalBlocks() {
        /*
         * ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content ->
         * {
         * content.addAfter(Blocks.SOUL_TORCH, ModCopperItems.COPPER_TORCH);
         * content.addAfter(Blocks.SOUL_LANTERN, ModCopperBlocks.COPPER_LANTERN);
         * content.addAfter(ModCopperBlocks.COPPER_LANTERN,
         * ModCopperBlocks.EXPOSED_COPPER_LANTERN);
         * content.addAfter(ModCopperBlocks.EXPOSED_COPPER_LANTERN,
         * ModCopperBlocks.WEATHERED_COPPER_LANTERN);
         * content.addAfter(ModCopperBlocks.WEATHERED_COPPER_LANTERN,
         * ModCopperBlocks.OXIDIZED_COPPER_LANTERN);
         * content.addAfter(ModCopperBlocks.OXIDIZED_COPPER_LANTERN,
         * ModCopperBlocks.WAXED_COPPER_LANTERN);
         * content.addAfter(ModCopperBlocks.WAXED_COPPER_LANTERN,
         * ModCopperBlocks.WAXED_EXPOSED_COPPER_LANTERN);
         * content.addAfter(ModCopperBlocks.WAXED_EXPOSED_COPPER_LANTERN,
         * ModCopperBlocks.WAXED_WEATHERED_COPPER_LANTERN);
         * content.addAfter(ModCopperBlocks.WAXED_WEATHERED_COPPER_LANTERN,
         * ModCopperBlocks.WAXED_OXIDIZED_COPPER_LANTERN);
         * 
         * content.addAfter(Blocks.REDSTONE_LAMP, ModCopperBlocks.WAXED_COPPER_BULB);
         * content.addAfter(ModCopperBlocks.WAXED_COPPER_BULB,
         * ModCopperBlocks.WAXED_EXPOSED_COPPER_BULB);
         * content.addAfter(ModCopperBlocks.WAXED_EXPOSED_COPPER_BULB,
         * ModCopperBlocks.WAXED_WEATHERED_COPPER_BULB);
         * content.addAfter(ModCopperBlocks.WAXED_WEATHERED_COPPER_BULB,
         * ModCopperBlocks.WAXED_OXIDIZED_COPPER_BULB);
         * 
         * });
         */
    }

}