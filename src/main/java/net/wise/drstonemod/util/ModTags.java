package net.wise.drstonemod.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.wise.drstonemod.DrStoneMod;

public class ModTags
{
    public static class Blocks
    {
        public static final TagKey<Block> METAL_DETECTOR_VALUABLES = tag("metal_detector_valuables");

        private static TagKey<Block> tag(String name)
        {
            return BlockTags.create(new ResourceLocation(DrStoneMod.MOD_ID, name));
        }
    }

    public static class Items
    {
        private static TagKey<Item> tag(String name)
        {
            return ItemTags.create(new ResourceLocation(DrStoneMod.MOD_ID, name));
        }
    }

    public static class Fluids
    {
        public static final TagKey<Fluid> BUCKET_PICKUP = tag("bucket_pickup");

        private static TagKey<Fluid> tag(String name)
        {
            return FluidTags.create(new ResourceLocation(DrStoneMod.MOD_ID, name));
        }
    }
}
