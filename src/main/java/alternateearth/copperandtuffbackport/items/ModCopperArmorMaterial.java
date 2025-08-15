package alternateearth.copperandtuffbackport.items;

import net.minecraft.item.ArmorItem.Type;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import alternateearth.copperandtuffbackport.util.ModSounds;

public class ModCopperArmorMaterial implements ArmorMaterial {

    @Override
    public int getDurability(Type type) {
        int DURABILITY_MULTIPLIER = 11;
        return switch (type) {
            case BOOTS -> 13 * DURABILITY_MULTIPLIER;
            case LEGGINGS -> 15 * DURABILITY_MULTIPLIER;
            case CHESTPLATE -> 16 * DURABILITY_MULTIPLIER;
            case HELMET -> 11 * DURABILITY_MULTIPLIER;
            default -> 0;
        };
    }

    // Protection maps to Armor value in Minecraft
    @Override
    public int getProtection(Type type) {
        return switch (type) {
            case BOOTS -> 1;
            case HELMET -> 2;
            case LEGGINGS -> 3;
            case CHESTPLATE -> 4;
            default -> 0;
        };
    }

    @Override
    public int getEnchantability() {
        return 8; // Enchantability for Copper Armor
    }

    @Override
    public SoundEvent getEquipSound() {
        return ModSounds.BLOCK_COPPER_ARMOR_EQUIP;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.COPPER_INGOT);
    }

    @Override
    public String getName() {
        return "copper";
    }

    @Override
    public float getToughness() {
        return 0.0F; // Copper Armor has no toughness
    }

    @Override
    public float getKnockbackResistance() {
        return 0.0F; // Copper Armor has no knockback resistance
    }
}
