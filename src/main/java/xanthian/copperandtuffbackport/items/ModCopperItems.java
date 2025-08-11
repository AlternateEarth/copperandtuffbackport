package xanthian.copperandtuffbackport.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import xanthian.copperandtuffbackport.Initialise;
import xanthian.copperandtuffbackport.blocks.ModCopperBlocks;

public class ModCopperItems {
        private static final float PLAYER_DEFAULT_ATTACK_SPEED_INVERSE = -4F;

        public static final ModCopperArmorMaterial COPPER_ARMOR_MATERIAL = new ModCopperArmorMaterial();
        public static final ModCopperToolMaterial COPPER_TOOL_MATERIAL = new ModCopperToolMaterial();

        public static final Item COPPER_HELMET = new ArmorItem(COPPER_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new FabricItemSettings());
        public static final Item COPPER_BOOTS = new ArmorItem(COPPER_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new FabricItemSettings());
        public static final Item COPPER_LEGGINGS = new ArmorItem(COPPER_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new FabricItemSettings());
        public static final Item COPPER_CHESTPLATE = new ArmorItem(COPPER_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new FabricItemSettings());

        public static final Item COPPER_HORSE_ARMOR = new HorseArmorItem(4, "copper", new FabricItemSettings());

        // The type-specific attack damage bonus. 3 for swords, 1.5 for shovels, 1 for pickaxes, varying for axes and hoes.
        // This attack damage is combined with the base attack damage of the tool material.
        // Calculated Values:
        // - Sword: 5
        // - Pickaxe: 3
        // - Axe: 9
        // - Shovel: 3.5F
        // - Hoe: 1
        public static final Item COPPER_SWORD = new SwordItem(COPPER_TOOL_MATERIAL, 3, PLAYER_DEFAULT_ATTACK_SPEED_INVERSE + 1.6F, new FabricItemSettings());
        public static final Item COPPER_PICKAXE = new PickaxeItem(COPPER_TOOL_MATERIAL, 1, PLAYER_DEFAULT_ATTACK_SPEED_INVERSE + 1.2F, new FabricItemSettings());
        public static final Item COPPER_AXE = new AxeItem(COPPER_TOOL_MATERIAL, 7, PLAYER_DEFAULT_ATTACK_SPEED_INVERSE + 0.8F, new FabricItemSettings());
        public static final Item COPPER_SHOVEL = new ShovelItem(COPPER_TOOL_MATERIAL, 1.5F, PLAYER_DEFAULT_ATTACK_SPEED_INVERSE + 1F, new FabricItemSettings());
        public static final Item COPPER_HOE = new HoeItem(COPPER_TOOL_MATERIAL, -1, PLAYER_DEFAULT_ATTACK_SPEED_INVERSE + 2F, new FabricItemSettings());

        public static final Item COPPER_NUGGET = new Item(new FabricItemSettings());

        public static final Item COPPER_TORCH = new VerticallyAttachableBlockItem(ModCopperBlocks.COPPER_TORCH, ModCopperBlocks.COPPER_WALL_TORCH, new FabricItemSettings().fireproof(), Direction.DOWN);

        public static void registerItems() {
                register("copper_helmet", COPPER_HELMET);
                register("copper_boots", COPPER_BOOTS);
                register("copper_leggings", COPPER_LEGGINGS);
                register("copper_chestplate", COPPER_CHESTPLATE);

                register("copper_horse_armor", COPPER_HORSE_ARMOR);

                register("copper_sword", COPPER_SWORD);
                register("copper_pickaxe", COPPER_PICKAXE);
                register("copper_axe", COPPER_AXE);
                register("copper_shovel", COPPER_SHOVEL);
                register("copper_hoe", COPPER_HOE);

                register("copper_nugget", COPPER_NUGGET);

                register("copper_torch", (BlockItem)COPPER_TORCH);
        }

        private static void register(String name, Item item) {
                Identifier itemID = new Identifier(Initialise.MOD_ID, name);
                Registry.register(Registries.ITEM, itemID, item);
        }
}
