package xanthian.copperandtuffbackport.items;

import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import xanthian.copperandtuffbackport.Initialise;

public class ModTrimItems {
    public static final Item BOLT_ARMOR_TRIM_SMITHING_TEMPLATE = SmithingTemplateItem.of(new Identifier(Initialise.MOD_ID, "bolt_armor_trim_smithing_template"));

    public static void registerItems() {
        register("bolt_armor_trim_smithing_template", BOLT_ARMOR_TRIM_SMITHING_TEMPLATE);
    }

    private static void register(String name, Item item) {
        Identifier itemID = new Identifier(Initialise.MOD_ID, name);
        Registry.register(Registries.ITEM, itemID, item);
    }
}
