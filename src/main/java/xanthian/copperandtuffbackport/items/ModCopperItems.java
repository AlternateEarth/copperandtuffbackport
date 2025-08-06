package xanthian.copperandtuffbackport.items;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import xanthian.copperandtuffbackport.Initialise;

public class ModCopperItems {
        public static final ModCopperArmorMaterial COPPER_ARMOR_MATERIAL = new ModCopperArmorMaterial();

        public static final Item COPPER_HELMET = new ArmorItem(COPPER_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                        new Item.Settings());
        public static final Item COPPER_BOOTS = new ArmorItem(COPPER_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                        new Item.Settings());
        public static final Item COPPER_LEGGINGS = new ArmorItem(COPPER_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                        new Item.Settings());
        public static final Item COPPER_CHESTPLATE = new ArmorItem(COPPER_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                        new Item.Settings());

        public static void registerItems() {
                register("copper_helmet", COPPER_HELMET);
                register("copper_boots", COPPER_BOOTS);
                register("copper_leggings", COPPER_LEGGINGS);
                register("copper_chestplate", COPPER_CHESTPLATE);
        }

        private static void register(String name, Item item) {
                Identifier itemID = new Identifier(Initialise.MOD_ID, name);
                Registry.register(Registries.ITEM, itemID, item);
        }
}
