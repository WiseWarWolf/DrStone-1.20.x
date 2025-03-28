package net.wise.drstonemod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.wise.drstonemod.DrStoneMod;
import net.wise.drstonemod.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, DrStoneMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.DRAGO);
        simpleItem(ModItems.HEMP);
        simpleItem(ModItems.SULFA_DRUG);
        simpleItem(ModItems.METAL_DETECTOR);
        simpleItem(ModItems.REJUVENATING_FLUID);
        simpleItem(ModItems.CLAY_POT);
        simpleItem(ModItems.BOW_DRILL);
        simpleItem(ModItems.ROPE);
        simpleItem(ModItems.GRASS_SKIRT);
        simpleItem(ModItems.SALT);
        simpleItem(ModItems.BUCKET_WINE);
        simpleItem(ModItems.BUCKET_BAT);
        simpleItem(ModItems.BUCKET_ETH);
        simpleItem(ModItems.UNFIRED_CLAY_POT);
        simpleItem(ModItems.PLANT_FIBER);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(DrStoneMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}
