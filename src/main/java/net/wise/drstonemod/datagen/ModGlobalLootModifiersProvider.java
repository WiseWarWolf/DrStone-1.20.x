package net.wise.drstonemod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import net.wise.drstonemod.DrStoneMod;
import net.wise.drstonemod.item.ModItems;
import net.wise.drstonemod.loot.AddItemModifier;
import org.checkerframework.checker.units.qual.A;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, DrStoneMod.MOD_ID);
    }

    @Override
    protected void start() {
        add("plant_fiber_from_grass", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
                LootItemRandomChanceCondition.randomChance(0.35f).build()}, ModItems.PLANT_FIBER.get()));
        add("plant_fiber_from_fern", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.FERN).build(),
                LootItemRandomChanceCondition.randomChance(0.35f).build()}, ModItems.PLANT_FIBER.get()));

        add("drago_from_villagers", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/villager")).build(),
                LootItemRandomChanceCondition.randomChance(0.5f).build()
        }, ModItems.DRAGO.get()));
    }
}
