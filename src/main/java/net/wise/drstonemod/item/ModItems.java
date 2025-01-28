package net.wise.drstonemod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.wise.drstonemod.DrStoneMod;

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

    // Needed to add items
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
