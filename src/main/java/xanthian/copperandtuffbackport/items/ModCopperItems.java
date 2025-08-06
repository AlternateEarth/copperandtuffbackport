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
        private static final float TOOL_BASE_ATTACK_SPEED = -4F;
        private static final int TOOL_BASE_DAMAGE_REDUCTION = 2; // Done to align with vanilla values in 1.21.x

        public static final ModCopperArmorMaterial COPPER_ARMOR_MATERIAL = new ModCopperArmorMaterial();
        public static final ModCopperToolMaterial COPPER_TOOL_MATERIAL = new ModCopperToolMaterial();

        public static final Item COPPER_HELMET = new ArmorItem(COPPER_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new FabricItemSettings());
        public static final Item COPPER_BOOTS = new ArmorItem(COPPER_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new FabricItemSettings());
        public static final Item COPPER_LEGGINGS = new ArmorItem(COPPER_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new FabricItemSettings());
        public static final Item COPPER_CHESTPLATE = new ArmorItem(COPPER_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new FabricItemSettings());

        public static final Item COPPER_SWORD = new SwordItem(COPPER_TOOL_MATERIAL, 5 - TOOL_BASE_DAMAGE_REDUCTION, TOOL_BASE_ATTACK_SPEED + 1.6F, new FabricItemSettings());
        public static final Item COPPER_PICKAXE = new PickaxeItem(COPPER_TOOL_MATERIAL, 3 - TOOL_BASE_DAMAGE_REDUCTION, TOOL_BASE_ATTACK_SPEED + 1.2F, new FabricItemSettings());
        public static final Item COPPER_AXE = new AxeItem(COPPER_TOOL_MATERIAL, 9 - TOOL_BASE_DAMAGE_REDUCTION, TOOL_BASE_ATTACK_SPEED + 0.8F, new FabricItemSettings());
        public static final Item COPPER_SHOVEL = new ShovelItem(COPPER_TOOL_MATERIAL, 3.5F - TOOL_BASE_DAMAGE_REDUCTION, TOOL_BASE_ATTACK_SPEED + 1F, new FabricItemSettings());
        public static final Item COPPER_HOE = new HoeItem(COPPER_TOOL_MATERIAL, 1 - TOOL_BASE_DAMAGE_REDUCTION, TOOL_BASE_ATTACK_SPEED + 2F, new FabricItemSettings());

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
