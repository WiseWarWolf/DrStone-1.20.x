package net.wise.drstonemod.datagen;

import cech12.bucketlib.BucketLib;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.fml.common.Mod;
import net.wise.drstonemod.DrStoneMod;
import net.wise.drstonemod.block.ModBlocks;
import net.wise.drstonemod.item.ModItems;
import net.wise.drstonemod.util.ModCookingRecipeBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    private static final List<ItemLike> ORE_SMELTABLES = List.of();
    private static final List<ItemLike> SMELTING = List.of(Items.WATER_BUCKET, ModItems.CLAY_POT.get());


    private static final List<ItemLike> RESULT_SALT = List.of(ModItems.SALT.get());


    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreBlasting(pWriter, ORE_SMELTABLES, RecipeCategory.MISC, ModItems.SULFA_DRUG.get(), 0.25f, 100, "sulfa_drug");
        oreSmelting(pWriter, ORE_SMELTABLES, RecipeCategory.MISC, ModItems.SULFA_DRUG.get(), 0.25f, 200, "sulfa_drug");

        SmeltingMuilt(pWriter, SMELTING , RecipeCategory.MISC, ModItems.SALT.get(), 0.25f, 200, "salt", 4);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BUNDLE_OF_HEMP.get())
                .pattern("##")
                .pattern("##")
                .define('#', ModItems.HEMP.get())
                .unlockedBy(getHasName(ModItems.HEMP.get()), has(ModItems.HEMP.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.HEMP.get(), 4)
                .requires(ModBlocks.BUNDLE_OF_HEMP.get())
                .unlockedBy(getHasName(ModBlocks.BUNDLE_OF_HEMP.get()), has(ModBlocks.BUNDLE_OF_HEMP.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLOCK_OF_SALT.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.SALT.get())
                .unlockedBy(getHasName(ModItems.SALT.get()), has(ModItems.SALT.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SALT.get(), 9)
                .requires(ModBlocks.BLOCK_OF_SALT.get())
                .unlockedBy(getHasName(ModBlocks.BLOCK_OF_SALT.get()), has(ModBlocks.BLOCK_OF_SALT.get()))
                .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void SmeltingMuilt(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup, int pCount) {
        MuiltCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, pCount, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, DrStoneMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }

    protected static void MuiltCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, int pCount, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            ModCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult,
                            pExperience, pCookingTime, pCount, pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, DrStoneMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
