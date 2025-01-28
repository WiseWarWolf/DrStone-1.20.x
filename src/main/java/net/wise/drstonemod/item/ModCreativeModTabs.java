package net.wise.drstonemod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.wise.drstonemod.DrStoneMod;
import net.wise.drstonemod.block.ModBlocks;

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

                        //Blocks
                        pOutput.accept(ModBlocks.BUNDLE_OF_HEMP.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
