package net.wise.drstonemod.fluid;

import cech12.bucketlib.BucketLib;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.wise.drstonemod.DrStoneMod;
import net.wise.drstonemod.block.ModBlocks;
import net.wise.drstonemod.item.ModItems;

public class ModFluids extends Fluids{
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, DrStoneMod.MOD_ID);

    public static final RegistryObject<FlowingFluid> SOURCE_WINE = FLUIDS.register("wine_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.WINE_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_WINE = FLUIDS.register("flowing_wine",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.WINE_FLUID_PROPERTIES));


    public static final ForgeFlowingFluid.Properties WINE_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.WINE_FLUID_TYPE, SOURCE_WINE, FLOWING_WINE)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.WINE_BLOCK).bucket(ModItems.WINE_POT);

    public static final RegistryObject<FlowingFluid> SOURCE_BAT = FLUIDS.register("bat_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.BAT_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_BAT = FLUIDS.register("flowing_bat",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.BAT_FLUID_PROPERTIES));


    public static final ForgeFlowingFluid.Properties BAT_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.BAT_FLUID_TYPE, SOURCE_BAT, FLOWING_BAT)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.BAT_BLOCK).bucket(ModItems.BAT_POT);

    public static final RegistryObject<FlowingFluid> SOURCE_ETH = FLUIDS.register("eth_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.ETH_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_ETH = FLUIDS.register("flowing_eth",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.ETH_FLUID_PROPERTIES));


    public static final ForgeFlowingFluid.Properties ETH_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.ETH_FLUID_TYPE, SOURCE_ETH, FLOWING_ETH)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.ETH_BLOCK).bucket(ModItems.ETH_POT);


    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
