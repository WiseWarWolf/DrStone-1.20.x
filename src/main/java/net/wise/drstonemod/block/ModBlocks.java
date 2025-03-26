package net.wise.drstonemod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.wise.drstonemod.DrStoneMod;
import net.wise.drstonemod.fluid.ModFluids;
import net.wise.drstonemod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, DrStoneMod.MOD_ID);

    //Basic Blocks

    public static final RegistryObject<Block> BUNDLE_OF_HEMP = registerBlock("bundle_of_hemp",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.LIME_WOOL).instabreak().sound(SoundType.GRASS)));

    public static final RegistryObject<Block> BLOCK_OF_SALT = registerBlock("block_of_salt",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SAND)));

    public static final RegistryObject<Block> DISTILLATION_EARTHENWARE = registerBlock("distillation_earthenware",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CRAFTING_TABLE).sound(SoundType.STONE)));

    //Fluid sources

    public static final RegistryObject<LiquidBlock> WINE_BLOCK = BLOCKS.register("wine_block",
            () -> new LiquidBlock(ModFluids.SOURCE_WINE, BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable().noCollission()));

    public static final RegistryObject<LiquidBlock> BAT_BLOCK = BLOCKS.register("bat_block",
            () -> new LiquidBlock(ModFluids.SOURCE_BAT, BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable().noCollission()));

    public static final RegistryObject<LiquidBlock> ETH_BLOCK = BLOCKS.register("eth_block",
            () -> new LiquidBlock(ModFluids.SOURCE_ETH, BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable().noCollission()));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }


    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
