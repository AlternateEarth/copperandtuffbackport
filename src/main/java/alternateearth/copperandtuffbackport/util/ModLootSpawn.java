package alternateearth.copperandtuffbackport.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.BinomialLootNumberProvider;
import alternateearth.copperandtuffbackport.items.ModCopperItems;

public class ModLootSpawn {
    private static final int TREASURE_AMOUNT = 1;

    public static void registerLootSpawns() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            // We are only adding to the built-in loot tables, not custom ones.
            if (!source.isBuiltin())
                return;

            switch (id.toString()) {
                case "minecraft:chests/simple_dungeon" -> {
                    // 1 at 19.4% chance
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .with(ItemEntry.builder(ModCopperItems.COPPER_HORSE_ARMOR))
                            .rolls(BinomialLootNumberProvider.create(
                                    TREASURE_AMOUNT,
                                    .194F));
                    tableBuilder.pool(poolBuilder);
                }
                case "minecraft:chests/desert_pyramid" -> {
                    // 1 at 17% chance
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .with(ItemEntry.builder(ModCopperItems.COPPER_HORSE_ARMOR))
                            .rolls(BinomialLootNumberProvider.create(
                                    TREASURE_AMOUNT,
                                    .17F));
                    tableBuilder.pool(poolBuilder);
                }

                case "minecraft:chests/end_city_treasure" -> {
                    // 1 at 4.6% chance
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .with(ItemEntry.builder(ModCopperItems.COPPER_HORSE_ARMOR))
                            .rolls(BinomialLootNumberProvider.create(
                                    TREASURE_AMOUNT,
                                    .046F));
                    tableBuilder.pool(poolBuilder);
                }

                case "minecraft:chests/jungle_temple" -> {
                    // 1 at 4.4% chance
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .with(ItemEntry.builder(ModCopperItems.COPPER_HORSE_ARMOR))
                            .rolls(BinomialLootNumberProvider.create(
                                    TREASURE_AMOUNT,
                                    .044F));
                    tableBuilder.pool(poolBuilder);
                }

                case "minecraft:chests/nether_bridge" -> {
                    // 1 at 17.9% chance
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .with(ItemEntry.builder(ModCopperItems.COPPER_HORSE_ARMOR))
                            .rolls(BinomialLootNumberProvider.create(
                                    TREASURE_AMOUNT,
                                    .179F));
                    tableBuilder.pool(poolBuilder);
                }

                case "minecraft:chests/stronghold_corridor" -> {
                    // 1 at 2.5% chance
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .with(ItemEntry.builder(ModCopperItems.COPPER_HORSE_ARMOR))
                            .rolls(BinomialLootNumberProvider.create(
                                    TREASURE_AMOUNT,
                                    .025F));
                    tableBuilder.pool(poolBuilder);
                }

                case "minecraft:chests/village/village_weaponsmith" -> {
                    // 1 at 5.6% chance
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .with(ItemEntry.builder(ModCopperItems.COPPER_HORSE_ARMOR))
                            .rolls(BinomialLootNumberProvider.create(
                                    TREASURE_AMOUNT,
                                    .056F));
                    tableBuilder.pool(poolBuilder);
                }
            }
        });
    }
}
