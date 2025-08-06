package xanthian.copperandtuffbackport.items;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class ModCopperToolMaterial implements ToolMaterial {

    @Override
    public int getDurability() {
        return 190;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 5.0F;
    }

    @Override
    public float getAttackDamage() {
        return 1F;
    }

    @Override
    public int getMiningLevel() {
        return 1; // Copper tools are equivalent to stone tools
    }

    @Override
    public int getEnchantability() {
        return 13; // Copper has a moderate enchantability
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.COPPER_INGOT);
    }
}
