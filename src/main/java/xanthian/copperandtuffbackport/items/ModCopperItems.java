package xanthian.copperandtuffbackport.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import xanthian.copperandtuffbackport.Initialise;

public class ModCopperItems {
        private static final float PLAYER_DEFAULT_ATTACK_SPEED_INVERSE = -4F;

        public static final ModCopperArmorMaterial COPPER_ARMOR_MATERIAL = new ModCopperArmorMaterial();
        public static final ModCopperToolMaterial COPPER_TOOL_MATERIAL = new ModCopperToolMaterial();

        public static final Item COPPER_HELMET = new ArmorItem(COPPER_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new FabricItemSettings());
        public static final Item COPPER_BOOTS = new ArmorItem(COPPER_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new FabricItemSettings());
        public static final Item COPPER_LEGGINGS = new ArmorItem(COPPER_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new FabricItemSettings());
        public static final Item COPPER_CHESTPLATE = new ArmorItem(COPPER_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new FabricItemSettings());

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

        public static void registerItems() {
                register("copper_helmet", COPPER_HELMET);
                register("copper_boots", COPPER_BOOTS);
                register("copper_leggings", COPPER_LEGGINGS);
                register("copper_chestplate", COPPER_CHESTPLATE);

                register("copper_sword", COPPER_SWORD);
                register("copper_pickaxe", COPPER_PICKAXE);
                register("copper_axe", COPPER_AXE);
                register("copper_shovel", COPPER_SHOVEL);
                register("copper_hoe", COPPER_HOE);
        }

        private static void register(String name, Item item) {
                Identifier itemID = new Identifier(Initialise.MOD_ID, name);
                Registry.register(Registries.ITEM, itemID, item);
        }
}
