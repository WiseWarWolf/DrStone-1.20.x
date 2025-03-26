package net.wise.drstonemod.item;

import cech12.bucketlib.api.item.UniversalBucketItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.FlintAndSteelItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.wise.drstonemod.DrStoneMod;
import net.wise.drstonemod.fluid.ModFluids;
import net.wise.drstonemod.item.custom.MetalDetectorItem;

public class ModItems{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DrStoneMod.MOD_ID);

    // Basic Items
    public static final RegistryObject<Item> DRAGO = ITEMS.register("drago",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REJUVENATING_FLUID = ITEMS.register("rejuvenating_fluid",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEMP = ITEMS.register("hemp",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SALT = ITEMS.register("salt",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ROPE = ITEMS.register("rope",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PLANT_FIBER = ITEMS.register("plant_fiber",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GRASS_SKIRT = ITEMS.register("grass_skirt",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> UNFIRED_CLAY_POT = ITEMS.register("unfired_clay_pot",
            () -> new Item(new Item.Properties()));

    // Advanced Items
    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(100)));

    public static final RegistryObject<Item> BOW_DRILL = ITEMS.register("bow_drill",
            () -> new FlintAndSteelItem(new Item.Properties().durability(100)));

    public static final RegistryObject<Item> CLAY_POT = ITEMS.register("clay_pot",
            () -> new UniversalBucketItem(new UniversalBucketItem.Properties().stacksTo(16).tab(ModCreativeModTabs.DRSTONE_TAB.getKey())));

    public static final RegistryObject<Item> SULFA_DRUG = ITEMS.register("sulfa_drug",
            () -> new Item(new Item.Properties().food(ModFoods.SULFA_DRUG)));

    //FLUIDS

    public static final RegistryObject<Item> WINE_POT = ITEMS.register("wine_pot",
            () -> new BucketItem(ModFluids.SOURCE_WINE,  new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> BAT_POT = ITEMS.register("bat_pot",
            () -> new BucketItem(ModFluids.SOURCE_BAT,  new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> ETH_POT = ITEMS.register("eth_pot",
            () -> new BucketItem(ModFluids.SOURCE_ETH,  new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> BUCKET_ETH = ITEMS.register("bucket_eth",
            () -> new BucketItem(ModFluids.SOURCE_ETH,  new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));

    public static final RegistryObject<Item> BUCKET_BAT = ITEMS.register("bucket_bat",
            () -> new BucketItem(ModFluids.SOURCE_BAT,  new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));

    public static final RegistryObject<Item> BUCKET_WINE = ITEMS.register("bucket_wine",
            () -> new BucketItem(ModFluids.SOURCE_WINE,  new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));

    // Needed to add items
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
