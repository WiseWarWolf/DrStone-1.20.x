package net.wise.drstonemod.item;


import cech12.bucketlib.BucketLib;
import cech12.bucketlib.util.BucketLibUtil;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.wise.drstonemod.DrStoneMod;
import net.wise.drstonemod.block.ModBlocks;
import net.wise.drstonemod.fluid.ModFluids;

public class ModCreativeModTabs
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DrStoneMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> DRSTONE_TAB = CREATIVE_MODE_TABS.register("drstone_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.DRAGO.get()))
                    .title(Component.translatable("creativetab.drstone_tab"))
                    .displayItems((pParameters, pOutput) ->{

                        // Items
                        pOutput.accept(ModItems.DRAGO.get());
                        pOutput.accept(ModItems.REJUVENATING_FLUID.get());
                        pOutput.accept(ModItems.HEMP.get());
                        pOutput.accept(ModItems.UNFIRED_CLAY_POT.get());
                        pOutput.accept(ModItems.METAL_DETECTOR.get());
                        pOutput.accept(ModItems.SULFA_DRUG.get());
                        pOutput.accept(ModItems.BOW_DRILL.get());
                        pOutput.accept(ModItems.ROPE.get());
                        pOutput.accept(ModItems.SALT.get());
                        pOutput.accept(ModItems.BUCKET_BAT.get());
                        pOutput.accept(ModItems.BUCKET_ETH.get());
                        pOutput.accept(ModItems.BUCKET_WINE.get());
                        pOutput.accept(ModItems.PLANT_FIBER.get());

                        //Armor
                        pOutput.accept(ModItems.GRASS_SKIRT.get());

                        //Blocks
                        pOutput.accept(ModBlocks.BUNDLE_OF_HEMP.get());
                        pOutput.accept(ModBlocks.BLOCK_OF_SALT.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
