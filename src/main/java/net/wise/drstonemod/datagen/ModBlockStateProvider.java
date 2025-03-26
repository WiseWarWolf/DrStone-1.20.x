package net.wise.drstonemod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.wise.drstonemod.DrStoneMod;
import net.wise.drstonemod.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, DrStoneMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.BUNDLE_OF_HEMP);
        blockWithItem(ModBlocks.BLOCK_OF_SALT);
        dynamicBlockWithItem(ModBlocks.DISTILLATION_EARTHENWARE, "block/distillation_earthenware_bottom", "block/distillation_earthenware_top", "block/distillation_earthenware_sides","block/distillation_earthenware_sides");

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void dynamicBlockWithItem(RegistryObject<Block> block, String downTexture, String upTexture, String sideTexture, String parTexture) {
        simpleBlock(block.get(), models().cube(block.getId().getPath(),
                modLoc(downTexture),
                modLoc(upTexture),
                modLoc(sideTexture),
                modLoc(sideTexture),
                modLoc(sideTexture),
                modLoc(sideTexture)
        ));
        simpleBlockItem(block.get(), models().getExistingFile(modLoc("block/" + block.getId().getPath())));
        // Set the particle texture explicitly
        models().withExistingParent(block.getId().getPath(), "block/cube").texture("particle", modLoc(parTexture));
    }

}

