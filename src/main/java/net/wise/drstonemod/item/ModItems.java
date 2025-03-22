package net.wise.drstonemod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.wise.drstonemod.DrStoneMod;
import net.wise.drstonemod.item.custom.MetalDetectorItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DrStoneMod.MOD_ID);

    // Items being added
    public static final RegistryObject<Item> DRAGO = ITEMS.register("drago",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> REJUVENATING_FLUID = ITEMS.register("rejuvenating_fluid",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEMP = ITEMS.register("hemp",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(100)));

    public static final RegistryObject<Item> SULFA_DRUG = ITEMS.register("sulfa_drug",
            () -> new Item(new Item.Properties().food(ModFoods.SULFA_DRUG)));


    // Needed to add items
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
